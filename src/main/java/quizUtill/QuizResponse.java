package quizUtill;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import DbCon.DBConnection;
import Entities.User;
import dao.ResultDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/submitQuiz")
public class QuizResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public QuizResponse() {
        // TODO Auto-generated constructor stub
    }

	private int calculateScore( String quizName , List<String> userAnswer) {
		int score  = 0;
		
		 //change userAnswer to look like real answer
        for (int i = 0; i < userAnswer.size(); i++) {
            String ans = userAnswer.get(i);
            if (ans.equals("option 1")) {
                userAnswer.set(i, "A");
            } else if (ans.equals("option 2")) {
                userAnswer.set(i, "B");
            } else if (ans.equals("option 3")) {
                userAnswer.set(i, "C");
            } else if (ans.equals("option 4")) {
                userAnswer.set(i, "D");
            }
        }
        
        List<String> answer = QuizHandler.answers(quizName);
        
        for(int i=0 ; i < answer.size();i++){
           if(userAnswer.get(i)!= null) {
        	   
        	   try{
                   if(answer.get(i).equals(userAnswer.get(i))){
                       score++;
                   }
               }catch (Exception e ){
                   break;
               }
        	   
           }
        }
        
        
		return score;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		User user = (User) request.getSession().getAttribute("userObj");
//        String userEmail =  user.getEmail();          
//
//        if (userEmail == null || userEmail.isEmpty()) {
//            response.sendRedirect("login.jsp"); 
//            return;
//        }
        
        User user = (User) request.getSession().getAttribute("userObj");
		
		String userEmail =  "";      

        if (user==null || user.getEmail() == null || user.getEmail().isEmpty()) {
            response.sendRedirect("login.jsp"); 
            return;
        }else {
        	userEmail = user.getEmail();
        }
        
        
		String[] userArray = new String[21];
		
		//this enumerator code copied from stackoverflow ! 
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println(parameterNames.hasMoreElements());
        
        int i = 0;
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
//            System.out.println("Parameter: " + paramName);
            for (String paramValue : paramValues) {
            	userArray[i]=paramValue;
            	i++;
//                System.out.println("  Value: " + paramValue);
            }
        }
        
        
        
       
        List<String> userAnswer = new ArrayList<>(Arrays.asList(userArray));
        userAnswer.remove(0);
//        System.out.println(userAnswer);
        


			
        String quizName = request.getParameter("quizName");
		
			int score = calculateScore(quizName,userAnswer); 

		
		 	request.setAttribute("score", score);
		 	
		 
	        Connection conn = DBConnection.getConn();
	        ResultDao resultDao = new ResultDao(conn);
	        resultDao.addResult(userEmail,score,quizName);
	       

	        // Forward the request to the results.jsp page
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/score.jsp");
	        dispatcher.forward(request, response);
		
		
		
	}


}

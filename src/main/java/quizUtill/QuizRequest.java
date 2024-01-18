package quizUtill;

import java.io.IOException;
import java.util.List;

import Entities.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/QuizRequest")
public class QuizRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public QuizRequest() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("userObj");
		
		String userEmail =  "";      

        if (user==null || user.getEmail() == null || user.getEmail().isEmpty()) {
            response.sendRedirect("login.jsp"); 
            return;
        }else {
        	userEmail = user.getEmail();
        }
		String quizName =request.getParameter("quizName");

		QuizHandler quizHandler = new QuizHandler();
		
			
	        List<List<String>> quizList = quizHandler.listofQuestions(quizName);
	        

	        // Set the result list as a request attribute
	        request.setAttribute("quizList", quizList);
	        request.setAttribute("quizName", quizName);
	        

	        // Forward the request to the results.jsp page
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/quiz.jsp");
	        dispatcher.forward(request, response);
		
		
		
	}



}

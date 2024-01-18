package User;

import java.io.IOException;

import DbCon.DBConnection;
import Entities.User;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserSignUp")
public class UserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserSignUp() {
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub        	
        User user = new User() ;
        // id is auto incremented ! uses this for your db to alter 
        //ALTER TABLE user_details MODIFY user_id INT AUTO_INCREMENT;

		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		
		UserDao userDao = new UserDao(DBConnection.getConn());
		
		boolean isInserted = userDao.insertUser(user);

		if(isInserted) {
			response.sendRedirect("login.jsp"); 
			System.out.println("User inserted ! signed up");
		}else {
			System.out.println("user not registerd ! ");
			String errorMessage = "Error: Unable to register user. Please try again. <a style=\"color:black; font-weight: bold; font-style: italic;\" href=\"signup.jsp\" class=\"text-decoration-none\">Click here!</a>";
			    errorMessage = java.net.URLEncoder.encode(errorMessage, "UTF-8");
			    response.sendRedirect("error.jsp?message=" + errorMessage);
		}
		
		
	}

}

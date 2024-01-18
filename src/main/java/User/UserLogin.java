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
import jakarta.servlet.http.HttpSession;


@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public UserLogin() {
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		UserDao userDAO = new UserDao(DBConnection.getConn());
		User user = userDAO.loginUser(email, password);
		
		if (user!=null) {
			session.setMaxInactiveInterval(1800);//30 min 
			session.setAttribute("userObj",user);
			resp.sendRedirect("index.jsp"); 
		}
		else {
			session.setAttribute("errorMsg","Invalid email or password");
			resp.sendRedirect("login.jsp"); 
		}
	}

}

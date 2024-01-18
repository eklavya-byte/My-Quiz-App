package User;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import DbCon.DBConnection;
import Entities.Result;
import Entities.User;
import dao.ResultDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resultList")
public class UserResult extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	User user = (User) request.getSession().getAttribute("userObj");
        String userEmail =  user.getEmail();             //(String) request.getSession().getAttribute("userEmail");

        if (userEmail == null || userEmail.isEmpty()) {
            response.sendRedirect("login.jsp"); 
            return;
        }

        Connection conn = DBConnection.getConn(); 

        // Instantiate ResultDao and retrieve results
        ResultDao resultDao = new ResultDao(conn);
        List<Result> resultList = resultDao.getAllResults(userEmail);

        // Set the result list as a request attribute
        request.setAttribute("resultList", resultList);

        // Forward the request to the results.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

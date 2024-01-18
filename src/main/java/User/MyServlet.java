package User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Random;

import DbCon.DBConnection;
import Entities.User;
import dao.UserDao;


//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        response.setContentType("text/html");


        Connection con = DBConnection.getConn();

//        User user = new User(new Random().nextInt(9 - 1 + 1) + 1,"Prem", "premascii@gmail.com","12345");
        User user = new User((new Random().nextInt(9 - 1 + 1) + 1),"Prem", "premascii@gmail.com","12345");


        UserDao userDao = new UserDao(con);
        boolean result = userDao.insertUser(user);

        if (result) {
            System.out.println("User inserted into the database");
        } else {
            System.out.println("User not inserted, check connection!");
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>My Servlet HTML Response</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello from MyServlet!</h1>");
            out.println("<p>This is an example HTML response from a servlet.</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

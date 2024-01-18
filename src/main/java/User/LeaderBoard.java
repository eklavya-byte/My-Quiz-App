package User;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import DbCon.DBConnection;

import dao.Leader;
import dao.ResultDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/leaderBoard")
public class LeaderBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LeaderBoard() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DBConnection.getConn(); 

        ResultDao resultDao = new ResultDao(conn);
        List<Leader> resultList = resultDao.getLeaderBoard();

        request.setAttribute("leaderboard", resultList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/leaderboard.jsp");
        dispatcher.forward(request, response);	
        
	}


}

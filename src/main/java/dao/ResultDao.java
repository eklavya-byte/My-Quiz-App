package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Result;

public class ResultDao {

	
	private Connection conn;
	
	public ResultDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Result> getAllResults(String email) {
	    List<Result> resultList = new ArrayList<>();

	    try {

	        String sql = "select * from quiz_app.result where result_email=?";

	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, email);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            Result result = new Result(resultSet);
	            resultList.add(result);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}
	
	public List<Leader> getLeaderBoard() {
	    List<Leader> leaderboardList = new ArrayList<>();

	    try {
	        
	        String sql = "SELECT u.user_name AS quizName, MAX(r.quiz_score) AS highestScore\r\n"
	        		+ "FROM user_details u\r\n"
	        		+ "JOIN result r ON u.user_email = r.result_email\r\n"
	        		+ "GROUP BY r.result_email, u.user_name\r\n"
	        		+ "ORDER BY highestScore DESC\r\n"
	        		+ "LIMIT 20;\r\n"
	        		+ "";

	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            Leader result = new Leader(resultSet);
	            leaderboardList.add(result);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return leaderboardList;
	}
	
	public boolean addResult(String result_email,int quiz_score,String quiz_name ) {
		
		
		String[] quizNameArray=quiz_name.split("\\.");
		String name =quizNameArray[0];
		boolean result = false;
		String sql = "INSERT INTO quiz_app.result (quiz_name, quiz_score, result_email) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, quiz_score);
			pstmt.setString(3, result_email);
			result =pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
		
	}

}

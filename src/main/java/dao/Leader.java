package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Leader {

	private String quizName;
	private int quizScore;
	
	public Leader(ResultSet resultSet) throws SQLException {
		 this.quizName = resultSet.getString("quizName");  
		    this.quizScore = resultSet.getInt("highestScore"); 

	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public int getQuizScore() {
		return quizScore;
	}

	public void setQuizScore(int quizScore) {
		this.quizScore = quizScore;
	}

	public Leader(String quizName, int quizScore) {
		super();
		this.quizName = quizName;
		this.quizScore = quizScore;
	}

	public Leader() {
		super();
	}
	

}

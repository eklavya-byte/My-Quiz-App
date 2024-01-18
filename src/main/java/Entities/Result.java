package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Result {
    private int id;
    private String quizName;
    private String quizScore;

    public Result() {
        // Default constructor
    }

    public Result(int id, String quizName, String quizScore) {
        this.id = id;
        this.quizName = quizName;
        this.quizScore = quizScore;
    }

    // Constructor that takes a ResultSet as an argument for initialization
    public Result(ResultSet resultSet) throws SQLException {
        this.quizName = resultSet.getString("quiz_name");
        this.quizScore = resultSet.getString("quiz_score");
    }
    
    
    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(String quizScore) {
        this.quizScore = quizScore;
    }

    @Override
    public String toString() {
        return "Result [id=" + id + ", quizName=" + quizName + ", quizScore=" + quizScore + "]";
    }
}

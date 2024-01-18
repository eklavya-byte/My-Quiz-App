package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import Entities.User;

public class UserDao {

	
	
	private Connection conn;
	
	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean insertUser(User user) {
		boolean f = false;

		try {
			String sql = "insert into user_details(user_id, user_name, user_email, user_password) values(?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2,user.getName() );
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4,user.getPassword());

			pstmt.executeUpdate();

			f = true; // if query execute successfully then f becomes true otherwise false...

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
		
	}
	
	public User loginUser(String email, String password) {
	    User user = null;

	    String sql = "SELECT * FROM user_details WHERE user_email=? AND user_password=?";
	    
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, email);
	        pstmt.setString(2, password);

	        try (ResultSet result = pstmt.executeQuery()) {
	            if (result.next()) {
	                user = new User();
	                user.setId(result.getInt("user_id"));
	                user.setName(result.getString("user_name"));
	                user.setEmail(result.getString("user_email"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

}

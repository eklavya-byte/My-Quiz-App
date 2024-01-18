package DbCon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection conn;
	
	public static Connection getConn() {
		
		try {
			
			//loading the driver class 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create a connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your-db-name\",\"db-user-id \",\"password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return conn;
	}
}


package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil { // Factory Class

	
	
	public static Connection   getDBConnection() { // Factory Method
		
		Connection conn = null;
		
		try {
			//step1
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2

		 conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hexaware_db", "root", "Ronny121");

		}
		 catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return conn;
		
	}
	
	
}

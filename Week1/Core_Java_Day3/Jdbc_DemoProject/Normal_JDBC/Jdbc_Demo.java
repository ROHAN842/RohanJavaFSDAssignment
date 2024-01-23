package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

public class Jdbc_Demo {

	public static void main(String[] args) {

		Connection conn = null;
		
		// step1

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2

		 conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hexaware_db", "root", "Ronny121");

			// step3

//			String insert = "insert into Employees(eid,ename,salary,job) values(112,'Don',70000,'MD')";
//
//			Statement stmt = conn.createStatement();
//
//			int count = stmt.executeUpdate(insert);
//
//			System.out.println(count + " records effected");
			
			
			//String query = "Update "
			
			String update = "update dept set dname = 'Mo' , location = 'Alkapuri' where dno = 80";
			
			Statement stmt1 = conn.createStatement();

			int count1 = stmt1.executeUpdate(update);

			System.out.println(count1 + " records effected");
			
			// Demo Callable Statement Code present below
//			CallableStatement cstmt = (CallableStatement) conn.prepareCall("{CALL Pro_Case()}");
//			cstmt.setInt(1, 140);
//			cstmt.execute();
			
			
			//String query = "Delete"
			
			System.out.println("Below is the delete one count statement");
			
//			String delete = "delete from dept where dno = 90";
//			
//			Statement stmt2 = conn.createStatement();
//
//			int count2 = stmt2.executeUpdate(delete);
//
//			System.out.println(count2 + " records effected");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
			conn.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}

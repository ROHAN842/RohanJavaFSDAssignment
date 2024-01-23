package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PSDemo {

	public static void main(String[] args) {

		Connection conn = DBUtil.getDBConnection();

		// INSERT
//		String insert = "insert into dept values(?,?,?)"; // ? positional parameters
//
//		
//		  try { PreparedStatement pstmt = conn.prepareStatement(insert);
//		  
//		 
//		  pstmt.setInt(1, 100);
//		  pstmt.setString(2,"Packaging");
//		  pstmt.setString(3,"Dewas");
//		 
//		  
//		  int count = pstmt.executeUpdate();
//		  
//		  System.out.println(count);
//		 
//		  } catch (SQLException e) { // TODO Auto-generated catch block
//		  e.printStackTrace(); }
		 

		// UPDATE

		
//		  String update = "update dept set dname = ? , location = ? where dno = ?";
//		  
//		  try { PreparedStatement pstmt = conn.prepareStatement(update);
//		  
//		  pstmt.setString(1,"BigTransportation");
//		  pstmt.setString(2, "Greater Indore");
//		  pstmt.setInt(3, 90);
//		  
//		  
//		  int count = pstmt.executeUpdate();
//		  
//		  System.out.println("record update is "+count);
//		  
//		  } catch (SQLException e) { // TODO Auto-generated catch block
//		  e.printStackTrace(); }
		 
		
		// SELECT BY DNO
		
		String selectById = "select dno,dname,location from dept where dno = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectById);

					pstmt.setInt(1, 90);

				ResultSet rs =		pstmt.executeQuery();
				
				while(rs.next()) {
					
			System.out.println(rs.getInt("dno")  +" "+rs.getString("dname") +"  "+rs.getString("location"));
				}
				
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// SELECT ALL
		
		System.out.println("Below one is example of Select All");
		
		String selectAll = "select dno,dname,location from dept";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);

					//pstmt.setInt(1, 90);

				ResultSet rs =		pstmt.executeQuery();
				
				while(rs.next()) {
					
			System.out.println(rs.getInt("dno")  +" "+rs.getString("dname") +"  "+rs.getString("location"));
				}
				
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//DELETE
		
//		String deleteById = "delete from dept where dno = ?";
//
//		try {
//		    PreparedStatement pstmt = conn.prepareStatement(deleteById);
//
//		    // Set the value for the parameter in the DELETE statement
//		    pstmt.setInt(1, 100);
//
//		    // Execute the DELETE statement using executeUpdate() instead of executeQuery()
//		    int rowsAffected = pstmt.executeUpdate();
//
//		    // Check if any rows were affected
//		    if (rowsAffected > 0) {
//		        System.out.println("Record deleted successfully.");
//		    } else {
//		        System.out.println("No record found with the specified dno.");
//		    }
//
//		} catch (SQLException e) {
//		    // Handle any SQL exceptions
//		    e.printStackTrace();
//		}

		
		
		
		
		
		
		
		
		
	}

}

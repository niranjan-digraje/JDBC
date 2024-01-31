package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Demo {

	public static void main(String[] args) throws Exception {
		// 1)register the driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//another way to register the driver
		//Driver driver = new Driver();
		//DriverManager.registerDriver(driver);
		
		//----------------------------------------------------------------
		
		// 2)create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/niranjanjdbc","root","@Nsd1908");
		
		//----------------------------------------------------------------
		
		// 3)create statement
		// statement truck
		//Statement st = con.createStatement();
		//---------------------------------------
		// prepared statement truck
		//	PreparedStatement ps = con.prepareStatement("insert into employee values (?,?,?)");
		//	ps.setInt(1, 4);
		//	ps.setString(2, "soham");
		//	ps.setInt(3, 4000);
		
		PreparedStatement ps = con.prepareStatement("select * from employee");
		
		//----------------------------------------------------------------
		
		// 4)add query to statement
		
		// output 1 or 0 || true=1, false=0
		//int result = st.executeUpdate("insert into employee (id,name,salary) values (102,'nikhil',1400)");
		//int result = ps.executeUpdate();
		//---------------------------------------
		// output data || use rs.next
		// ResultSet rs = st.executeQuery("select * from employee");
		ResultSet rs = ps.executeQuery();
		
		//----------------------------------------------------------------
		
		// 5)result 
		//System.out.println("data stored into database successfully "+result);
		//---------------------------------------
		while(rs.next()) {
			int empid = rs.getInt("id");
			String empname = rs.getString("name");
			int sal = rs.getInt("salary");
			System.out.println("ID : "+empid+" | Name : "+empname+" | Salary : "+sal);  
		}
		
		//----------------------------------------------------------------
		
		// 6) connection close
		con.close();
	}

}

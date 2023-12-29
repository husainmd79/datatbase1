package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Customers_Table {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	@BeforeClass
	public void setUp() throws SQLException
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	}
	@AfterClass
	public void tearDown() throws SQLException
	{
		con.close();
	}
	@Test
	public void Test_getData_Customer() throws SQLException
	{
		stmt=con.createStatement();
		rs=stmt.executeQuery("select customer_id,first_name,last_name from customers;");
		while(rs.next())
		{
			int cid=rs.getInt("customer_id");
			String name=rs.getString("first_name");
			String lname=rs.getString("last_name");
			System.out.println(cid+"    "+name+"   "+lname);
			
		}
	}
			

}














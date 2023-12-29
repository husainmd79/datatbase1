package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Find_husain_Student {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	@BeforeClass
	void setUp() throws SQLException
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	}
	@AfterClass
	void tearDown() throws SQLException
	{
		con.close();
	}
	@Test
	void Test_FindName() throws SQLException
	{
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from student");
	    rs.next();
		while(rs.next())
		{
		String s=rs.getString("fullname");
		Double sal=rs.getDouble("salary");
		System.out.println(s  +"  "+  sal);
		}
		
	}

}

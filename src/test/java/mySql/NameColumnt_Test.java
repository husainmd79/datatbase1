package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NameColumnt_Test {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	@BeforeClass
	void set() throws SQLException
	{
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	}
	@AfterClass
	void tearDown() throws SQLException
	{
		con.close();
	}
	@Test(priority=1)
	void Test_name_column() throws SQLException
	{
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from student where sname='ali'");
		rs.next();
		Assert.assertEquals(rs.getString("sname"), "ali");
	}

}

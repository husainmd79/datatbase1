package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Get_Student_table {
	Connection con;
	Statement stmt;
	ResultSet rs;
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
	@Test(priority=1)
	public void Test_getStudent_data() throws SQLException
	{
		String data="select * from student";
		stmt=con.createStatement();
		rs=stmt.executeQuery(data);
		while(rs.next())
		{
			int ex_sno=rs.getInt("sno");
			String ex_name=rs.getString("sname");
			int ex_marks=rs.getInt("marks");
			String ex_fullname=rs.getString("fullname");
			Double ex_salary=rs.getDouble("salary");
			String ex_grade=rs.getString("grade");
			System.out.println(ex_sno+ " " +ex_name+  "  " +ex_marks+ "  " +ex_fullname+ "  " +ex_salary+ "  " +ex_grade);
		}
	}
	
	
	@Test(priority=2)
	public void Test_getColumnFromStudent() throws SQLException
	{
		stmt=con.createStatement();
		rs=stmt.executeQuery("select sno,sname,salary from student");
		while(rs.next())
		{
			int sid=rs.getInt("sno");
			String name=rs.getString("sname");
			Double sal=rs.getDouble("salary");
			System.out.println(sid+  "  "+ name+ "  "+ sal);
		}
	}
	@Test(priority=3)
	public void Test_getCityFromStudent() throws SQLException
	{
		stmt=con.createStatement();
		String s="select sname from student where sname='ali'";
		rs=stmt.executeQuery(s);
		rs.next();
		String name=rs.getString("sname");
		System.out.println(name);
		
	}
	@Test(priority=4)
	public void  Test_maxSalaryFromStudent() throws SQLException
	{
		String query="select min(salary) from student";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		rs.next();
		Double sal=rs.getDouble("min(salary)");
		System.out.println(sal);
				
	}
	@Test(priority=5)
	public void Test_countFullName() throws SQLException
	{
		String s="select * from student where fullname='abdul'";
		stmt=con.createStatement();
		rs=stmt.executeQuery(s);
		rs.next();
		String name_full=rs.getString("fullname");
		System.out.println(name_full);
		
	}
	@Test(priority=6)
	public void Test_GetnameBySno() throws SQLException
	{
		String s="select * from student where sno=101 and fullname='ahmed'";
		stmt=con.createStatement();
		rs=stmt.executeQuery(s);
		rs.next();
		rs.getString("fullname");
		rs.getInt("sno");
		System.out.println(rs.getString("fullname")+ " "+rs.getInt("sno"));
	}

}
































package mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Get_shipped_order_Test {
	Connection con=null;
	CallableStatement cstmt=null;
	ResultSet rs=null;
	Statement stmt=null;
	@BeforeClass
	public void setUp() throws SQLException
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");
	}
	@AfterClass
	public void tearDown() throws SQLException
	{
		con.close();
	}
	@Test
	public void Test_SProcedure_Paramiter() throws SQLException
	{
		cstmt=con.prepareCall("{call  countNumberOfShipped(?,?,?,?,?)}");
		cstmt.setInt(1, 141);
		
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.INTEGER);
		cstmt.registerOutParameter(5, Types.INTEGER);
		cstmt.executeQuery();
		
		int shipped=cstmt.getInt(2);
		int cancelled=cstmt.getInt(3);
		int resolved=cstmt.getInt(4);
		int disputed=cstmt.getInt(5);
		System.out.println(shipped+"   "+cancelled+"  "+resolved+"  "+disputed);
		
	}

}













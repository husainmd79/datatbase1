package mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_StoreP_WithParameter {
	Connection con=null;
	CallableStatement cstmt=null;
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
	public void test_StorePro_WithParameter() throws SQLException
	{
		cstmt=con.prepareCall("{call  count_country_customer(?,?,?,? )}");
		cstmt.setInt(1, 101);
		
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.INTEGER);
		cstmt.executeQuery();
		
		
		int bangladesh=cstmt.getInt(2);
		int usa=cstmt.getInt(3);
		int canada=cstmt.getInt(4);
		System.out.println(+bangladesh+  "  "   +usa+  "   " +canada);
		
		stmt=con.createStatement();
		rs=stmt.executeQuery("select (select count(*) as 'bangladesh' from customers where customer_id=101 and country='bangladesh') as bangladesh,"
				+ "(select count(*) as 'usa' from customers where customer_id=101 and country='usa')as usa,"
				+ "(select count(*) as 'canada' from customers where customer_id=101 and country='canada')as canada;");
		rs.next();
		int exp_bang=rs.getInt("bangladesh");
		int exp_usa=rs.getInt("usa");
		int exp_canada=rs.getInt("canada");
		
		if(bangladesh==exp_bang && usa==exp_usa && canada==exp_canada)
		
			Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
		
		
		
	}

}


























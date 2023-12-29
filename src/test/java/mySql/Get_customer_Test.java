package mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Get_customer_Test {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	CallableStatement cstmt=null;
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
	public void Test_SP_Getcustomer() throws SQLException
	{
		cstmt=con.prepareCall("{Call get_customers()}");
		rs=cstmt.executeQuery();
		
		stmt=con.createStatement();
		rs1=stmt.executeQuery("select * from customers");
		Assert.assertEquals(compaireSprocedure(rs,rs1),true);
	}
	public boolean compaireSprocedure(ResultSet result,ResultSet result1) throws SQLException
	{
		while(result.next())
		{
			result1.next();
			int count=result.getMetaData().getColumnCount();
			for(int i=1; i<=count; i++)
			{
				if(StringUtils.equals(result.getString(i),result1.getString(i)));
				return true;
					
			}
		}
		return false;
	}

}



















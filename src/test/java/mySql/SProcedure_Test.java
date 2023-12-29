package mySql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mysql.cj.util.StringUtils;

public class SProcedure_Test {
	Connection con=null;
	CallableStatement cstmt=null;
	ResultSet rs1=null;
	Statement stmt=null;
	ResultSet rs2=null;
	
	@BeforeClass
	void setUp() throws SQLException
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");
	}
	@AfterClass
	void tearDown() throws SQLException
	{
		con.close();
	}
	@Test(priority=1)
	void Test_StoreProcedureExist() throws SQLException
	{
		cstmt=con.prepareCall("{call selectAllCustomer}");
		rs2=cstmt.executeQuery();
		
		stmt=con.createStatement();
		rs1=stmt.executeQuery("select * from customers");
		Assert.assertEquals(filterSp(rs1,rs2), true);
		
	}
	public boolean filterSp(ResultSet result1,ResultSet result2) throws SQLException
	{
		while(result2.next())
		{
         result1.next();
         int count =result2.getMetaData().getColumnCount();
         for(int i=1; i<=count; i++)
         {
          if(StringUtils.nullSafeEqual(result2.getString(i), result1.getString(i)));
          return true;
         }

		
		
	}
		return false;
	

}
}


















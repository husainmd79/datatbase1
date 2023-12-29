package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_DqlSelect 

{
	public static void main(String[] args) throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement stmt=con.createStatement();
		String s="select sno,sname from student";
		ResultSet rs=stmt.executeQuery(s);
		while(rs.next())
		{
			int sid=rs.getInt("sno");
			String fname=rs.getString("sname");
			System.out.println(sid+"  "+fname);
		}
	}

}

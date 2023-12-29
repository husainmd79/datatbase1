package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJdbc_DML {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
		
		Statement stmt=con.createStatement();
		//String s="INSERT INTO a value(13,'xyz',null)";
		String s="UPDATE a SET MARKS=100 WHERE FIRST_NAME='XYZ'";
		stmt.execute(s);
		System.out.println("my query is executed");

	}

}


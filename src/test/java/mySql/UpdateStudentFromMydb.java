package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentFromMydb {

	public static void main(String[] args) throws SQLException {
	   
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		Statement stmt=con.createStatement();
		//String u="update student set fullname='khan' where sno=103";
		//stmt.execute(u);
		System.out.println("my query is executed");
		String s="insert into student value(101,'salam',95,'ahmed',4500.00,'B')";
		stmt.execute(s);
		String d="delete from student where sno=106";
		stmt.execute(d);
		System.out.println("this is inset value");
		con.close();

	}

}

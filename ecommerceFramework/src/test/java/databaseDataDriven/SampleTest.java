package databaseDataDriven;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTest {
	public static void main(String[] args) throws SQLException {
//		1..load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
//		2..connect to database
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "MyLaptop@1996");
		 System.out.println("connection done");
		 
//		3..create sql statement
		 Statement st=conn.createStatement();
//		4..execute select query and get result
		ResultSet result= st.executeQuery("select * from actor");
		while(result.next())
		{
			System.out.println(result.getString(2)+".... "+ result.getString(4));
		}
		System.out.println("hii tillquerydone");
//		5..close the connection
		conn.close();
	}

}

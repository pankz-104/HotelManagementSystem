package hotel.management.system;

/*
 * java database connectivity
 * steps
 * 1- Register the driver class
 * 2- Create the connection object
 * 3- Create the statement object 
 * 4- Execute the query
 * 5- Close the connection object
 */

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	
	public Conn(){
		try {
			
			// references the external added mysql jar
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///projecthms","root","root");
			s = c.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package view.common;

/*
public class DataConnect {
    public DataConnect() {
        super();
    }
}
*/

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

	public static Connection getConnection() {
		try {
		    System.out.println("tryyyyyyy");
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con = DriverManager.getConnection(
					//"jdbc:mysql://localhost:3306/cardb", "pankaj", "pankaj123");
                        Connection con = DriverManager.getConnection(
		                    "jdbc:oracle:thin:fusion/fusion@slcap051.us.oracle.com:1605:ems2584");                    
		    
		    System.out.println("here..... con is "+ con);
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}

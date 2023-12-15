package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void initConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {		
			
			System.out.println("DB Driver를 찾을 수 없습니다");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","qwe1124");
			
			System.out.println("MySQL Connection Success");
		} catch (SQLException e) {
			
			System.out.println("MySQL에 연결할 수 없습니다");
			e.printStackTrace();
		}
		return conn;
	   }
	
	}


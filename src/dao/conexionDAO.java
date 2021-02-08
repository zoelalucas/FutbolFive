package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexionDAO {
	
	public static java.sql.Connection conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/futbol5?useSSL=true", "root", "");
			return con;
		} catch (Exception e) {
			System.out.println("ERROR = " + e+"al conectar al servidor");
			return null;
		}
	}
}

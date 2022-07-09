package coffeeJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class testBD {
	public static final String JBDC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/market";
	public static String USER = "root";
	public static String PASS = "market";
	private static Connection conn = null;
	private static Statement stmt = null;
		
	public static void main(String[] args) {
		try { 
			Class.forName(JBDC_DRIVER);
			System.out.println("Conectando...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("creando statement");
			stmt = conn.createStatement();
			String sql = "select usuario from usuarios where usuario = 'asdasd';";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("existe"); 
			}
			else {
				System.out.println("no existe");
			}
			String select = rs.getString("usuario");
			System.out.println(select); 
			stmt.close();
			conn.close(); 
		} 
		catch (Exception e) {
			System.err.println("hubo un error");
		}
		System.out.println("termino");	
	}
}


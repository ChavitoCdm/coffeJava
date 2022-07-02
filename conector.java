package coffeeJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class conector {
	public static final String JBDC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/market";
	public static String USER = "root";
	public static String PASS = "market";
	
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JBDC_DRIVER);
			System.out.println("Conectando...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("creando statement");
			stmt = conn.createStatement();
			String sql = consultarCarrito(2);
			ResultSet rs = stmt.executeQuery(sql);
			stmt.close();
			conn.close();
			System.out.println(rs);
		}
		catch (Exception e) {
			System.out.println("hubo un error");
		}
		System.out.println("termino");
		
	}

	public static String agregarCarrito() {
		return "INSERT INTO `cart` (`idcart`, `item01`) VALUES ('2', '452321982574')";
	}
	
	public static String consultarCarrito(int idcart) {
		String consulta = "SELECT * from market.cart where idcart = " + idcart;
		System.out.println(consulta);
		return consulta;
	}
}
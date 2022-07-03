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
	private static Connection conn = null;
	private static Statement stmt = null;
	
	public static void abrir() {
		try { 
			Class.forName(JBDC_DRIVER);
			System.out.println("Conectando...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("creando statement");
			stmt = conn.createStatement();
		}
		catch (Exception e) {
			System.out.println("hubo un error");
		}
	}
	
	public static void main(String[] args) {
		try { 
			abrir();
			String sql = consultarCarrito(4);
			ResultSet rs = stmt.executeQuery(sql);
			//sql = agregarCarrito();
			//stmt.executeUpdate(sql);
			rs.next();
			//System.out.println(rs.getString("idCart"));
			for (int i = 2; i<=31; i = i+1) {
				String item = rs.getString(i);
				System.out.println(item);
				//System.out.println(item.length());
				if (item != null) {
				if (item.length() == 12)
				{
					String cantidad = item.substring(0,1);
					int icantidad = Integer.parseInt(cantidad);
					String idProducto = item.substring(2,8);
					String precio = item.substring(8,12);
					System.out.println(icantidad*10);
					System.out.println(idProducto);
					System.out.println(precio);
					System.out.println("");
				}
				}
			}
			stmt.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println("hubo un error");
		}
		System.out.println("termino");
		
	}
 
	public static String agregarCarrito() {
		return "INSERT INTO cart (idcart, item01) VALUES ('5', '452321982574')";
	}
	
	public static String consultarCarrito(int idcart) {
		String consulta = "SELECT * from market.cart where idcart = " + idcart;
		//System.out.println(consulta);
		return consulta;
	}
	
	public static void agregarAdmin() {
		//agregar admnistrador
		String users = "insert into usuarios values ('admin','mail@mail.com','admin');";
		String admin = "insert into administradores (nombre,usuario) values (0,'gerente','admin');";
	}
	
	public static void agregarCliente() {
		String user = "insert into usuarios values ('turco','mail@mail.com','pass');";
		String cart = "insert into cart (idcart) values ('turco');";
		String clie = "insert into clientes (usuario,nombre,telefeono,direccion,idcart,lastcart) values ('turco','sergio',155123456,'zuviria 200','turco',null);";
		
	}
}







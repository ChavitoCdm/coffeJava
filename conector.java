package coffeeJava;

import coffeeJava.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class conector {
	public static final String JBDC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/market";
	public static String USER = "root";
	public static String PASS = "market";
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//public static void main(String[] args) {}
	
	public static void abrir() {
		try { 
			Class.forName(JBDC_DRIVER);
			//System.out.println("Conectando...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println("creando statement");
			stmt = conn.createStatement();
		}
		catch (Exception e) {
			System.out.println("hubo un error");
		}
	}
	
	public static void prueba() {
		try { 
			abrir();
			String sql = consultarCarrito(4);
			rs = stmt.executeQuery(sql);
			rs.next();
			System.out.println(rs.getString("idCart"));
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
	
	public static void listo()
	{
		try {
			stmt.close();
			conn.close();
			}
		catch (Exception e)
		{
			System.out.println("hubo un error al cerrar stmt o conn");
		}
	}
	
	public static ResultSet consultar(String sql)
	{
		abrir();
		try {
			rs = stmt.executeQuery(sql);
			System.out.println(rs.toString());
			stmt.close();
			conn.close();
		}
		catch (Exception e)
		{
			System.out.println("hubo un error en la consulta");
			return null;
		}
		return rs;
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
		String clie = "insert into clientes (usuario,nombre,telefeono,direccion,lastcart) values ('turco','sergio',155123456,'zuviria 200',,null);";
		
	}
	public static boolean isEmpleado() {
		try { 
			abrir();
			String sql = "select usuario from usuarios where usuario = 'admin';";
			rs = stmt.executeQuery(sql);
			rs.next();	
			String select = rs.getString("usuario");
			System.out.println(select);
			boolean salida = true;
			return salida;
		}
		catch (Exception e) {
			System.out.println("hubo un error");
			return false;
		}
	}
	
	public static usuario usuario(String usr)
	{
		abrir(); 
		usuario salida = new usuario();
		try { 
			String sql = "select * from usuarios where usuario = '" + usr + "';";
			salida.setExist(false);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				salida.setExist(true);
				salida.setUser(rs.getString("usuario"));
				salida.setPass(rs.getString("contrase"));
				sql = "select usuario from administradores where usuario = '" + usr + "';";
				ResultSet rs2 = stmt.executeQuery(sql);
				salida.setAdmin(false);
				if(rs2.next())
				{
					salida.setAdmin(true);
				}
				stmt.close();
				conn.close();
			}
		} 
		catch (Exception e) {
			System.out.println("hubo un error");
		}
		System.out.println("termino");	
		return salida;
	} 
	
	public static void registrarCliente(String usr, String pass, String nombre, Double numero, String domicilio) {
		abrir(); 
		try { 
			String user = "insert into usuarios values ('"+usr+"','mail@mail.com','"+pass+"');";
			String clie = "insert into clientes (usuario,nombre,telefono,direccion,lastcart) values ('"+usr+"','"+nombre+"',"+numero+",'"+domicilio+"',null);";
			System.out.println(user);
			System.out.println(clie);
			stmt.executeUpdate(user);
			stmt.executeUpdate(clie);
			stmt.close();
			conn.close();
		} 
		catch (Exception e) {
			System.out.println("hubo un error");
		}
		System.out.println("termino");	
	}
	
	public static boolean existUser(String usr)
	{
		abrir();
		try { 
			String sql = "select usuario from usuarios where usuario = '" + usr + "';";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar");
			return false;
		}
	}
	
	public static void borrarCliente(String usuario)
	{
		abrir();
		try {
			String sql2 = "delete from usuarios where usuario = '"+usuario+"';";
			String sql1 = "delete from clientes where usuario = '"+usuario+"';";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar");
		}
	}
	
	public static ArrayList listarMarcas()
	{
		ArrayList<String> marcas = new ArrayList<String>();
		abrir();
		int salida = 0;
		try {
			String sql = "select * from marcas;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int idMar = rs.getInt("id");
				String nomMar = rs.getString("nombre");
				System.out.println(idMar + ". " + nomMar);
				marcas.add(nomMar);
			}
			return marcas;
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar");
			return null;
		}
	}
	
	public static void agregarMarca(int id, String marca) {
		String sql = "insert into marcas values ("+id+" , '"+marca+"');";
		abrir();
		try {
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar");
		}
	}
	
	public static void ingresarProducto(String nombMarc, int idMarc, int precioV, int cantidad)
	{
		String sql = "insert into productos(nombre,idMarcas,precioVentas,cantidad) values ('"+nombMarc+"',"+idMarc+","+precioV+","+cantidad+");";
		abrir();
		try {
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar");
		}
	}
	
	public static HashMap listarProductos(int idMarc) {
		abrir();
		int salida = 0;
		HashMap<Integer,producto> selectProd = new HashMap<Integer,producto>();
		try {
			String sql = "SELECT productos.id, productos.nombre, marcas.nombre, productos.precioVentas FROM productos"
					+ " inner join marcas  on productos.idMarcas = marcas.id"
					+ " where idMarcas = "+idMarc+";";
			//System.out.println(sql);
			rs = stmt.executeQuery(sql);
			Integer elegir = new Integer(0); 
			while (rs.next()) {
				elegir = elegir + 1;
				int idProd = rs.getInt("productos.id");
				String prodNom = rs.getString("productos.nombre");
				String marca = rs.getString("marcas.nombre");
				int precio = rs.getInt("productos.precioVentas");
				selectProd.put(elegir, new producto(idProd, prodNom, marca, precio));
				System.out.print(elegir + ". ");
				System.out.print(prodNom + " ");
				System.out.print(marca + " ");
				System.out.println(precio);
			}
			return selectProd;
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar listarProductos");
			return null;
		}
	}
	
	public static int mostrarCarrito(String usr) {
		String sql = "select productos.nombre, marcas.nombre, carrito.cantidad, productos.precioVentas "
				+ "from (carrito "
				+ "inner join productos on carrito.idProducto = productos.id) "
				+ "inner join marcas on productos.idMarcas = marcas.id "
				+ "where carrito.idUsuario = '"+usr+"';";
		abrir();
		int aPagar = 0;
		int contador = 0;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				contador = contador + 1;
				String producto = rs.getString("productos.nombre");
				String marca = rs.getString("marcas.nombre");
				int cant = rs.getInt("carrito.cantidad");
				int precio = rs.getInt("productos.precioVentas");
				aPagar = aPagar + cant * precio;
				System.out.print(contador + ". ");
				System.out.print(producto + " ");
				System.out.print(marca + " ");
				System.out.print(cant + " x ");
				System.out.println(precio + "$");
			}
			return aPagar;
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar listarProductos");
			return 0;
		}
	}
	
	public static HashMap mapearCarrito(String usr) {
		String sql = "select productos.nombre, marcas.nombre, carrito.cantidad, productos.precioVentas, carrito.idCompra "
				+ "from (carrito "
				+ "inner join productos on carrito.idProducto = productos.id) "
				+ "inner join marcas on productos.idMarcas = marcas.id "
				+ "where carrito.idUsuario = '"+usr+"';";
		abrir();
		HashMap<Integer,carrito> compra = new HashMap<Integer,carrito>();
		try {
			rs = stmt.executeQuery(sql);
			Integer llave = new Integer(0);
			while (rs.next()) {
				llave = llave + 1;
				String producto = rs.getString("productos.nombre");
				String marca = rs.getString("marcas.nombre");
				int cant = rs.getInt("carrito.cantidad");
				int precio = rs.getInt("productos.precioVentas");
				int idCompra = rs.getInt("carrito.idCompra");
				System.out.print(llave + ". ");
				String detalle = producto + " " + marca + " " + cant + " x " + precio + "$";
				compra.put(llave, new carrito(idCompra,detalle));
			}
			return compra;
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar listarProductos");
			return null;
		}
	}
	
	public static void borrarCarrito(int idCart){
		String sql = "delete from carrito where idCompra = '"+idCart+"';";
		abrir();
		try {
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			
		}
	}
	
	public static void agregarCarrito(String cliente, int producto, int cantidad) {
		String sql = "insert into carrito (idUsuario, idProducto, cantidad) values ('"+cliente+"',"+producto+","+cantidad+");";
		abrir();
		try {
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.println("hubo un error al ejecutar");
		}
	}
}







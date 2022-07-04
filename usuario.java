package coffeeJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class usuario {
	public String user;
	public String pass;
	public boolean isAdmin;
	public boolean exist;
	
	public static final String JBDC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/market";
	public static String USER = "root";
	public static String PASS = "market";
	private static Connection conn = null;
	private static Statement stmt = null;
	
	public usuario(String usr)
	{
		try { 
			Class.forName(JBDC_DRIVER);
			System.out.println("Conectando...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("creando statement");
			stmt = conn.createStatement();
			String sql = "select * from usuarios where usuario = '" + usr + "';";
			this.exist = false;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				this.exist = true;
				this.user = rs.getString("usuario");
				this.pass = rs.getString("contrase");
				sql = "select usuario from administradores where usuario = '" + usr + "';";
				ResultSet rs2 = stmt.executeQuery(sql);
				if(rs2.next())
				{
					this.isAdmin = true;
				}
				stmt.close();
				conn.close();
			}
		} 
		catch (Exception e) {
			System.out.println("hubo un error");
		}
		System.out.println("termino");	
	}

	public void tooString() {
		String salida = "usuario [user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + ", exist=" + exist + "]";
		System.out.println(salida);
	}
	
	
}

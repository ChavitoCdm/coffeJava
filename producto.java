package coffeeJava;

public class producto {
	int idProd;
	String nombre;
	String marca;
	int precio;
	
	public producto(int idProd, String nombre, String marca, int precio) {
		this.idProd = idProd;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		//System.out.println("producto [idProd=" + idProd + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + "]");
	}
	
	public producto() {
		
	}

	public int getIdProd() {
		return idProd;
	}
	
	
}

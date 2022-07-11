package coffeeJava;

public class carrito {
	int idCompra;
	String Detalle;
	
	public carrito() {
		
	}
	
	public carrito(int idCompra, String Detalle) {
		this.idCompra = idCompra;
		this.Detalle = Detalle;
		System.out.println("carrito [idCompra=" + idCompra + ", Detalle=" + Detalle + "]");
	}

	public int getIdCompra() {
		return idCompra;
	}	
	
	
}

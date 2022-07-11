package coffeeJava;
import coffeeJava.*;
import java.util.*;

import coffeeJava.conector;

public class prueba {

	static void imprimir(int num, String opcion) {
		System.out.print(num + ". ");
		System.out.println(opcion);	
	}

	static void imprimir(String opcion) {
		System.out.println(opcion);	
	}
	
	public static void main(String[] args) throws Exception {
		try {
			Scanner sc = new Scanner(System.in);
			///////////////////////////////////
			HashMap<Integer,carrito> compra = new HashMap<Integer,carrito>();
			carrito cartActual = new carrito();
			compra = conector.mapearCarrito("herman");
			imprimir("Seleccione cual quiere borrar: ");
			int elegido = sc.nextInt();
			Integer aBorrar = new Integer(elegido);
			cartActual = compra.get(aBorrar);
			int idCart = cartActual.getIdCompra();
			conector.borrarCarrito(idCart);
			///////////////////////////////////////
		}
		catch (Exception e)
		{
			
		}
	}
}

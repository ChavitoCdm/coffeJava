package coffeeJava;
import coffeeJava.usuario;
import java.util.Scanner;
import java.util.ArrayList;
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
			imprimir(0,"agregar marcar");
			ArrayList<String> marcas = new ArrayList<String>();
			marcas = conector.listarMarcas();
			int cantidad = marcas.size();
			int elegir = sc.nextInt();
			if (elegir == 0) {
				imprimir("nombra de la marca:");
				String nuevaMarca = sc.next();
				conector.agregarMarca(cantidad+1 , nuevaMarca);
			}
			else {
				String marcEleg = marcas.get(elegir- 1 );
				imprimir("nombre del producto, una sola palabra");
				String nomProd = sc.next();
				imprimir("precio de venta, en pesos sin centavos");
				int precioVen = sc.nextInt();
				imprimir("cuantos ingresaron?");
				int cantProd = sc.nextInt();
				conector.ingresarProducto(marcEleg, elegir, precioVen, cantProd);
			}
			
			///////////////////////////////////////
		}
		catch (Exception e)
		{
			
		}
	}
}

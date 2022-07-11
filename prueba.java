package coffeeJava;
import coffeeJava.usuario;
import coffeeJava.producto;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

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
			int deuda;
			deuda = conector.mostrarCarrito("herman");
			System.out.print("total a pagar: " + deuda + "$");
			///////////////////////////////////////
		}
		catch (Exception e)
		{
			
		}
	}
}

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
			conector.listarMarcas();
			int idMarc = sc.nextInt();
						
			///////////////////////////////////////
		}
		catch (Exception e)
		{
			
		}
	}
}

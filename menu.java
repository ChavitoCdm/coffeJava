package coffeeJava;

import java.util.Scanner; 
import java.io.IOException;
import coffeeJava.usuario;

public class menu {

	static void imprimir(int num, String opcion) {
		System.out.print(num + ". ");
		System.out.println(opcion);	
	}
	
	static void imprimir(String opcion) {
		System.out.println(opcion);	
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		imprimir("Ingrese su usuario");
		String usuario = sc.nextLine();
		usuario usrActual = new usuario();
		usrActual = conector.usuario(usuario);
		while(!usrActual.isExist())
		{ 
			imprimir("Ingrese su usuario nuevamente");
			usuario = sc.nextLine();
			usrActual = conector.usuario(usuario);
		}
		imprimir("Ingrese su contraseña");
		String contrase = sc.nextLine();
		imprimir(contrase);
		imprimir(usrActual.getPass());
		while (!contrase.equals(usrActual.getPass()))
		{
			imprimir("Password incorrecta");
			contrase = sc.nextLine();
		}
		int elegido; 
		if (usrActual.isAdmin()) //para admin
		{                  
			imprimir(1, "control de cliente");
			imprimir(2, "control de productos");
			imprimir(3, "control de ventas");
			elegido = sc.nextInt();
			switch (elegido) {
				case 1 : {
					imprimir(1,"agregar usuario");
					imprimir(2,"borrar usuario");
					elegido = sc.nextInt();
					switch (elegido) {
						case 1 : {
							imprimir("nombre de usuario para el nuevo: ");
							usuario = sc.nextLine();
							
							break;
						}
						case 2 : {
							break;
						}
					}
					break;
				}
				case 2 : {
					imprimir(1,"agregar 1 producto");
					imprimir(2,"agregar lote de procutos");
					imprimir(3,"borrar producto");
					break;
				}
				case 3 : {
					imprimir(1,"buscar venta por usuario");
					imprimir(2,"buscar venta por nombre");
					imprimir(3,"listar ventas pendientes");
					imprimir(4,"vender producto");
					break;
				}
			}
		}
		else{
			imprimir(1,"descartar todo mi carrito");
			imprimir(2,"listar mi carrito");
			imprimir(3,"agregar producto");
		}
	}
}

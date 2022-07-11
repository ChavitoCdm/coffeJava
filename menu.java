package coffeeJava;

import java.util.ArrayList;
import java.util.HashMap;
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

	public static void main(String[] args) throws Exception {
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
		//imprimir(contrase);
		//imprimir(usrActual.getPass());
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
						case 1 : { ////////////agregar usuario
							imprimir("nombre de usuario para el nuevo: ");
							String nuevo = sc.next();
							while (conector.existUser(nuevo)) {
								imprimir("este ya existe, elegi otro usuario");
								nuevo = sc.next();
							}
							imprimir("crear una contrasenia");
							contrase = sc.next();
							imprimir("como es su primer nombre?");
							String nombre = sc.next();
							imprimir("como es su apellido?");
							String apellido = sc.next();
							imprimir("cual es su numero?");
							Double numero = sc.nextDouble();
							imprimir("donde vive?");
							String domicilio = sc.next(); //solo toma la primera palabra antes del espacio, no me funciona con nextLine
							conector.registrarCliente(nuevo, contrase, nombre + " "+ apellido, numero, domicilio);
							break;
						}
						case 2 : { /////borrar usuario
							imprimir("como es el usuario que quiere borrar?");
							String usr = sc.next();
							while (!conector.existUser(usr))
							{
								imprimir("no existe, como es el usuario que quiere borrar?");
								usr = sc.next();	
							}
							conector.borrarCliente(usr);
							break;
						}
					}
					break;
				}
				case 2 : {
					imprimir(1,"agregar 1 producto");
					imprimir(2,"agregar lote de procutos");
					imprimir(3,"borrar producto");
					elegido = sc.nextInt();
					switch (elegido){
						case 1 : { ////////////agregar producto o marca
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
								imprimir("cuantos hay?");
								int cantProd = sc.nextInt();
								conector.ingresarProducto(nomProd, elegir, precioVen, cantProd);
							}
						}
						case 2 : {
							imprimir("aun sin programar");
							break;
						}
						case 3 : {
							imprimir("aun sin programar");
							break;
						}
					}
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
			imprimir(1,"descartar algo de mi carrito");
			imprimir(2,"listar mi carrito");
			imprimir(3,"agregar producto");
			elegido = sc.nextInt();
			switch (elegido) {
			case 1 : {/////////////////////borrar algo del carrito
				HashMap<Integer,carrito> compra = new HashMap<Integer,carrito>();
				carrito cartActual = new carrito();
				compra = conector.mapearCarrito(usuario);
				imprimir("Seleccione cual quiere borrar: ");
				elegido = sc.nextInt();
				Integer aBorrar = new Integer(elegido);
				cartActual = compra.get(aBorrar);
				int idCart = cartActual.getIdCompra();
				conector.borrarCarrito(idCart);
				
				break;
				}
			case 2 : { /////////////findAll carrito
<<<<<<< HEAD
				conector.mostrarCarrito(usuario);
				imprimir("realizar la compra");
=======
				int deuda;
				deuda = conector.mostrarCarrito(usuario);
				System.out.print("total a pagar: " + deuda + "$");
				break;
				}
			case 3 : { //////////////agregar producto al carrito
				HashMap<Integer,producto> listProd = new HashMap<Integer,producto>();
				producto selecProd = new producto();
				conector.listarMarcas();
				int idMarca = sc.nextInt();
				listProd = conector.listarProductos(idMarca);
				imprimir("seleccionar producto");
				int eleccion = sc.nextInt();
				imprimir("seleccionar la cantidad");
				int cantidad = sc.nextInt();
				//Integer cual = new Integer(cantidad);
				selecProd = listProd.get(eleccion);
				int idProducto = selecProd.getIdProd();
				conector.agregarCarrito(usuario,idProducto,cantidad);
				
>>>>>>> conector
				}
			}
		}
	}
}

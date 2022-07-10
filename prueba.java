package coffeeJava;
import coffeeJava.usuario;

import java.util.Scanner;

import coffeeJava.conector;

public class prueba {

	public static void main(String[] args) throws Exception {
		try {
		       Scanner in = new Scanner(System.in);  
		          System.out.print("Enter your name: ");  
		          String name = in.nextLine();  
		          System.out.println("Name is: " + name);  
		}
		catch (Exception e)
		{
			
		}
	}
}

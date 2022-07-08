package CoffeeJava;

public class LecturaDeLinea {

	public static void main(String[] args) throws Exception {
		int c;
		int contador = 0;
		
		String s;
		System.out.println(s: "se lee hasta encontrar el fin de la linea");
		while ((c= System.in.read() ) != '\n') 
		{
			contador++; 
			System.out.println("lo que interpreta el compilador" + c);
			System.out.println("lo que ve la persona" + (char)c);
		}
		System.out.println();
		System.out.println("contados"+ contador + "bytes en total");
	}
		
	}



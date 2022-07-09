package coffeeJava;
import coffeeJava.usuario;
import coffeeJava.conector;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usuario administrador = new usuario();
		administrador = conector.usuario("admin");
		administrador.tooString();
	}

}

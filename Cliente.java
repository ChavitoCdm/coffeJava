package CoffeeJava;

public class Cliente {

private String Nombre;
private String Apellido;
private int dni;
private String Domicilio;

//set y get
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getApellido() {
	return Apellido;
}
public void setApellido(String apellido) {
	Apellido = apellido;
}
public int getDni() {
	return dni;
}
public void setDni(int dni) {
	this.dni = dni;
}
public String getDomicilio() {
	return Domicilio;
}
public void setDomicilio(String domicilio) {
	Domicilio = domicilio;
}

//Constructores
public Cliente() {
	
}
public Cliente(String nombre, String apellido, int dni, String domicilio) {
	
	this.Nombre = nombre;
	this.Apellido = apellido;
	this.dni = dni;
	this.Domicilio = domicilio;
}



}

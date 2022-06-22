package CoffeeJava;

public class Cliente {

private String Nombre;
private String Apellido;
private int dni;
private String Domicilio;

//set y get
public String getNombre() {
	return this.Nombre;
}
public void setNombre(String nombre) {
	this.Nombre = nombre;
}
public String getApellido() {
	return this.Apellido;
}
public void setApellido(String apellido) {
	this.Apellido = apellido;
}
public int getDni() {
	return this.dni;
}
public void setDni(int dni) {
	this.dni = dni;
}
public String getDomicilio() {
	return this.Domicilio;
}
public void setDomicilio(String domicilio) {
	this.Domicilio = domicilio;
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

package coffeeJava;


public class usuario {
	public String user;
	public String pass;
	public boolean isAdmin;
	public boolean exist;
 	
	public usuario()
	{
		
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public void tooString() {
		String salida = "usuario [user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + ", exist=" + exist + "]";
		System.out.println(salida);
	}
	
	
}

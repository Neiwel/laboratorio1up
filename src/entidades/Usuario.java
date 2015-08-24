package entidades;

public class Usuario {

	private String email;
	private String username;
	private String password;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	@Override
//	public boolean equals(Object usuario){
//		return (((Usuario) usuario).getUsername().equals(this.getUsername()));
//	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}

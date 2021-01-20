package modele;

public class Admin {
	private static int id_admin=0;
	private String login;
	private String password;
	
	public Admin(String login, String password) {
		super();
		id_admin++;
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean ValidationLogin() {
		//Le login doit être admin
		return login.equals("admin");
	}
	
	public boolean ValdiationPassword() {
		//Le mot de passe doit contenir le mot orsys
		return password.equals("orsys");
	}
	

	
	
	
	
}

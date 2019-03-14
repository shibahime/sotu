package model;

public class Login {

	private String id;
	private String pass;
	public Login(String id,String pass) {
		this.id=id;
		this.pass=pass;
	}
	public String getId() {return id;}
	public String getPass() {return pass;}
}

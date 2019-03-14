package model;

public class Account {
private String id;
private String pass;
private String mail;
private String name;
private int age;


public Account(String id,String pass,String mail,String name,int age) {
	this.id=id;
	this.pass=pass;
	this.mail=mail;
	this.name=name;
	this.age=age;
}
public String getId() {return id;}
public String getPass() {return pass;}
public String getMail() {return mail;}
public String getName() {return name;}
public int getAge() {return age;}
}



package serverTest;

import java.io.Serializable;

public class Credentials<T> implements Serializable
{
	private String email, password;
	private T obj;
	public Credentials() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Credentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}

}

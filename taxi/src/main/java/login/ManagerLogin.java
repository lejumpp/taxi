package login;

public class ManagerLogin 
{
	private String username,password;
	
	public ManagerLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}	

}

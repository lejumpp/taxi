package businessLogic;
import java.util.Scanner;

import customerService.Email;
import users.Customer;;

public class CustomerLogic 
{
	private String source,destination;
	private int total;
	
	public CustomerLogic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) 
	{
		this.destination = destination;
	}

	public int getTotal() {
		return total;
	}

	public int setTotal(int total) {
		this.total = total;
		return total;
	}

	public void placeRequest()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Source: ");
		source=input.nextLine();
		System.out.println("Destination: ");
		destination=input.nextLine();
		System.out.println("Your total for this trip will be: $"+calculateDistance(source,destination));
	}
	
	public boolean confirmRequest()
	{
		
		return true;
	}
	
	public void rating()
	{
		
	}
	
	public int calculateDistance(String source,String destination)
	{
		int basePrice=350,perKm=20;
		
		return setTotal(basePrice+(perKm*(source.length()+destination.length())));
	};
	
	public boolean sendMail(String email, String firstName, String lastName, String message, String query )
	{
		try
		{
			Email custEmail = new Email();
			
			custEmail.setFrom(email);
			custEmail.setCustInfo(new Customer(firstName,lastName));
			custEmail.setMessageText(message);
			custEmail.setSubject(query);
			return custEmail.sendEmail();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

}

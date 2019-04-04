package businessLogic;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Scanner;

import customerService.Email;
import database.FeedbackProvider;
import database.MissedRequestProvider;
import database.TaxiProvider;
import feedback.Feedback;
import taxi.Taxi;
import users.Customer;;

public class CustomerLogic 
{
	private String source,destination;
	private int total,id;
	Timer timer;
	TaxiProvider taxi=new TaxiProvider();
	Taxi driver= new Taxi();
	
	public CustomerLogic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
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
	
	
	
	
	
	
	
	
	

	public CustomerLogic(String source, String destination, int total, int id) {
		super();
		this.source = source;
		this.destination = destination;
		this.total = total;
		this.id = id;
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
	
	public void Reminder(int seconds)
	{
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds*1000);
	}
	
	class RemindTask extends TimerTask{
		public void run()
		{
			taxi.recommission(driver.getId());
			timer.cancel();
		}
	}
	
	public boolean confirmRequest(Feedback obj)
	{
		FeedbackProvider feedback=new FeedbackProvider();
		try
		{	
			driver=taxi.getAvailable();
			if(driver!= null)
			{
				if(taxi.update(driver.getId())==1)
				{
					System.out.println("Record updated");
					Reminder(source.length()+destination.length());
					feedback.add(driver,obj);
				}	
				else
					System.out.println("Record not updated");
				
			}
			else
			{
				MissedRequestProvider missed= new MissedRequestProvider();
				System.out.println("No driver is available sorry");
				missed.add(new CustomerLogic(this.source,this.destination,this.total,0));
			}
			return true;
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	
	public boolean rating()
	{
		
		return false;
	}
	
	public int calculateDistance(String source,String destination)
	{
		int basePrice=350,perKm=20;
		
		return setTotal(basePrice+(perKm*(source.length()+destination.length())));
	};
	
	public boolean sendMail()
	{
		try
		{
			Email custEmail = new Email();
			Scanner input= new Scanner(System.in);
			System.out.println("Enter your email");
			String email=input.nextLine();
			custEmail.setFrom(email);
			System.out.println("Enter your first name");
			String firstName=input.nextLine();
			System.out.println("Enter your last name");
			String lastName=input.nextLine();
			custEmail.setCustInfo(new Customer(firstName,lastName));
			System.out.println("Enter the message you would like to send");
			String message=input.nextLine();
			custEmail.setMessageText(message);
			System.out.println("Enter your query type (tour service/support/other): ");
			String query=input.nextLine();
			custEmail.setSubject(query);
			return custEmail.sendEmail();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Missed Request [id="+ id +", source=" + source + ", destination=" + destination + ", total=" + total+ "]";
	}
	
	

}

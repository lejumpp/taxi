package serverTest;
import java.util.Timer;
import java.util.TimerTask;
import java.io.Serializable;
import java.util.Scanner;


public class CustomerLogic implements Serializable
{
	private String source,destination;
	private int total,id;
	Timer timer;
	TaxiProvider taxi=new TaxiProvider();
	private Taxi driver= new Taxi();
	
	public Taxi getDriver() {
		return driver;
	}

	public void setDriver(Taxi driver) {
		this.driver = driver;
	}

	public CustomerLogic() {
		super();
		// TODO Auto-generated constructor stub
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
	public int calculateDistance(String source,String destination)
	{
		int basePrice=350,perKm=20;
		
		return setTotal(basePrice+(perKm*(source.length()+destination.length())));
	};
	
	public boolean checkAvailability()
	{
		MissedRequestProvider missed= new MissedRequestProvider();
		TaxiProvider driverDB= new TaxiProvider();
		driver=driverDB.getAvailable();
		if(driver==null)
		{
			if(missed.add(this)==1)
				return false;
		}
		return true;
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

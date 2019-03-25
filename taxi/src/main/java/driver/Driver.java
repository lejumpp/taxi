/*package driver;

import java.util.List;

import businessLogic.CustomerLogic;
import database.TaxiProvider;
import taxi.Taxi;
import vehicle.Vehicle;

public class Driver {

	public static void main(String[] args)
	{
		TaxiProvider tp=new TaxiProvider();
		int recordsAffected=tp.add(new Taxi(0,"Marc","Gordon","128345789",new Vehicle("Subaru","2010")));
		if(recordsAffected==1)
			System.out.println("Driver Added successfully");
		else
			System.out.println("Unable to add Driver");
		
		System.out.println("Moving on");
		List<Taxi> results=tp.selectAll();
		for(Taxi driver: results) {
			System.out.println(driver.toString());
		}
		int recordAffected=tp.update(3);
		if(recordAffected==1)
		{
			System.out.println("Record updated");
		}
		else
			System.out.println("Fail to update record");
		List<Taxi> results=tp.selectAll();
		for(Taxi driver: results) {
			System.out.println(driver.toString());
		}
		
		CustomerLogic customer= new CustomerLogic();
		if(customer.sendMail())
		{
			System.out.println("Email sent");
		}
		customer.placeRequest();
		
	}

}*/
package client;

import application.Main;
import javafx.application.Application;
import serverTest.*;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;
import java.io.*; 
  
public class Client implements Serializable
{ 
    // initialize socket and input output streams 
    private Socket socket = null; 
    private DataInputStream input = null; 
    private DataOutputStream out = null; 
    private ObjectInputStream in= null;
    private ObjectOutputStream oos=null;
    private static Client instance=null;
  
    // constructor to put ip address and port 
    private Client(String address, int port) 
    { 
    	//Main app = null;  	
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            //in= new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected"); 
  
            // takes input from terminal 
            input  = new DataInputStream(System.in); 
  
            // sends output to the socket 
            //out    = new DataOutputStream(socket.getOutputStream()); 
            getStreams();
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
    
	public boolean authenticate(String user, String password)
    {
    	try
    	{
    		Credentials cred= new Credentials(user,password);
    		Request req= new Request();
    		req.setAction("login");
    		req.setObj(cred);
    		oos.writeObject(req);
    		Response resp=(Response) in.readObject();
    		Boolean successfulLogin=(Boolean)resp.getObj();
    		if(successfulLogin)
    		{
    			return true;
    		}
    		else
    		{
    			System.out.println("Error");
    		}	
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
	
	public boolean addCab(int id, String firstName, String lastName, String trn, Vehicle vehicleInfo)
	{
		try
		{
			Taxi driver= new Taxi(id,firstName,lastName,trn,vehicleInfo);
			Request req= new Request();
			req.setAction("addCab");
			req.setObj(driver);
			oos.writeObject(req);
			Response resp=(Response) in.readObject();
			Boolean successfulComission=(Boolean)resp.getObj();
			if(successfulComission)
			{
				return true;
			}
			else
			{
				System.out.println("Error");
			}
		}
		catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean decomission(int id, String firstName, String lastName, String trn, Vehicle vehicleInfo)
	{
		try
		{
			Taxi driver= new Taxi(id,firstName,lastName,trn,vehicleInfo);
			Request req= new Request();
			req.setAction("decomission");
			req.setObj(driver);
			oos.writeObject(req);
			Response resp=(Response) in.readObject();
			Boolean successfulDecomission=(Boolean)resp.getObj();
			if(successfulDecomission)
			{
				return true;
			}
			else
			{
				System.out.println("Error");
			}
		}
		catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean confirmCab()
	{
		try
		{
			serverTest.CustomerLogic customer= new serverTest.CustomerLogic();
			Request req= new Request();
			req.setAction("confirmRequest");
			req.setObj(customer);
			oos.writeObject(req);
			Response resp=(Response) in.readObject();
			Boolean successfulUpdate=(Boolean)resp.getObj();
			if(successfulUpdate)
				return true;
			else
				System.out.println("Error");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean summaryReport()
	{
		try
		{
			SummaryReport driver = new SummaryReport();
			Request req= new Request();
			req.setAction("summary");
			req.setObj(driver);
			oos.writeObject(req);
			Response resp=(Response) in.readObject();
			List<SummaryReport> drivers=(ArrayList<SummaryReport>)resp.getObj();
			if(driver!=null)
			{
				//List<Taxi> results=tp.selectAll();
				for(SummaryReport report: drivers) {
					System.out.println(drivers.toString());
				}
			}
			else
			{
				System.out.println("Error");
			}
		}
		catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean missedRequestDB()
	{
		try
		{
			CustomerLogic customer = new CustomerLogic();
			Request req= new Request();
			req.setAction("missedRequestDB");
			req.setObj(customer);
			oos.writeObject(req);
			Response resp=(Response) in.readObject();
			List<CustomerLogic> request=(ArrayList<CustomerLogic>)resp.getObj();
			if(customer!=null)
			{
				//List<Taxi> results=tp.selectAll();
				for(CustomerLogic report: request) {
					System.out.println(request.toString());
				}
			}
			else
			{
				System.out.println("Error");
			}
		}
		catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private void getStreams() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
    public static void main(String args[]) 
    {
    	EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Application.launch(Main.class,args);
			}
    	});
    }

	public static Client getInstance() {
		// TODO implement singleton
		if(instance==null)
		{
			instance= new Client("127.0.0.1", 5000); 
		}
		return instance; 
	} 
} 
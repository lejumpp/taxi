package serverTest;

import java.net.*;
import java.util.List;
import java.io.*; 
  
public class Server 
{ 
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
    private ObjectOutputStream oos;
	private ObjectInputStream ois;
  
    // constructor with port 
    public Server(int port) 
    { 
        // starts server and waits for a connection 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            getStreams();
            System.out.println("Client accepted"); 
            System.out.println("Waiting for request from client");
            Request request= new Request();
            do {
            	System.out.println("Waiting for request from client");
            	request= (Request)ois.readObject();
            	System.out.println("Request recieved "+request);
            	
            	if(request!=null) {
            		if(request.getAction().equals("login")) 
            		{
            			System.out.println("This is a login request");
            			Credentials creds = (Credentials)request.getObj();
            			if(creds.getEmail().equals("manager")&& creds.getPassword().equals("cabbie")) {
            				//success
            				System.out.println("Successful login");
            				oos.writeObject(new Response(true));
            			}
            			else
            			{
            				System.out.println("Incorrect credentials");
            				oos.writeObject(new Response(false));
            			}
            		}
            		if(request.getAction().equals("addCab"))
            		{
            			System.out.println("This is a add cab request");
            			Taxi newDriver = (Taxi)request.getObj();
            			TaxiProvider Taxidb= new TaxiProvider();
            			if(Taxidb.add(newDriver)==1)
            			{
            				System.out.println("Driver Added Successfully");
            				oos.writeObject(new Response(true));
            			}
            			else
            			{
            				System.out.println("Driver could not be added");
            				oos.writeObject(new Response(false));
            			}
            		}
            		if(request.getAction().equals("decomission"))
            		{
            			System.out.println("This is a decomission taxi request");
            			Taxi newDriver = (Taxi)request.getObj();
            			TaxiProvider Taxidb= new TaxiProvider();
            			if(Taxidb.update(newDriver.getId())==1)
            			{
            				System.out.println("Driver Decomissioned Successfully");
            				oos.writeObject(new Response(true));
            			}
            			else
            			{
            				System.out.println("Driver could not be decomissioned");
            				oos.writeObject(new Response(false));
            			}
            		}
            		if(request.getAction().equals("summary"))
            		{
            			System.out.println("This is the summary report request");
            			//Taxi newDriver = (Taxi)request.getObj();
            			TaxiProvider Taxidb= new TaxiProvider();
            			List<SummaryReport> results=Taxidb.summaryReport();
            			if(results!=null)
            			{
            				System.out.println("Grabbed report Successfully");
            				oos.writeObject(new Response(results));
            			}
            			else
            			{
            				System.out.println("Could not retrieve report");
            				oos.writeObject(new Response(results));
            			}
            		}
            		if(request.getAction().equals("customerFeedback"))
            		{
            			System.out.println("This is a feedback request");
            			FeedbackProvider feed= new FeedbackProvider();
            			Feedback feedback=(Feedback)request.getObj();
            			if(feed.add(feedback)==1)
            			{
            				System.out.println("Feedback entered");
            				oos.writeObject(new Response(true));
            			}
            			else
            				oos.writeObject(new Response(false));
            		}
            		if(request.getAction().equals("confirmRequest"))
            		{
            			System.out.println("This is request confirmation");
            			MissedRequestProvider missed= new MissedRequestProvider();
            			CustomerLogic customer= (CustomerLogic)request.getObj();
            			if(customer.checkAvailability(customer)==null)
            			{
            				System.out.println("Missed Request Added");
            				oos.writeObject(new Response(false));
            			}
            			else
            			{
            				System.out.println("Confimration made");
            				oos.writeObject(new Response(true));
            			}
            		}
            		if(request.getAction().equals("feedbackDB"))
            		{
            			System.out.println("This is the feedback request");
            			FeedbackProvider feedback= new FeedbackProvider();
            			Feedback feed= (Feedback)request.getObj();
            			feed=feedback.get(feed.getId());
            			if(feed!=null)
            			{
            				System.out.println("Grabbed feedback Successfully");
            				oos.writeObject(new Response(feed));
            			}
            			else
            			{
            				System.out.println("Could not grab feedback");
            				oos.writeObject(new Response(null));
            			}
            		}
            		if(request.getAction().equals("missedRequestDB"))
            		{
            			System.out.println("This is the missed request request");
            			//Taxi newDriver = (Taxi)request.getObj();
            			MissedRequestProvider requestDB= new MissedRequestProvider();
            			List<CustomerLogic> results=requestDB.selectAll();
            			if(results!=null)
            			{
            				System.out.println("Grabbed report Successfully");
            				oos.writeObject(new Response(results));
            			}
            			else
            			{
            				System.out.println("Could not retrieve report");
            				oos.writeObject(new Response(results));
            			}
            		}
            		
            		
            	}
            }while(request!=null && !request.getAction().equals("Exit"));
  
            System.out.println("Closing connection"); 
  
            // close connection 
            in.close();
            socket.close(); 
             
        } 
        catch(IOException | ClassNotFoundException i) 
        { 
            System.out.println(i); 
        } 
    } 
    
    private void getStreams() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
    public static void main(String args[]) 
    { 
        Server server = new Server(5000); 
    } 
} 


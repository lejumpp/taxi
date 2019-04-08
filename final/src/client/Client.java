package client;

import application.Main;
import javafx.application.Application;
import serverTest.*;

import java.net.*;
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
    		//getStreams();
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
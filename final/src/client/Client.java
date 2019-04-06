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
  
    // constructor to put ip address and port 
    public Client(String address, int port) 
    { 
    	//Main app = null;  	
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            in= new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected"); 
  
            // takes input from terminal 
            input  = new DataInputStream(System.in); 
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        // string to read message from input 
        /*String line = ""; 
  
        // keep reading until "Over" is input 
        while (!line.equals("Over")) 
        { 
            try
            { 
                line = input.readLine(); 
                out.writeUTF(line); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
  
        // close the connection 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } */
    } 
    
    @SuppressWarnings("null")
	public boolean authenticator(String user, String password) throws ClassNotFoundException
    {
    	ObjectOutputStream outObj=null;
    	try
    	{
    		Credentials cred= new Credentials(user,password);
    		Request req= new Request();
    		req.setAction("login");
    		req.setObj(cred);
    		outObj.writeObject(req);
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
    	}
    	return false;
    }
  
    public static void main(String args[]) 
    {
    	//Main app= new Main();
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
		return new Client("127.0.0.1", 5000); 
	} 
} 
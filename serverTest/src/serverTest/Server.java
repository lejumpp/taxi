package serverTest;

import java.net.*; 
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
            	request= (Request)ois.readObject();
            	System.out.println("Request recieved "+request);
            	
            	if(request!=null) {
            		if(request.getAction().equals("login")) {
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


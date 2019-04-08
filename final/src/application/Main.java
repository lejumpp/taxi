package application;
	
import businessLogic.*;
import client.Client;
import database.MissedRequestProvider;
import database.TaxiProvider;
import customerService.*;
import javafx.scene.control.TextArea;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import serverTest.*;

import java.net.*; 
import java.io.*; 

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import taxi.Taxi;
import vehicle.Vehicle;
import javafx.geometry.Insets;
public class Main extends Application 
{
	
	
 	Font f = new Font("Arial", 20);
	GridPane grid= new GridPane();
	TextField nametextfield= new TextField();
	TextField nametextfield2= new TextField();
	Button button= new Button();
	final Text actiontarget = new Text();
	PasswordField passtextfield= new PasswordField();
	PasswordField passtextfield2= new PasswordField();
	Button btn2 = new Button();
	Button btn3 = new Button();
	Button btn4 = new Button();
	Button btn5 = new Button();
	Button btn6 = new Button();
	Button btn7 = new Button();
	
	//Client client = Client.getInstance();
	
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
    	GridPane gridL = new GridPane();
    	Scene scene1= new Scene(gridL, 300, 150);
    	gridL.setId("pane");
    	scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

    	
    	primaryStage.setTitle(" LOGIN ");
    	
    	gridL.setPadding(new Insets(10,10,10,10));
    	gridL.setVgap(8);
    	gridL.setHgap(10);
    	
        Text Hello  =  new Text("WELCOME");
        Button back = new Button("<-");
        
        Text Arey = new Text( "Are you  a Manager or Customer ?");
        Button MLogin,CLogin;
        Hello.setFont(f);
        
        MLogin = new Button ("Manager");
        CLogin = new Button("Customer");
        
        GridPane.setConstraints(back,0,0);
        GridPane.setConstraints(Hello,3,0);
        GridPane.setConstraints(Arey,3,1);
        GridPane.setConstraints(MLogin,3,2);
        GridPane.setConstraints(CLogin, 3,3);
        MLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ManagerLogin();
                primaryStage.close();
                
            }
        });
        CLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CustomerLogin();
                
            }
        });
        
       
        
        ////////////////////////
        
        
     
      //  primaryStage.getIcons().add(new Image("cabbie.png"));
        
        ///////////////////////////////////////////////
        
        
        
        gridL.getChildren().addAll(Hello,Arey,MLogin,CLogin,back);
        
        
        
        primaryStage.setScene(scene1);
              
        primaryStage.show();
    }
    public void CustomerLogin() {
    	
    	GridPane grid4 = new GridPane();
    	 Scene scene = new Scene(grid4, 420, 200);
    	Stage stage2 = new Stage();
    	grid4.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    	grid4.setPadding(new Insets(10,10,10,10));
    	grid4.setVgap(8);
    	grid4.setHgap(10);
    	
    	
   
    	stage2.setTitle("Customer  Login");
    	
    	
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	GridPane.setConstraints(text1,0,0);
    	Label name= new Label("User name");
    	GridPane.setConstraints(name, 0, 1);


    	GridPane.setConstraints(nametextfield2, 1, 1);


    	Label password= new Label("Password");
    	GridPane.setConstraints(password,0,2);

    	
    	GridPane.setConstraints(passtextfield2, 1,2 );
    	
    	Text text2 = new Text("New Member?");
    	Font f1 = new Font("Arial",13);
    	text2.setFont(f1);
    	
    	Button create  = new Button("Create Account");
    	GridPane.setConstraints(create,2,5);
    	
    	GridPane.setConstraints(text2,1,5);
        Button btn8 = new Button();
        btn8.setText("LOGIN'");
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkCusLogin();
                
            }
        });
        
        
        
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CreateMember();
                
            }
        });
        
        GridPane.setConstraints(btn8, 1,3);


        grid4.getChildren().addAll(text1,name,nametextfield2, password,
                passtextfield2,btn8,create,text2);
        
        
       
    	
        stage2.setScene(scene);

        stage2.show();
    	
    	
    	
    	
    	
    }
    
 public void CreateMember() {
	 
	 Stage stage2 = new Stage();
 	stage2.setTitle("ADD CAB");
 	GridPane grid3 = new GridPane();
 	grid3.setPadding(new Insets(10,10,10,10));
 	grid3.setVgap(8);
 	grid3.setHgap(10);
 	TextField trn = new TextField();
 	
 	TextField nameT = new TextField();
 	TextField UsernameT = new TextField();
 	PasswordField PasswordT  = new PasswordField();
 	PasswordField Password2T  = new PasswordField();
 	TextField Email = new TextField();
 	Label Name = new Label("NAME");
 	Label UN = new Label("USERNAME");
 	Label P1 = new Label("Pasword");
 	Label P2= new Label("Confirm Password");
 	Label email = new Label("EMAIL");
 	Button back = new Button ("<-");
 	Button submit = new Button ("Submit");
 	Text text = new Text("Please Enter ");
 	Text tex2 = new Text("RICHIE CABS");
 	tex2.setFont(f);
 	
 	
	 GridPane.setConstraints(back,0,0);
	 GridPane.setConstraints(tex2,2,1);
	 GridPane.setConstraints(text,2,2);
	 GridPane.setConstraints(Name,1,4);
	 GridPane.setConstraints(nameT,2,4);
	 GridPane.setConstraints(UN,1,5);
	 GridPane.setConstraints(UsernameT,2,5);
	 GridPane.setConstraints(P1,1,6);
	 GridPane.setConstraints(PasswordT,2,6);
	 GridPane.setConstraints(P2,1,7);
	 GridPane.setConstraints(Password2T,2,7);
	 GridPane.setConstraints(email,1,8);
	 GridPane.setConstraints(Email,2,8);
	 GridPane.setConstraints(submit,4,9);
	 
	 
	 
	 
	 back.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             Stage stage12 = new Stage();
             start(stage12);
             stage2.close();
             
         }
     });
	 final Popup popup = new Popup();
	 
	 
	submit.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
        	 
        	    popup.setAutoFix(true);
        	    popup.setAutoHide(true);
        	    popup.setHideOnEscape(true);
        	    Label label = new Label("ACCOUNT CREATED");
        	    popup.show(stage2);
        	    
             
         }
     });
	 
	grid3.getChildren().addAll(back,tex2,text,Name,nameT,UN,UsernameT,P1,PasswordT,P2,Password2T,email,Email,submit);
	 Scene scene = new Scene(grid3, 420, 400);
	 grid3.setId("pane");
 	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
	 
     stage2.setScene(scene);

     stage2.show();
 	
	 
	 
	 
	 
 }
    
    public void checkCusLogin() {
    	
    	String  User = "customer";
    	String Password = "cabbie";
    	if (User.equals(nametextfield2.getText())&& Password.equals(passtextfield2.getText())) {
    		showCustMenu();
    		
    		
    	}else {
    		PopUpW("INCORRECT PASSWORD RENTER");
    	}
    	
    }
    
    
    public void showCustMenu() {
    	Stage stage2  = new Stage();
    	
    	GridPane grid2 = new GridPane();
    	Scene scene = new Scene(grid2, 400, 250);

    	grid2.setPadding(new Insets(10,10,10,10));
    	grid2.setVgap(8);
    	grid2.setHgap(10);
    	grid2.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    	
    	stage2.setTitle("Customer Menu");
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	
    	Button Request = new  Button("Make Request");
    	Button  Email = new Button("Email");
    	Button Logout = new Button ("Logout");
    	Button back  = new Button("<-");
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints(text1,3,1);
    	GridPane.setConstraints(Request,3,2);
    	GridPane.setConstraints(Email,3,3);
    	GridPane.setConstraints(Logout,3,4);
    	
    	
    	 grid2.getChildren().addAll(text1,back,Request,Email,Logout);
    	 Request.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 makeRequest();
                 stage2.close();
                 
                 
             }
         });
    	 
    	 
    	 Request.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 makeRequest();
                 stage2.close();
                 
                 
             }
         });
    	 back.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                CustomerLogin();
                
                 stage2.close();
                 
             }
         });
    	 Email.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                CustomerService();
                
                 stage2.close();
                 
             }
         });
     	
     	     	
     	        stage2.setScene(scene);
     	
     	        stage2.show();
    	
    	
    	
    	
    }
    public void makeRequest()   {
    	
    	
    	Stage stage2  = new Stage();
    	GridPane grid2 = new GridPane();
    	grid2.setPadding(new Insets(10,10,10,10));
    	grid2.setVgap(8);
    	grid2.setHgap(10);
    	
    	stage2.setTitle("MAKE REQUEST");
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	
    	Label Source  = new Label("SOURCE");
    	TextField So = new TextField();
    	Label Dest = new Label("DESTINATION");
    	
    	TextField Dest1 = new TextField();
    	
    
    	Button MkRe = new Button("Make Request");
    	Button back = new Button("<-");
    	
    	
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints(text1,0,1);
    	GridPane.setConstraints(Source,1,3);
    	GridPane.setConstraints(So,2,3);
    	GridPane.setConstraints(Dest,1,4);
    	GridPane.setConstraints(Dest1,2,4);
    	GridPane.setConstraints(MkRe,2,6);
    	SourceDest Qi= new SourceDest();
    	
    	grid2.getChildren().addAll(back,text1,Source,So,Dest,Dest1,MkRe);
    	
    	
    	
    	back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showCustMenu();
                stage2.close();
                
            }
        });
    	
    	MkRe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Qi.setDest(Dest1.getText());
            	Qi.setSource(So.getText());
                Request(Qi);
                stage2.close();
                
            }
        });
    	
    	Scene scene = new Scene(grid2, 400, 250);
    	grid2.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
	        stage2.setScene(scene);
	
	        stage2.show();

    	
    	
    	
    }
    class  SourceDest {
    	private String Dest;
    	private String Source;
    	public String getDest() {
    		return Dest;
    	}
    	public String getSource() {
    		return Source;
    		
    	}
    	public void setDest(String c) {
    		Dest =c;
    		
    	}
    	public void setSource(String v) {
    		Source= v;
    		
    	}
    }
    public void  Request(SourceDest e) {
    	Stage stage2  = new Stage();
    	GridPane grid2 = new GridPane();
    	grid2.setPadding(new Insets(10,10,10,10));
    	grid2.setVgap(8);
    	grid2.setHgap(10);
    	
    	stage2.setTitle("Confrim REQUEST");
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	
    	Label Source  = new Label("SOURCE");
    	TextField So = new TextField();
    	Label Dest = new Label("DESTINATION");
    	Label P = new Label("PRICE");
    	TextField PT= new TextField();
    	
    	
    	Label Distance = new Label("DISTANCE");
    	TextField DT= new TextField();
    	TextField Dest1 = new TextField();
    	Dest1.setEditable(false);
    	PT.setEditable(false);
    	DT.setEditable(false);
    	So.setEditable(false);
    	
    	DT.setText(Integer.toString(e.getDest().length()+e.getSource().length()));
    	//int price = businessLogic.CustomerLogic.calculateDistance(e.getSource(),e.getDest());
    	CustomerLogic cust = new CustomerLogic();
    	int price = cust.calculateDistance(e.getSource(),e.getDest());
    	PT.setText(Integer.toString(price));
    	
    	So.setText(e.getSource());
    	Dest1.setText(e.getDest());
    	
    	
    	Button MkRe = new Button("Confirm Request");
    	Button back = new Button("<-");
    	
    	
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints(text1,0,1);
    	GridPane.setConstraints(Source,0,3);
    	GridPane.setConstraints(So,1,3);
    	GridPane.setConstraints(Dest,0,4);
    	GridPane.setConstraints(Dest1,1,4);
    	GridPane.setConstraints(P,0,5);
    	GridPane.setConstraints(PT,1,5);
    	GridPane.setConstraints(Distance,0,6);
    	GridPane.setConstraints(DT,1,6);
    	
    	
    	
    	GridPane.setConstraints(MkRe,2,8);
    	
    	
    	grid2.getChildren().addAll(back,text1,Source,So,Dest,Dest1,MkRe,PT,P,DT,Distance);
    	
    	
    	
    	back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               makeRequest();
                stage2.close();
                
            }
        });
    	
    	MkRe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	cust.Reminder(e.getDest().length()+e.getSource().length());
                RequestConfirmed();
                stage2.close();
                
            }
        });
    	
    	
    	
    	Scene scene = new Scene(grid2, 400, 400);
    	grid2.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
	        stage2.setScene(scene);
	
	        stage2.show();
    	
    	
    }
    
    public void  RequestConfirmed() {
    	Stage stage2  = new Stage();
    	GridPane grid2 = new GridPane();
    	grid2.setPadding(new Insets(10,10,10,10));
    	grid2.setVgap(8);
    	grid2.setHgap(10);
    	
    	stage2.setTitle("CABBIE REQUEST");
    	Text text1 = new Text("CONFIRMATION NUMBER");
    	
    	Font f5 = new Font("Times New Roman",15);
    	text1.setFont(f5);
    	
    	TextField ticket = new TextField();
    	ticket.setEditable(false);
    	
    	Random r = new Random();
        int c = r.nextInt(21226) + (byte)'a';
        
    	ticket.setText(Integer.toString(c));
    	
    	
    	GridPane.setConstraints(text1,1,1);
    	GridPane.setConstraints(ticket,1,3);
    	
    	 grid2.getChildren().addAll(ticket,text1);
    	Scene scene = new Scene(grid2, 400, 150);
    	 grid2.setId("pane");
      	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
	        stage2.setScene(scene);
	
	        stage2.show();
	       FEEDBACK();
    }
    
    public void FEEDBACK() {
    	 Scene scene = new Scene(new Group());

    	
    	Stage stage = new Stage();
    	stage.setTitle("FEEDBACK");
    	
    	    stage.setWidth(350);
    	    stage.setHeight(350);

    	    final ToggleGroup group = new ToggleGroup();

    	    RadioButton rb1 = new RadioButton("1");
    	    rb1.setToggleGroup(group);
    	    rb1.setUserData("1");

    	    RadioButton rb2 = new RadioButton("2");
    	    rb2.setToggleGroup(group);
    	    rb2.setUserData("2");

    	    RadioButton rb3 = new RadioButton("3");
    	    rb3.setToggleGroup(group);
    	    rb3.setUserData("3");

    	    RadioButton rb4 = new RadioButton("4");
    	    rb4.setToggleGroup(group);
    	    rb4.setUserData("4");
    	    RadioButton rb5 = new RadioButton("5");
    	    rb5.setToggleGroup(group);
    	    rb5.setUserData("5");
    	    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
    	      public void changed(ObservableValue<? extends Toggle> ov,
    	          Toggle old_toggle, Toggle new_toggle) {
    	        if (group.getSelectedToggle() != null) {
    	          System.out.println(group.getSelectedToggle().getUserData().toString());
    	        }
    	      }
    	    });

    	    GridPane grid2 = new GridPane();
        	grid2.setPadding(new Insets(10,10,10,10));
        	grid2.setVgap(8);
        	grid2.setHgap(10);
        	Text text1 = new Text("RICHIE CABS");
        	text1.setFont(f);
        	TextField Feedback   = new TextField();
        	Label Fb= new Label("FEEDBACK");
        	
        	Button confirm = new Button("CONFIRM");
        Text Poor = new Text("Very Poor"); Text VryG = new Text("Very Good"); Text Inter = new Text("Intermediate");
        
        	GridPane.setConstraints(rb1,0,6);
        	GridPane.setConstraints(rb2,0,7);
        	GridPane.setConstraints(rb3,0,8);
        	GridPane.setConstraints(rb4,0,9);
        	GridPane.setConstraints(rb5,0,10);
        	GridPane.setConstraints(text1,0,0);
        	GridPane.setConstraints(Fb,0,3);
        	GridPane.setConstraints(Feedback,1,4);
        	GridPane.setConstraints(confirm,1,5);
        	GridPane.setConstraints(Poor ,1,6);
        	GridPane.setConstraints(VryG ,1,10);
        	GridPane.setConstraints(Inter,1,7);
        	confirm.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  CustomerLogic email1 = new CustomerLogic();
                  if(true) {
               	   System.out.println("Thank you!");
                  }else {
               	   
               	   System.out.println("Error");
                  }
                  
                    //grid2.close();
                    
                }
            });
        	
    	    ((Group) scene.getRoot()).getChildren().add(grid2);
    	    grid2.setId("pane");
        	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    	    grid2.getChildren().addAll(rb1,rb2,rb3,rb4,rb5,text1,Fb,Feedback,confirm,Poor,VryG);
    	    stage.setScene(scene);
    		
	        stage.show();

    }
    public void CustomerService() {
    	
    	
    	Stage stage2 = new Stage();
    	GridPane grid2 =new GridPane();
    	grid2.setPadding(new Insets(10,10,10,10));
    	grid2.setVgap(8);
    	grid2.setHgap(10);
    	Button back = new Button("<-");
    	stage2.setTitle("CUSTOMER SERVICE ");
    	Label Email = new Label("EMAIL");
    	TextField EmailT = new  TextField();
    	Label Fname = new Label("FIRST NAME");
    	TextField FnameT = new TextField();
    	Label LName = new Label("LAST  NAME");
    	TextField LnameT = new TextField();
    	Label Query = new Label("QUERY");
    	TextField queryT = new TextField();
    	
    	TextArea message = new TextArea();
    	Button submit = new Button("SUBMIT");
    	message.autosize();
    	Text text2 = new Text("RICHIE CABS");
    	text2.setFont(f);
    	
    	GridPane.setConstraints(text2,1,0);
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints( Email,0,1);
    	GridPane.setConstraints(EmailT,1,1);
    	GridPane.setConstraints(Fname,0,2);
    	GridPane.setConstraints(FnameT,1,2);
    	GridPane.setConstraints(LName,0,3);
    	GridPane.setConstraints(LnameT,1,3);
    	GridPane.setConstraints(Query,0,4);
    	GridPane.setConstraints(queryT,1,4);
    	GridPane.setConstraints(message,1,8);
    	GridPane.setConstraints(submit,2,6);
    	submit.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
               CustomerLogic email1 = new CustomerLogic();
               if(email1.sendMail(EmailT.getText(),FnameT.getText(),LnameT.getText(),message.getText(),queryT.getText())) {
            	   System.out.println("Thank you for your feedback");
               }else {
            	   
            	   System.out.println("MESSAGE NOT SENT");
               }
               
                 stage2.close();
                 
             }
         });
    	
    	grid2.getChildren().addAll(back,text2,Email,EmailT,Fname,FnameT,LName,LnameT,message,Query,queryT,submit);
    	 Scene scene = new Scene(grid2, 650, 450);
    	 grid2.setId("pane");
     	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
	    stage2.setScene(scene);
		
        stage2.show();
    	
    	
    	
    }
    
    public void checkLogin() throws ClassNotFoundException {
    	String  username =nametextfield.getText() ;
    	String password =passtextfield.getText() ;
    	Client client= Client.getInstance();
    	Thread t= new Thread(new Runnable() {
    		public void run()
    		{
    			System.out.println("Client attempting toauthenticate");
    			
    			
    			if(client.authenticate(username,password))
    			{
    				Platform.runLater(()-> showMenu());//good login
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(null, "Bad login");//no login
    			}
    		}
    	});
    	t.start();
    	
    	
//    	//client.authenticator("","");
//    	if ("manager".equals(nametextfield.getText())&& "cabbie".equals(passtextfield.getText())) {
//    		
//    		
//    	}else {
//    		
//    	}
   	
    	
    	
    }
    
    public void PopUpW(String x) {
    	
    	
    	Stage popupwindow = new Stage();
    	popupwindow.initModality(Modality.APPLICATION_MODAL);
    	popupwindow.setTitle("ALERT");
    	      
    	      
    Text label1= new Text(x);
    	     Font j = new Font("Arial",14) ;
    	     
    	Button button1= new Button("OK");
    	     
    	     
    	button1.setOnAction(e -> popupwindow.close());
    	     
    	     

    	VBox layout= new VBox(10);
    	layout.setId("pop"); 
    	   
    	layout.getChildren().addAll(label1, button1);
    	      
    	layout.setAlignment(Pos.CENTER);
    	      
    	Scene scene1= new Scene(layout, 200, 150);
    	scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
    	popupwindow.setScene(scene1);
    	      
    	popupwindow.showAndWait();
    	       
    }
    
    public void ManagerLogin() {
    	Stage stage2 = new Stage();
    	
    	grid.setPadding(new Insets(10,10,10,10));
    	grid.setVgap(8);
    	grid.setHgap(10);
    	
    	
   
    	stage2.setTitle("Manager Login");
    	
    	
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	GridPane.setConstraints(text1,0,0);
    	Label name= new Label("User name");
    	GridPane.setConstraints(name, 0, 1);


    	GridPane.setConstraints(nametextfield, 1, 1);


    	Label password= new Label("Password");
    	GridPane.setConstraints(password,0,2);

    	
    	GridPane.setConstraints(passtextfield, 1,2 );
    	
        Button btn = new Button();
        btn.setText("LOGIN'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
					checkLogin();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
        });
        
        GridPane.setConstraints(btn, 1,3);


        grid.getChildren().addAll(text1,name,nametextfield, password,
                passtextfield,btn);
        
        
        Scene scene = new Scene(grid, 400, 150);
        grid.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage2.setScene(scene);

        stage2.show();
    }
    
    public void showMenu() {
    	
    	Stage stage = new Stage();
    	GridPane grid2 = new GridPane();
    	
    	grid2.setPadding(new Insets(10,10,10,10));
    	grid2.setVgap(8);
    	grid2.setHgap(10);
    	
    	Text label2 = new Text("RICHIE AI");
    	Text label3 = new Text("Main Menu");
    	label2.setFont(f);
    	label3.setFont(f);
    	btn2.setText("ADD CAB");
    	btn3.setText("REMOVE CAB");
    	btn4.setText("SUMMARY REPORT");
    	btn5.setText("MISSED REQUESTS");
    	btn6.setText("FEEDBACK");
    	btn7.setText("LOGOUT");
    	
    	
    	GridPane.setConstraints(label2, 3,0 );
    	GridPane.setConstraints(label3, 3,1 );
    	GridPane.setConstraints(btn2, 2,3 );
    	GridPane.setConstraints(btn3, 3,3 );
    	GridPane.setConstraints(btn4, 2,4 );
    	GridPane.setConstraints(btn5, 3,4 );
    	GridPane.setConstraints(btn6, 2,5 );
    	GridPane.setConstraints(btn7, 3,5 );
    	
    	
    	
    	
    	btn2.setOnAction(new EventHandler<ActionEvent>() {//ADD CAB
            @Override
            public void handle(ActionEvent event) {
               AddCab();
                stage.close();
                
            }
        });
		
    	
    	btn3.setOnAction(new EventHandler<ActionEvent>() {//REMOVE CAB
            @Override
            public void handle(ActionEvent event) {
                removeCab();
                
            }
        });
    	
    	
    	
    	
    	btn4.setOnAction(new EventHandler<ActionEvent>() {//SUMMARY REPORT
            @Override
            public void handle(ActionEvent event) {
                SummaryReport();
            }
        });
    	
    	btn5.setOnAction(new EventHandler<ActionEvent>() {// MISSED REQUESTS
            @Override
            public void handle(ActionEvent event) {
                missedRequests();
                
                
            }
        });
    	
    	
    	
    	
    	
    	
    	btn6.setOnAction(new EventHandler<ActionEvent>() {//FEEDBACK
            @Override
            public void handle(ActionEvent event) {
              feedback();
                
            }
        });
    	
    	btn7.setOnAction(new EventHandler<ActionEvent>() {//LOGOUT
            @Override
            public void handle(ActionEvent event) {
                Stage  Menu = new Stage();
                start(Menu);
                stage.close();
                
                
            }
        });
    	
    grid2.getChildren().addAll(btn2,btn3,btn4,btn5,btn6,btn7,label2,label3);
    	
    	
    	Scene scene = new Scene(grid2, 400, 250);
    	grid2.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    	        stage.setScene(scene);
    	
    	        stage.show();
    	
    	
    	
    	
	}
    
    public void AddCab() {
    	Stage stage2 = new Stage();
    	stage2.setTitle("ADD CAB");
    	GridPane grid3 = new GridPane();
    	grid3.setPadding(new Insets(10,10,10,10));
    	grid3.setVgap(8);
    	grid3.setHgap(10);
    	TextField trn = new TextField();
    	
    	TextField name = new TextField();
    	TextField model = new TextField();
    	TextField year = new TextField();
    	Button back = new Button ("<-");
    	Button submit = new Button ("Submit");
    	Label NAME = new Label("Name");
    	
    	Label TRN =  new Label("TRN");
    	Text AI = new Text("RICHIE AI");
    	AI.setFont(f);
    Text ADc = new Text ("ADD CAB");
    ADc.setFont(f);
    	Label m1 = new Label("MODEL");
    	Label YEAR = new Label("YEAR");
    	// final ImageView imv = new ImageView();
         //final Image image2 = new Image(Main.class.getResourceAsStream("C:\\Users\\berge\\Desktop\\GROUP TAXI\\taxi4.gif"));
         //imv.setImage(image2);
       //  GridPane.setConstraints(imv,1,2);
         

    	
    	GridPane.setConstraints(AI,2,0);
    	GridPane.setConstraints(ADc,2,1);
    	GridPane.setConstraints(NAME,1,3);
    	GridPane.setConstraints(name, 2,3);
    	GridPane.setConstraints(m1,1,4);
    	GridPane.setConstraints(model,2,4);
    	
    	GridPane.setConstraints(TRN,1,5);
    	GridPane.setConstraints(trn,2,5);
    	GridPane.setConstraints(YEAR,1,6);
    	GridPane.setConstraints(year,2,6);
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints(submit,4,7);
    	
    	back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showMenu();
                stage2.close();
                
            }
        });
    	submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	//Function to accept data and pass to database should be called here
                showMenu();
                TaxiProvider addcab = new TaxiProvider();
               int x= addcab.add(new Taxi(0,name.getText(),name.getText(),trn.getText(),(new Vehicle(model.getText(),year.getText()))));
                if(x==1) {PopUpW("RECORD ADDED ");}////PUT THEPOP UP PANE
               stage2.close();
                
            }
        });
    	
    	grid3.getChildren().addAll(name,model,AI,ADc,NAME,m1,TRN,trn,year,YEAR,back,submit);
    	
    	
    	
    	Scene scene = new Scene(grid3, 400, 250);
    	grid3.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage2.setScene(scene);

        stage2.show();
        

    }
    public void removeCab() {
    	Stage stage2 = new Stage();
    	stage2.setTitle("REMOVE CAB");
    	GridPane grid3 = new GridPane();
    	grid3.setPadding(new Insets(10,10,10,10));
    	grid3.setVgap(8);
    	grid3.setHgap(10);
    	Text AI = new Text("RICHIE AI");
    	AI.setFont(f);
    		
    	Label Rcab  = new Label("Remove Cab");
    	Label Se = new Label ("Search");
    	TextField Search = new TextField();
    	TextField   Results = new TextField();
    	Button back = new Button ("<-");
    	Button search = new Button ("Search");
    		
    	GridPane.setConstraints(AI,1,1);
    	GridPane.setConstraints(Rcab,2,2);
    	GridPane.setConstraints(Se,1,3);
    	GridPane.setConstraints(Search, 2,3);
    	GridPane.setConstraints(Results,2,5);
    
    	GridPane.setConstraints(search,2,4);
    	GridPane.setConstraints(back,0,0);
    	////REMEMBER TO RESTRICT INPUT TO INTEGERS 
    	back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showMenu();
                stage2.close();
                stage2.close();
                
                
            }
        });
    	search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showMenu();
                TaxiProvider up = new TaxiProvider();
               if(up.update(Integer.parseInt(Search.getText()))==1) {
            	   Results.setText(" CAB REMOVED");
            	  stage2.showAndWait();
            	  stage2.close();
            	  
            	  
               }
                
                
                
            }
        });
    
    
    	
    	
    	
grid3.getChildren().addAll(AI,Rcab,Se,Search,back,search,Results);
    	
    	
    	
    	Scene scene = new Scene(grid3, 400, 250);
    	grid3.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage2.setScene(scene);
        
        stage2.show();
    }
    
    public void SummaryReport() {
    	Stage stage2 = new Stage();
    	stage2.setTitle("SUMMARY REPORT");
    	GridPane grid3 = new GridPane();
    	grid3.setPadding(new Insets(10,10,10,10));
    	grid3.setVgap(8);
    	grid3.setHgap(10);
    	Button back = new Button ("<-");
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	TextArea Sum = new TextArea();
    	Label Summary = new Label("SUMMARY REPORTS");
    	
    	
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints(text1,0,1);
    	GridPane.setConstraints(Summary,0,3);
    	GridPane.setConstraints(Sum,0,4);
    	
    	/////ADD THE CONTENTS OF THE TEXT FIELD;
    	grid3.getChildren().addAll(back,text1,Summary,Sum);
    	TaxiProvider x2 = new TaxiProvider();
    	
    	List<taxi.SummaryReport> results = x2.summaryReport();
    	for(taxi.SummaryReport report:results) {
    		Sum.appendText(report.toString());
    	}
    	
    	back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showMenu();
                stage2.close();
                
            }
        });
    	
    	
    	
    	Scene scene = new Scene(grid3, 400, 350);
    	grid3.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage2.setScene(scene);
        
        stage2.show();
    	
    	
    }
    
    public void missedRequests() {
    	
    	
    	
    	
    	Stage stage2 = new Stage();
    	stage2.setTitle("MISSED REQUESTS");
    	GridPane grid3 = new GridPane();
    	grid3.setPadding(new Insets(10,10,10,10));
    	grid3.setVgap(8);
    	grid3.setHgap(10);
    	Button back = new Button ("<-");
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	TextArea Sum = new TextArea();
    	Label Summary = new Label("MISSED REQUESTS");
    	
    	
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints(text1,0,1);
    	GridPane.setConstraints(Summary,0,3);
    	GridPane.setConstraints(Sum,0,4);
    	
    	/////ADD THE CONTENTS OF THE TEXT FIELD;
    	grid3.getChildren().addAll(back,text1,Summary,Sum);
    	
    	back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showMenu();
                stage2.close();
                
            }
        });
    	
    	MissedRequestProvider x2 = new MissedRequestProvider();
    	List<CustomerLogic> results = x2.selectAll();
    	for(CustomerLogic report:results) {
    		Sum.appendText(report.toString());
    	}
    	
    	
    	Scene scene = new Scene(grid3, 400, 350);
    	grid3.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage2.setScene(scene);
        
        stage2.show();
    	
    	
    	
    	
    }
    public void feedback() {
    	
    	
    	
    	
    	Stage stage2 = new Stage();
    	stage2.setTitle("FEEDBACK ");
    	GridPane grid3 = new GridPane();
    	grid3.setPadding(new Insets(10,10,10,10));
    	grid3.setVgap(8);
    	grid3.setHgap(10);
    	Button back = new Button ("<-");
    	Text text1 = new Text("RICHIE CABS");
    	text1.setFont(f);
    	TextArea Sum = new TextArea();
    	Label Summary = new Label("FEEDBACK");
    	TextField Search1 = new TextField();
    	
    	Button Search =  new Button("Search");
    	
    	GridPane.setConstraints(back,0,0);
    	GridPane.setConstraints(text1,0,1);
    	GridPane.setConstraints(Summary,0,3);
    	GridPane.setConstraints(Search, 0, 4);
    	GridPane.setConstraints(Search1, 0, 5);
  	GridPane.setConstraints(Sum,0,6);
    	
    	
    	grid3.getChildren().addAll(back,text1,Summary,Sum,Search1,Search);
    	
    	back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showMenu();
                stage2.close();
                
            }
        });
    	Search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              String y =   Search1.getText();
                // ADDD FUNCTION
                
            }
        });
    	
    	
    	
    	
    	Scene scene = new Scene(grid3, 400, 350);
    	grid3.setId("pane");
    	scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage2.setScene(scene);
        
        stage2.show();
    	
    	
    }
    
   
}

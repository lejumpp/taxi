package customerService;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import users.Customer;

public class Email 
{
	private String subject;
	private String messageText, from;
	private Customer custInfo;
 
	@SuppressWarnings("restriction")
	public boolean sendEmail()
	{
        try
        {
            String host ="smtp.gmail.com" ;
            String user = "advanceprogramming19@gmail.com";
            String pass = "Cit3009Sem2";
            String to = "richietaxiAI@dlink.gq";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(this.subject); msg.setSentDate(new Date());
            msg.setText("From: "+custInfo.getFirstName()+" "+custInfo.getLastName()+"\t Email Address: "+from+"\n"+this.messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
		return false;

    }

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Customer getCustInfo() {
		return custInfo;
	}

	public void setCustInfo(Customer custInfo) {
		this.custInfo = custInfo;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}

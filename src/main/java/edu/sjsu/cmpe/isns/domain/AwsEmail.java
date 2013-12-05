package edu.sjsu.cmpe.isns.domain;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class AwsEmail {

    

   public AwsEmail(ArrayList<String> emails, String body) throws Exception {
    	String FROM = "theja.vangumalli@gmail.com";   // Replace with your "From" address. This address must be verified.
        String[] TO = new String[emails.size()];  // Replace with a "To" address. If you have not yet requested
        TO=emails.toArray(TO);                                                   // production access, this address must be verified.
        
        String BODY = body;
        String SUBJECT = "ISNS.";
        
        // Supply your SMTP credentials below. Note that your SMTP credentials are different from your AWS credentials.
        String SMTP_USERNAME = "AKIAJJ3NS6XPK55ONJ2A";  // Replace with your SMTP username.
        String SMTP_PASSWORD = "AmLqWqzG1Q0CBySLnlhG+XqBHG8yGCvXkXauVsfLTKCr";  // Replace with your SMTP password.
        
        // Amazon SES SMTP host name.
        String HOST = "email-smtp.us-east-1.amazonaws.com";    
        
        // Port we will connect to on the Amazon SES SMTP endpoint. We are choosing port 25 because we will use
        // STARTTLS to encrypt the connection.
        int PORT = 587;

        // Create a Properties object to contain connection configuration information.
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	
    	// Set properties indicating that we want to use STARTTLS to encrypt the connection.
    	// The SMTP session will begin on an unencrypted connection, and then the client
        // will issue a STARTTLS command to upgrade to an encrypted connection.
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.starttls.required", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        for(int i=0;i<TO.length;i++)
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(TO[i]));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/plain");
            
        // Create a transport.        
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();        	
        }
    }
}
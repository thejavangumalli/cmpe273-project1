package edu.sjsu.cmpe.isns.ui.resources;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




import edu.sjsu.cmpe.isns.ui.views.RegistrationView;


@Path("/register")
@Produces(MediaType.TEXT_HTML)
public class RegistrationResource {

  @GET
  public RegistrationView registerUser() throws UnknownHostException   
  {
	  System.out.println("In post call RegistrationResour");
	return new RegistrationView("home.mustache");  
  }
  
 
}
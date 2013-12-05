package edu.sjsu.cmpe.isns.ui.resources;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe.isns.dto.UsersDto;
import edu.sjsu.cmpe.isns.ui.views.AdminView;
import edu.sjsu.cmpe.isns.ui.views.HomeView;


@Path("/login")
@Produces(MediaType.TEXT_HTML)
public class AdminResource {

  
 
	@Path("/2")
  @POST
  public AdminView validateUser() throws UnknownHostException   
  {
	  System.out.println("In post call AdminResour");
	return new AdminView();  
  }
  
 
}
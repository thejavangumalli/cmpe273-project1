package edu.sjsu.cmpe.isns.api.resources;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.sjsu.cmpe.isns.domain.User;
import edu.sjsu.cmpe.isns.dto.UserDto;
import edu.sjsu.cmpe.isns.dto.UsersDto;
import edu.sjsu.cmpe.isns.repository.DBConnection;
import edu.sjsu.cmpe.isns.ui.views.AdminView;
import edu.sjsu.cmpe.isns.ui.views.HomeView;


@SuppressWarnings("unused")
@Path("/v1/users")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {           
	private Object[] a;
	public UserResource() 
	{
		// do nothing
	}

@GET

	// @Path("/alldeptusers")

	@Path("/display/{dept}")

	@Produces(MediaType.APPLICATION_JSON)

	public Response getdeptUsers(@PathParam("dept") String department) throws UnknownHostException

	{

		UsersDto usersResponse1 = new UsersDto();
		System.out.println(usersResponse1.getAlldeptUsers(department));

		String res="{\"username\":["+usersResponse1.getAlldeptUsers(department)+"]}";

		int position=res.lastIndexOf(",");

		String jsonBody = res.substring(0,position)+""+res.substring(position+1);


		return Response.status(200)

				.entity(jsonBody)

				.build();

	}


}

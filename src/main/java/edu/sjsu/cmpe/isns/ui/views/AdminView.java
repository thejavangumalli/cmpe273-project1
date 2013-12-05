package edu.sjsu.cmpe.isns.ui.views;

import java.util.List;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.isns.domain.User;


public class AdminView extends View {
	private List<User> users=null;

    public AdminView() {
    	
	super("login.mustache");
	System.out.println("In Admin View");
    }
    	

      public AdminView getAdmin() {
    	return new AdminView();
}
    
 
}

package edu.sjsu.cmpe.isns.ui.views;

import java.util.List;

import com.yammer.dropwizard.views.View;

import edu.sjsu.cmpe.isns.domain.User;


public class HomeView extends View {
	private List<User> users=null;

    public HomeView() {
    	
	super("login.mustache");
	System.out.println("In Home View");
    }
    	

    
 
}

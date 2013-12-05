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
    	
    public HomeView(List<User> users) {
    	super("displayusers.mustache");
    	System.out.println("HomeView"+users);
    	this.users = users;
    	System.out.println(this.users);
    	
        }
    public HomeView(String fileName) {
    	
    	super(fileName);
    	this.users = users;
    System.out.println("In Home View");
        }
    public List<User> getUsers() {
    	System.out.println("GetHome"+this.users);
        return this.users;
}
    
 
}

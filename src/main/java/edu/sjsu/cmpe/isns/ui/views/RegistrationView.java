package edu.sjsu.cmpe.isns.ui.views;


import com.yammer.dropwizard.views.View;




public class RegistrationView extends View {
	

    public RegistrationView() {
    	
	super("home.mustache");
	System.out.println("In Home View");
    }


		 public RegistrationView(String fileName) {

		    	super(fileName);
		    	 
		    System.out.println("In Home View");
		        }

  
   

 
}

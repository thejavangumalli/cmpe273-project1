package edu.sjsu.cmpe.isns.config;

import com.yammer.dropwizard.config.Configuration;

public class NotificationServiceConfiguration extends Configuration {
	
	public String clientName;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
 
}

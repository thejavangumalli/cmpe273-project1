package edu.sjsu.cmpe.isns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

import edu.sjsu.cmpe.isns.api.resources.RootResource;
import edu.sjsu.cmpe.isns.api.resources.UserResource;
import edu.sjsu.cmpe.isns.config.NotificationServiceConfiguration;
import edu.sjsu.cmpe.isns.ui.resources.AdminResource;
import edu.sjsu.cmpe.isns.ui.resources.HomeResource;
import edu.sjsu.cmpe.isns.ui.resources.RegistrationResource;


public class NotificationService extends
		Service<NotificationServiceConfiguration> {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) throws Exception {
		new NotificationService().run(args);
	}

	@Override
	public void initialize(Bootstrap<NotificationServiceConfiguration> bootstrap) {
		bootstrap.setName("intra-store");
		bootstrap.addBundle(new ViewBundle());
		bootstrap.addBundle(new AssetsBundle());
	}

	@Override
	public void run(NotificationServiceConfiguration configuration,
			Environment environment) throws Exception {

		/** Root API */
		environment.addResource(RootResource.class);
		/** User APIs */
		// BookRepositoryInterface kRepository = new BookRepository();
		environment.addResource(UserResource.class);

		/** UI Resources */
		 environment.addResource(new HomeResource());
		 environment.addResource(new AdminResource());
		 environment.addResource(new RegistrationResource());

	}
}

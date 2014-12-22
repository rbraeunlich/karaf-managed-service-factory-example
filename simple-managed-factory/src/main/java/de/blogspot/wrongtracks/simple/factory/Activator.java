package de.blogspot.wrongtracks.simple.factory;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedServiceFactory;

public class Activator implements BundleActivator {

	private ServiceRegistration registration;

	public void start(BundleContext context) throws Exception {
		Hashtable<String, String> props = new Hashtable<String, String>(1);
		props.put(Constants.SERVICE_PID, Factory.PID);
		registration = context.registerService(ManagedServiceFactory.class.getName(), new Factory(), props);
	}

	public void stop(BundleContext context) throws Exception {
		registration.unregister();
	}

}

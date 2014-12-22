package de.blogspot.wrongtracks.simple.factory;

import java.util.Collections;
import java.util.Dictionary;
import java.util.logging.Logger;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;

public class Factory implements ManagedServiceFactory {

	static final String PID = "de.blogspot.wrongtracks.simple.factory.Factory";

	private static final Logger LOGGER = Logger.getLogger(PID);

	public String getName() {
		return PID;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updated(String pid, Dictionary properties)
			throws ConfigurationException {
		LOGGER.info("Got pid: " + pid + " with following dictionary.");
		for (Object key : Collections.list(properties.keys())) {
			LOGGER.info("key: " + key + " value: " + properties.get(key));
		}
	}

	public void deleted(String pid) {
		LOGGER.info("Deleting pid " + pid);
	}

}

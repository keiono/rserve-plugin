package org.cytoscape.rserve.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

public class CyActivator extends AbstractCyActivator {

	public CyActivator() {
		super();
	}

	public void start(BundleContext bc) {

		// Get appropriate factories and managers
		final CyNetworkFactory networkFactory = getService(bc, CyNetworkFactory.class);
		final CyNetworkManager networkManager = getService(bc, CyNetworkManager.class);

		try {
			RConnection c = new RConnection();
			REXP x = c.eval("R.version.string");
			System.out.println("Connection test passed: " + x.asString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

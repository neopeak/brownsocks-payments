/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments.gateways;

/**
 * <p>
 * Base interface for a java bean that holds the runtime 
 * configuration details for a gateway. 
 * </p>
 * 
 * <p>
 * Whenever possible, all the runtime configuration such as
 * account number, password, key files, server URL's, should
 * be configured inside a java bean implementing this class
 * </p>
 * 
 * <p>
 * Relying on external configuration files is discouraged,
 * although most vendor supplied java libraries will require
 * a configuration file.
 * </p>
 * 
 * @author cveilleux@neopeak.com
 */
public interface GatewayAccount {
	
	/**
	 * Indicates that this is a test account, no real transactions will
	 * occur. 
	 * 
	 * @return
	 */
	public boolean isTestAccount();
	
}

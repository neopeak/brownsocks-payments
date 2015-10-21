/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments.gateways;

public class GatewayInitializationException extends Exception {

	private static final long serialVersionUID = 1L;

	public GatewayInitializationException() {
		super();
	}

	public GatewayInitializationException(String message, Throwable cause) {
		super(message, cause);
	}

	public GatewayInitializationException(String message) {
		super(message);
	}

	public GatewayInitializationException(Throwable cause) {
		super(cause);
	}

}

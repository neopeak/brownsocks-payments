/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments.gateways;

/**
 * Indicates that the request is not supported by the gateway.
 * 
 * If a gateway does not support some payment request types 
 * (AUTH, CAPTURE or CREDIT) or the lookupPayment method, this
 * exception will be thrown. 
 * 
 * @author cveilleux@neopeak.com
 */
public class UnsupportedGatewayRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnsupportedGatewayRequestException() {
		super();
	}

	public UnsupportedGatewayRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedGatewayRequestException(String message) {
		super(message);
	}

	public UnsupportedGatewayRequestException(Throwable cause) {
		super(cause);
	}

}

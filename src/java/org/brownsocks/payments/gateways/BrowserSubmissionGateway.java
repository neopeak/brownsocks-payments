/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments.gateways;

import org.brownsocks.payments.PaymentRequest;

/**
 * Interface for link based payment gateway. At this point, only payment gateways using GET requests
 * are supported.
 * 
 * @author cveilleux@neopeak.com
 */
public interface BrowserSubmissionGateway<B extends GatewayAccount> extends PaymentGateway<B> {
	
	/**
	 * Builds an HTTP GET URL, where the customer will be redirected.
	 * @param request
	 * @return
	 */
	public String getPaymentURL(PaymentRequest request);
	
}

/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments.gateways;

import org.brownsocks.payments.PaymentResult;
import org.brownsocks.payments.PaymentsListener;

/**
 * <p>Base interface for payment gateways implementation.</p>
 * 
 * <p>Use either <code>BrowserSubmissionGateway</code> or <code>ServerSubmissionGateway</code>
 * for you implementations.
 * 
 * @author cveilleux@neopeak.com
 * @param <A>
 */
public abstract interface PaymentGateway<A extends GatewayAccount> {

	public void addPaymentsListener(PaymentsListener listener);
	
	public void removePaymentsListener(PaymentsListener listener);
	
	public void setGatewayAccount(A gatewayAccount);
	
	public void initialize() throws GatewayInitializationException;
	
	public PaymentResult lookup(String merchantTxnID) throws UnsupportedGatewayRequestException;
	
}

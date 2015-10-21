/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments.gateways;

import org.brownsocks.payments.PaymentRequest;
import org.brownsocks.payments.PaymentResult;

public interface ServerSubmissionGateway<B extends GatewayAccount> extends PaymentGateway<B> {

	public PaymentResult authorize(PaymentRequest request) throws UnsupportedGatewayRequestException;
	
	public PaymentResult capture(PaymentRequest request) throws UnsupportedGatewayRequestException;
	
	public PaymentResult credit(PaymentRequest request) throws UnsupportedGatewayRequestException;
	
	public PaymentResult sale(PaymentRequest request) throws UnsupportedGatewayRequestException;
	
}

/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments.gateways;

import java.util.HashSet;
import java.util.Set;

import org.brownsocks.payments.PaymentResult;
import org.brownsocks.payments.PaymentsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gateways should extend this class so they can notify the client
 * app of payment events.
 * @author cveilleux@neopeak.com
 */
public abstract class PaymentsListenerSupport {
	
	private static final Logger _log = LoggerFactory.getLogger(PaymentsListenerSupport.class); 
	
	private Set<PaymentsListener> _paymentListeners;

	public PaymentsListenerSupport() {
		super();
		_paymentListeners = new HashSet<PaymentsListener>();
	}

	public void addPaymentsListener(PaymentsListener listener) {
		_paymentListeners.add(listener);
	}
	
	public void removePaymentsListener(PaymentsListener listener) {
		_paymentListeners.remove(listener);
	}

	protected void sendPaymentProcessingEvent(PaymentResult result) {
		sendEvent(result, true);
	}
	
	protected void sendPaymentReceivedEvent(PaymentResult result) {
		sendEvent(result, false);
	}
	
	private void sendEvent(PaymentResult result, boolean processing) {
		for (PaymentsListener listener : _paymentListeners) {
			try {
				if (processing)
					listener.paymentProcessing(result);
				else
					listener.paymentReceived(result);
				
			} catch (Throwable t) {
				_log.warn("Payment listener \"" + listener + "\" threw exception: " + t.getMessage(), t);
			}
		}
	}

}

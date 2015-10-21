/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments;

/**
 * Appications using the Brownsocks Payments API can implement
 * this interface to receive notifications about payments.
 * 
 * Implementation should check the payments status and record them
 * to a database or whatever else you want.
 * 
 * @author cveilleux@neopeak.com
 */
public interface PaymentsListener {
	
	/**
	 * Indicates that a payment is 'processing'. This is usually
	 * because the customer is being re-directed to an external site
	 * to complete the payment (browser submission or 3D-secure /
	 * verified by visa).
	 * 
	 * The payment is NOT final at this point. Once the payment is
	 * finalized, paymentReceived() method will be called, which may
	 * never happen if the customer abandons the process.
	 * 
	 * @param result
	 */
	public void paymentProcessing(PaymentResult result);
	
	
	/**
	 * Indicates that a payment has been received.
	 * 
	 * The payment may be successful or failed.
	 * 
	 * In any case, only one call is made to this method per payment,
	 * once the payment is finalized.
	 * 
	 * The paymentProcessing() method may or may not have been called
	 * before. 
	 *  
	 * @param result
	 */
	public void paymentReceived(PaymentResult result);
	
}

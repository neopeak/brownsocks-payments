/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */


package org.brownsocks.payments;

/**
 * Defines high-level payment error types.
 * Payment gateways should do their best to return the most best matching error type.
 * 
 * @author cveilleux@neopeak.com
 */
public enum PaymentResultType {
	
	SUCCESS,
	
	/**
	 * Indicates that 3D secure verification is required to complete this transaction.
	 * @see PaymentResult.get3DSecureResponse() 
	 */
	REQUIRES_3D_SECURE_VERIF,
	
	/**
	 * 3D secure verification failed.
	 */
	ERROR_3D_SECURE_VERIFICATION_FAILED,
	
	/**
	 * Configuration error. Usually indicates that nothing has even been sent to the gateway.
	 */
	ERROR_INTERNAL,
	
	/**
	 * Gateway complained about the customer information.
	 */
	ERROR_CUSTOMER,
	
	/**
	 * Gateway complained about the credit card details.
	 */
	ERROR_CARD,
	
	/**
	 * Gateway complained about customer or card, or the combination of the two (i.e., card owner does not match card number).
	 */
	ERROR_CUSTOMER_OR_CARD,
	
	/**
	 * Gateway complained about some invalid field in the request (other than customer or card info)
	 */
	ERROR_INVALID_REQUEST,
	
	/**
	 * Card was declined.
	 */
	ERROR_CARD_DECLINED,
	
	/**
	 * Gateway complained of internal error, such as gateway can't communicate with banking system. 
	 */
	ERROR_REMOTE,
	
	/**
	 * A network error occured (time-out). The payment status is then unknown (may or may not have succeded!)
	 */
	ERROR_NETWORK,
	
	/**
     * Indicate that a non-permanent error occured during the process. The transaction should be retried.
     */
	ERROR_NOT_PROCESSED,
	
	/**
     * Potential fraud attempt. The credit card may have been reported stolen. For browser submission, this may indicate
     * an hacking attempt (invalid post back request received).
     */
	ERROR_SUSPECT,
	
	/**
	 * The merchant account with the processor is invalid. Check payment processor configuration.
	 */
	ERROR_INVALID_MERCHANT,
	
	/**
	 * Duplicate transaction, usually means remote server rejected the transaction because
	 * merchant txn id was not unique.
	 */
	ERROR_DUPLICATE_TRANSACTION,
	
	/**
	 * The transaction has been cancelled.
	 */
	ERROR_TRANSACTION_CANCELLED,
	
	/**
	 * Unknown error. Usually indicates that the status code returned by the gateway is not recognized. 
	 * Check gateway documentation for more details.
	 */
	ERROR_UNKNOWN;
}

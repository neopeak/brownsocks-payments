/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments;

/**
 * <p>
 * Type of transaction to process.
 * </p>
 * 
 * <p>
 * Payment gateways may not support all operation types.
 * </p>
 * 
 * <p>
 * SALE: AUTH + CAPTURE<br />
 * AUTH: Authorize (freeze) the funds.<br />
 * CAPTURE: Charge previously AUTHorized funds.<br />
 * CREDIT: Reverse a SALE or AUTH transaction.<br />
 * </p>
 * 
 * @author cveilleux@neopeak.com
 * @since 1.0
 */
public enum PaymentOperation {
	SALE,AUTH,CAPTURE,CREDIT;
}

/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * If Secure 3D verification (aka Verified by visa) is required for
 * a transaction, the PaymentResult bean returned by the gateway will
 * contain this additional bean.
 * 
 * You then need to generate an HTTP form and that contains the ACS fields
 * and post it to the acs URL.
 * 
 * @author cveilleux@neopeak.com
 */
public class Secure3DResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> _acsFields;
	
	private String _acsURL;

	public Secure3DResponse(String acsURL) {
		super();
		_acsURL = acsURL;
		_acsFields = new HashMap<String, String>();
	}
	
	public void addAcsField(String key, String value) {
		_acsFields.put(key, value);
	}

	public Map<String, String> getAcsFields() {
		return _acsFields;
	}

	public String getAcsURL() {
		return _acsURL;
	}

}

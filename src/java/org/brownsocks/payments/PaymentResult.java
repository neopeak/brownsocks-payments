/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PaymentResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private boolean _completed;
    
	/**
     * Success or high level error type.
     */
    private PaymentResultType _resultType;
    
    /**
     * Gateway specific error code.
     */
    private String _errorCode;
    
    /**
     * Gateway specific error message.
     */
    private String _errorMessage;
    
    /**
     * Gateway specifc confirmation code.
     */
    private String _confirmationCode;
    
    /**
     * Secure 3D response (only if resultType == REQUIRES_3D_SECURE_VERIF)
     */
    private Secure3DResponse _secure3dResponse;
    
    /**
     * Raw data from the gateway.
     */
    private Map<String,String> _metas = new HashMap<String,String>();
    
    protected String _merchantTxnID;
    
    private PaymentOperation _paymentOperation;
    
    private Date _startTime;
    private Date _endTime;
    
    private int _amount;
    
    private String _currency;

    public PaymentResult() {
		this(null);
	}

	public PaymentResult(PaymentOperation operation) {
    	_completed = false;
    	_resultType = PaymentResultType.ERROR_UNKNOWN;
    	_startTime = new Date();
    	_paymentOperation = operation;
    }
	
    public String getMerchantTxnID() {
		return _merchantTxnID;
	}

	public void setMerchantTxnID(String merchantTxnID) {
		_merchantTxnID = merchantTxnID;
	}

	public boolean isError() {
    	if (!_completed)
    		return false;
    	
    	if (PaymentResultType.SUCCESS.equals(_resultType))
    		return false;
    	
    	if (PaymentResultType.REQUIRES_3D_SECURE_VERIF.equals(_resultType))
    		return false;
    	
        return true;
    }
    
    public boolean isSuccess() {
    	if (!_completed)
    		return false;
    	
    	return !isError();
    }
    
    public boolean isTemporaryError() {
    	if (!_completed)
    		return false;
    	
    	if (isSuccess())
    		return false;
    	
    	switch(_resultType) {
    		case ERROR_NETWORK:
    		case ERROR_NOT_PROCESSED:
    		case ERROR_REMOTE:
    			return true;
    	}
    	
    	return false;
    }

    /**
     * True if the payment has completed (successfully or not).
     * False if the payment is not yet completed or if it has not been
     * processed.
     * @return
     */
    public boolean isCompleted() {
        return _completed;
    }

    public void setCompleted(boolean completed) {
        _completed = completed;
    }

    public String getErrorCode() {
        return _errorCode;
    }

    public void setErrorCode(String errorCode) {
        _errorCode = errorCode;
    }

    /**
     * The error message that was received from the payment processor.
     */
    public String getErrorMessage() {
        return _errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        _errorMessage = errorMessage;
    }

    /**
     * @return the confirmationCode
     */
    public String getConfirmationCode() {
        return _confirmationCode;
    }

    /**
     * @param confirmationCode the confirmationCode to set
     */
    public void setConfirmationCode(String confirmationCode) {
        _confirmationCode = confirmationCode;
    }
    
    /**
     * 3D secure details. Provided only if the resultType is REQUIRES_3D_SECURE_VERIF.
     * @return
     */
    public Secure3DResponse getSecure3dResponse() {
		return _secure3dResponse;
	}

	public void setSecure3dResponse(Secure3DResponse secure3dResponse) {
		_secure3dResponse = secure3dResponse;
	}

	public Map<String,String> getMetas() {
        return _metas;
    }

    public void setMetas(Map<String,String> metas) {
        _metas = metas;
    }

    /**
     * Utility method to add some meta info
     *
     * @param key
     * @param value
     */
    public void addMeta(String key, String value) {
        if (value != null)
            _metas.put(key, value);
        else
            _metas.put(key, "");
    }

	public PaymentResultType getResultType() {
		return _resultType;
	}

	public void setResultType(PaymentResultType resultType) {
		_resultType = resultType;
	}

	public PaymentOperation getPaymentOperation() {
		return _paymentOperation;
	}

	public void setPaymentOperation(PaymentOperation paymentOperation) {
		_paymentOperation = paymentOperation;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}
	
	public int getAmount() {
		return _amount;
	}

	public void setAmount(int amount) {
		_amount = amount;
	}
	
	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public void markCompletion() {
		setCompleted(true);
		setEndTime(new Date());
	}
	
}

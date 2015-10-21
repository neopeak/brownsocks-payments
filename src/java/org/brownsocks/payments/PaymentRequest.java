/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */
package org.brownsocks.payments;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;


/**
 * <p>A credit card payment request.</p>
 * 
 * @author cveilleux@neopeak.com
 * @since 1.0
 */
public class PaymentRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
    protected CustomerInfo _customerInfo;
    protected String _merchantTxnID;
    protected String _cardNumber;
    protected int _cardExpiryMonth;
    protected int _cardExpiryYear;
    protected CardType _cardType;
    protected String _ccv;
    protected int _amount = 0;
    protected String _currency;
    protected String _ip;
    
    protected String _itemDescription;
    
	public PaymentRequest() {
		super();
	}

	public CustomerInfo getCustomerInfo() {
        return _customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        _customerInfo = customerInfo;
    }

    /**
     * A unique transaction ID assigned by the merchant.
     * @return
     */
    public String getMerchantTxnID() {
		return _merchantTxnID;
	}

	public void setMerchantTxnID(String merchantTxnID) {
		_merchantTxnID = merchantTxnID;
	}
	
    public String getCardNumber() {
        return _cardNumber;
    }

	public void setCardNumber(String cardNumber) {
        _cardNumber = cardNumber;
    }

    /**
     * From 1 to 12, representing the month number
     */
    public int getCardExpiryMonth() {
        return _cardExpiryMonth;
    }

    public void setCardExpiryMonth(int cardExpiryMonth) {
        _cardExpiryMonth = cardExpiryMonth;
    }

    /**
     * Full year representation (ex: 2004)
     */
    public int getCardExpiryYear() {
        return _cardExpiryYear;
    }

    public void setCardExpiryYear(int cardExpiryYear) {
        _cardExpiryYear = cardExpiryYear;
    }

    public CardType getCardType() {
        return _cardType;
    }

    public void setCardType(CardType cardType) {
        _cardType = cardType;
    }

    /**
     * The 3-4 letter card verification value
     */
    public String getCcv() {
        return _ccv;
    }

    public void setCcv(String ccv) {
        _ccv = ccv;
    }

    /**
     * 
     * @return the amount in cents
     */
    public int getAmount() {
        return _amount;
    }

    /**
     * 
     * @param amount the amount in cents
     */
    public void setAmount(int amount) {
        _amount = amount;
    }


    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String currency) {
        _currency = currency;
    }

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}
	
	public String getItemDescription() {
		return _itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		_itemDescription = itemDescription;
	}

	/**
	 * Convert the amount to decimal (dollars) according to the 
	 * currency.
	 * @return
	 */
	public BigDecimal getCurrencyAmount() {
		Currency currency = Currency.getInstance(getCurrency());
		return new BigDecimal(new BigInteger(new Integer(getAmount()).toString()), currency.getDefaultFractionDigits());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_merchantTxnID == null) ? 0 : _merchantTxnID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentRequest other = (PaymentRequest) obj;
		if (_merchantTxnID == null) {
			if (other._merchantTxnID != null)
				return false;
		} else if (!_merchantTxnID.equals(other._merchantTxnID))
			return false;
		return true;
	}
	
}

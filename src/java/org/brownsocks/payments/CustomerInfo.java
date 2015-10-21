/*
 * Copyright Neopeak Internet Solutions inc.
 * 
 * This file is part of the Brown Socks project. See accompanying
 * LICENSE file for legal restrictions.
 */

package org.brownsocks.payments;

import java.io.Serializable;
import java.util.Locale;

/**
 * <p>Java bean holding the card-holder's information.</p>
 * 
 * @author cveilleux@neopeak.com
 * @since 1.0
 */
public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private Locale language;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    
    /**
     * 2 didgits ISO standards contry code
     */
    private String country;
    
    private String zipcode;
    
    /**
     * Utility method to get the full name of the customer
     *
     * @return firstName middleName lastName
     */
    public String getFullName() {
        String fullName = new String();
        if (firstName != null && !firstName.equals("")) {
            fullName = firstName;
        }

        if (middleName != null && !middleName.equals("")) {
            fullName = fullName.concat(" " + middleName);
        }

        if (lastName != null && !lastName.equals("")) {
            fullName = fullName.concat(" " + lastName);
        }


        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Locale getLanguage() {
        return language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kent
 */
public class Customer {
    
    private SimpleStringProperty customerId, customerFirstName, customerLastName,
            customerState, customerCity, customerZip, customerEmail, 
            customerAddress, customerPhone;
   
    public Customer(String id, String firstName, String lastName, String state, 
            String city, String zip, String address, String email, String phone)
    {
        setCustomerId(id);
        setCustomerLastName(lastName);
        setCustomerFirstName(firstName);
        setCustomerCity(city);
        setCustomerPhone(phone);
        setCustomerState(state);
        setCustomerZip(zip);
        setCustomerAddress(address);
        setCustomerEmail(email);
    }

    /**
     * @return the customerId
     */
    private String getCustomerId() {
        return customerId.get();
    }

    /**
     * @param customerId the customerId to set
     */
    private void setCustomerId(String customerId) {
        this.customerId.set(customerId);
    }

    /**
     * @return the customerFirstName
     */
    private String getCustomerFirstName() {
        return customerFirstName.get();
    }

    /**
     * @param customerFirstName the customerFirstName to set
     */
    private void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName.set(customerFirstName);
    }

    /**
     * @return the customerLastName
     */
    private String getCustomerLastName() {
        return customerLastName.get();
    }

    /**
     * @param customerLastName the customerLastName to set
     */
    private void setCustomerLastName(String customerLastName) {
        this.customerLastName.set(customerLastName);
    }

    /**
     * @return the customerState
     */
    private String getCustomerState() {
        return customerState.get();
    }

    /**
     * @param customerState the customerState to set
     */
    private void setCustomerState(String customerState) {
        this.customerState.set(customerState);
    }

    /**
     * @return the customerCity
     */
    private String getCustomerCity() {
        return customerCity.get();
    }

    /**
     * @param customerCity the customerCity to set
     */
    private void setCustomerCity(String customerCity) {
        this.customerCity.set(customerCity);
    }

    /**
     * @return the customerZip
     */
    private String getCustomerZip() {
        return customerZip.get();
    }

    /**
     * @param customerZip the customerZip to set
     */
    private void setCustomerZip(String customerZip) {
        this.customerZip.set(customerZip);
    }

    /**
     * @return the customerEmail
     */
    private String getCustomerEmail() {
        return customerEmail.get();
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    private void setCustomerEmail(String customerEmail) {
        this.customerEmail.set(customerEmail);
    }

    /**
     * @return the cutomerPhone
     */
    private String getCustomerPhone() {
        return customerPhone.get();
    }

    /**
     * @param cutomerPhone the cutomerPhone to set
     */
    private void setCustomerPhone(String customerPhone) {
        this.customerPhone.set(customerPhone);
    }

    /**
     * @return the customerAddress
     */
    private String getCustomerAddress() {
        return customerAddress.get();
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    private void setCustomerAddress(String customerAddress) {
        this.customerAddress.set(customerAddress);
    }
}

  

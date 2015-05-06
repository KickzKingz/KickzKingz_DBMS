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
    
    private SimpleStringProperty CUST_ID, Name_First, Name_Last,
            State, City, Zip, Email, Address, Phone;
    
    public Customer()
    {
        CUST_ID = new SimpleStringProperty();
        Name_First = new SimpleStringProperty();
        Name_Last = new SimpleStringProperty();
        State = new SimpleStringProperty();
        City = new SimpleStringProperty();
        Zip = new SimpleStringProperty();
        Email = new SimpleStringProperty();
        Address = new SimpleStringProperty();
        Phone = new SimpleStringProperty();
    }
   
//    public Customer(String id, String firstName, String lastName, String state, 
//            String city, String zip, String address, String email, String phone)
//    {
//        setCustomerId(id);
//        setCustomerLastName(lastName);
//        setCustomerFirstName(firstName);
//        setCustomerCity(city);
//        setCustomerPhone(phone);
//        setCustomerState(state);
//        setCustomerZip(zip);
//        setCustomerAddress(address);
//        setCustomerEmail(email);
//    }

    /**
     * @return the customerId
     */
    public String getCUST_ID() {
        return CUST_ID.get();
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCUST_ID(String customerId) {
        this.CUST_ID.set(customerId);
    }

    /**
     * @return the customerFirstName
     */
    public String getName_First() {
        return Name_First.get();
    }

    /**
     * @param customerFirstName the customerFirstName to set
     */
    public void setName_First(String customerFirstName) {
        this.Name_First.set(customerFirstName);
    }

    /**
     * @return the customerLastName
     */
    public String getName_Last() {
        return Name_Last.get();
    }

    /**
     * @param customerLastName the customerLastName to set
     */
    public void setName_Last(String customerLastName) {
        this.Name_Last.set(customerLastName);
    }

    /**
     * @return the customerState
     */
    public String getState() {
        return State.get();
    }

    /**
     * @param customerState the customerState to set
     */
    public void setState(String customerState) {
        this.State.set(customerState);
    }

    /**
     * @return the customerCity
     */
    public String getCity() {
        return City.get();
    }

    /**
     * @param customerCity the customerCity to set
     */
    public void setCity(String customerCity) {
        this.City.set(customerCity);
    }

    /**
     * @return the customerZip
     */
    public String getZip() {
        return Zip.get();
    }

    /**
     * @param customerZip the customerZip to set
     */
    public void setZip(String customerZip) {
        this.Zip.set(customerZip);
    }

    /**
     * @return the customerEmail
     */
    public String getEmail() {
        return Email.get();
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    public void setEmail(String customerEmail) {
        this.Email.set(customerEmail);
    }

    /**
     * @return the cutomerPhone
     */
    public String getPhone() {
        return Phone.get();
    }

    /**
     * @param customerPhone the cutomerPhone to set
     */
    public void setPhone(String customerPhone) {
        this.Phone.set(customerPhone);
    }

    /**
     * @return the customerAddress
     */
    public String getAddress() {
        return Address.get();
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setAddress(String customerAddress) {
        this.Address.set(customerAddress);
    }
    
    @Override
    public String toString(){
        return Name_Last.get() + ", " + Name_First.get();
    }
}

  

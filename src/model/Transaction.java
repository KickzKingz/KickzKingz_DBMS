/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kent
 */
public class Transaction {
    
    private SimpleStringProperty TRANS_ID, CUST_ID, INV_ID;
    
    private Date Date;
    
    public Transaction()
    {
        TRANS_ID = new SimpleStringProperty();
        CUST_ID = new SimpleStringProperty();
        INV_ID = new SimpleStringProperty();
    }
    
//    public Transaction(String transId, String custId, String invId, Date date)
//    {
//        setTransId(transId);
//        setCustId(custId);
//        setInvId(invId);
//        setDate(date);
//    }

    /**
     * @return the _transId
     */
    public String getTRANS_ID() {
        return TRANS_ID.get();
    }

    /**
     * @param _transId the _transId to set
     */
    public void setTRANS_ID(String _transId) {
        this.TRANS_ID.set(_transId);
    }

    /**
     * @return the _custId
     */
    public String getCUST_ID() {
        return CUST_ID.get();
    }

    /**
     * @param _custId the _custId to set
     */
    public void setCUST_ID(String _custId) {
        this.CUST_ID.set(_custId);
    }

    /**
     * @return the _invId
     */
    public String getINV_ID() {
        return INV_ID.get();
    }

    /**
     * @param _invId the _invId to set
     */
    public void setINV_ID(String _invId) {
        this.INV_ID.set(_invId);
    }

    /**
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param _date the Date to set
     */
    public void setDate(Date _date) {
        this.Date = _date;
    }
}

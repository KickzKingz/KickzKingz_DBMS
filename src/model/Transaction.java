/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Kent
 */
public class Transaction {
    
    private String _transId, _custId, _invId;
    
    private Date _date;
    
    public Transaction(String transId, String custId, String invId, Date date)
    {
        setTransId(transId);
        setCustId(custId);
        setInvId(invId);
        setDate(date);
    }

    /**
     * @return the _transId
     */
    private String getTransId() {
        return _transId;
    }

    /**
     * @param _transId the _transId to set
     */
    private void setTransId(String _transId) {
        this._transId = _transId;
    }

    /**
     * @return the _custId
     */
    private String getCustId() {
        return _custId;
    }

    /**
     * @param _custId the _custId to set
     */
    private void setCustId(String _custId) {
        this._custId = _custId;
    }

    /**
     * @return the _invId
     */
    private String getInvId() {
        return _invId;
    }

    /**
     * @param _invId the _invId to set
     */
    private void setInvId(String _invId) {
        this._invId = _invId;
    }

    /**
     * @return the _date
     */
    private Date getDate() {
        return _date;
    }

    /**
     * @param _date the _date to set
     */
    private void setDate(Date _date) {
        this._date = _date;
    }
}

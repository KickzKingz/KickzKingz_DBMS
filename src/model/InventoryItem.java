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
public class InventoryItem {
    
    private SimpleStringProperty INV_ID, Model, Colorway, Condition,
            Size, Price, Cost;
    
    public InventoryItem()
    {
        INV_ID = new SimpleStringProperty();
        Model = new SimpleStringProperty();
        Colorway = new SimpleStringProperty();
        Condition = new SimpleStringProperty();
        Size = new SimpleStringProperty();
        Price = new SimpleStringProperty();
        Cost = new SimpleStringProperty();
        
    }
    
//    public InventoryItem(String id, String model,
//            String colorway, String condition, 
//            String size, String price,
//            String cost)
//    {
//        setItemId(id);
//        setItemModel(model);
//        setItemColorway(colorway);
//        setItemCondition(condition);
//        setItemSize(size);
//        setItemPrice(price);
//        setItemCost(cost);
//    }

    /**
     * @return the INV_ID
     */
    public String getINV_ID() {
        return INV_ID.get();
    }

    /**
     * @param _invId the INV_ID to set
     */
    public void setINV_ID(String _invId) {
        this.INV_ID.set(_invId);
    }

    /**
     * @return the Model
     */
    public String getModel() {
        return Model.get();
    }

    /**
     * @param _model the Model to set
     */
    public void setModel(String _model) {
        this.Model.set(_model);
    }

    /**
     * @return the Colorway
     */
    public String getColorway() {
        return Colorway.get();
    }

    /**
     * @param _colorway the Colorway to set
     */
    public void setColorway(String _colorway) {
        this.Colorway.set(_colorway);
    }

    /**
     * @return the Condition
     */
    public String getCondition() {
        return Condition.get();
    }

    /**
     * @param _condition the Condition to set
     */
    public void setCondition(String _condition) {
        this.Condition.set(_condition);
    }

    /**
     * @return the Size
     */
    public String getSize() {
        return Size.get();
    }

    /**
     * @param _size the Size to set
     */
    public void setSize(String _size) {
        this.Size.set(_size);
    }

    /**
     * @return the Price
     */
    public String getPrice() {
        return Price.get();
    }

    /**
     * @param _price the Price to set
     */
    public void setPrice(String _price) {
        this.Price.set(_price);
    }

    /**
     * @return the Paid
     */
    public String getCost() {
        return Cost.get();
    }

    /**
     * @param _paid the Paid to set
     */
    public void setCost(String _cost) {
        this.Cost.set(_cost);
    }
    
}

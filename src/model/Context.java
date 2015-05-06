/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kent
 */
public class Context {
    private final static Context instance = new Context();
    
    public static Context getInstance(){
        return instance;
    }
    
    private InventoryItem item = new InventoryItem();
    
    public InventoryItem currentInventoryItem(){
        return item;
    }
    
    public void setCurrentInventoryItem(InventoryItem item){
        this.item = item;
    }
}

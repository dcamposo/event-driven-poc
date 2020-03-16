package br.com.zup.inventory.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "reserve")
public class Reserve {

    @Id
    private String id;

    private String customerId;
    private String orderId;
    
    private String inventoryId;

    private BigDecimal amount;

    public Reserve(){}

    public Reserve(String id, String customerId, String orderId, String inventoryId, BigDecimal amount) {
        this.id = id;
        this.customerId = customerId;
        this.orderId = orderId;
        this.inventoryId = inventoryId;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventory) {
        this.inventoryId = inventory;
    }

}

package br.com.zup.inventory.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity(name = "reserve")
public class Reserve {

    @Id
    private Integer id;

    private String customerId;

    @ManyToOne
    private Inventory inventory;

    private BigDecimal amount;

    public Reserve(){}

    public Reserve(Integer id, String customerId, BigDecimal amount) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}

package br.com.zup.payment.event;

import java.math.BigDecimal;

public class BookedEvent {

    private String reserveId;
    private String customerId;
    private String orderId;
    private BigDecimal amount;


    public BookedEvent(){}

    public BookedEvent(String reserveId, String customerId, String orderId, BigDecimal amount) {
        this.reserveId = reserveId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

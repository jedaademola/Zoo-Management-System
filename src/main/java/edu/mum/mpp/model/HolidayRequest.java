package edu.mum.mpp.model;

import java.sql.Timestamp;

public class HolidayRequest extends AbstractModel {

    private long id;
    private String description;//name of the package
    private String amount;
    private String paymentMethod;

    private Timestamp paymentDate;

    private long paidBy;

    private float discount;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(long paidBy) {
        this.paidBy = paidBy;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}

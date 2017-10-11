package edu.mum.mpp.model;

import java.time.LocalDate;

public class Hollyday extends AbstractModel
{
    private long id;
    private String name;

    private LocalDate periode;
    private double amount;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPeriode() {
        return periode;
    }

    public void setPeriode(LocalDate periode) {
        this.periode = periode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

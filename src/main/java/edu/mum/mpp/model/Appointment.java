package edu.mum.mpp.model;

public class Appointment extends AbstractModel {
    private long id;
    private long visitorId;
    private String date;
    private long numberOfVisitor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(long visitorId) {
        this.visitorId = visitorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getNumberOfVisitor() {
        return numberOfVisitor;
    }

    public void setNumberOfVisitor(long numberOfVisitor) {
        this.numberOfVisitor = numberOfVisitor;
    }
}

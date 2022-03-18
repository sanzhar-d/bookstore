package com.company;

import java.util.Date;

public class Price {

    private int id;
    private double price;
    private Date start_date;
    private Date end_date;
    private int discount_id;

    public Price(int id, double price, Date start_date, Date end_date, int discount_id) {
        this.id = id;
        this.price = price;
        this.start_date = start_date;
        this.end_date = end_date;
        this.discount_id = discount_id;
    }

    public Price() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }
}

package com.java.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Card {

    String id = "MS-0000";
    String bid, sid;
    boolean status;
    Date dateIn = Date.valueOf(LocalDate.now());
    Date dateOut;

    public Card(String id, String bid, String sid, boolean status, Date dateIn, Date dateOut) {
        this.id = id;
        this.bid = bid;
        this.sid = sid;
        this.status = status;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public Card(String id, String bid, String sid, Date dateIn, Date dateOut) {
        this.id = id;
        this.bid = bid;
        this.sid = sid;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public Card() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
}

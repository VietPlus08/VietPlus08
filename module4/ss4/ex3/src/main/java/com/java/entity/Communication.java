package com.java.entity;

public class Communication {
    int id;
    String city;
    String district;
    String ward;

    public Communication() {
    }

    public Communication(int id, String city, String district, String ward) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.ward = ward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}

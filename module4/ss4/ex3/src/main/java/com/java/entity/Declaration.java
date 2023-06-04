package com.java.entity;

import java.sql.Date;
import java.util.List;

public class Declaration {

    int id;
    String name;
    String yob;
    String gender;
    String national;
    String identityNumber;
    Vehicle vehicle;
    String reservation; // số ghế
    Date dateIn;
    Date dateOut;
    String description;
    Communication communication;
    String number;
    String email;
    List<String> symptom;

    public Declaration() {
    }

    public Declaration(int id, String name, String yob, String gender, String national, String identityNumber, Vehicle vehicle, String reservation, Date dateIn, Date dateOut, String description, Communication communication, String number, String email, List<String> symptom) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gender = gender;
        this.national = national;
        this.identityNumber = identityNumber;
        this.vehicle = vehicle;
        this.reservation = reservation;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.description = description;
        this.communication = communication;
        this.number = number;
        this.email = email;
        this.symptom = symptom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Communication getCommunication() {
        return communication;
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSymptom() {
        return symptom;
    }

    public void setSymptom(List<String> symptom) {
        this.symptom = symptom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }
}

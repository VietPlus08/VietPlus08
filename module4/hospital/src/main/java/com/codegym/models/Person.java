package com.codegym.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.sql.Date;


public class Person {
    int id;
    @NotBlank(message = "name should be not null")
    String fullName;

    @Min(1936)
    @Max(2022)
    int yearBorn;

    @NotBlank(message = "gender should be not null")
    String gender;

    @NotBlank(message = "nation should be not null")
    String nation;

    @NotEmpty(message = "passportNumber should be not null")
    String passportNumber;

    @NotBlank(message = "vehicle should be not null")
    String vehicle;

    String numberVehicle;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "dateBegin should be not null")
    String dateBegin;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "dateEnd should be not null")
    String dateEnd;

    @NotBlank(message = "city should be not null")
    String city;

    @NotBlank(message = "district should be not null")
    String district;

    @NotBlank(message = "subDistrict should be not null")
    String subDistrict;

    @NotBlank(message = "address should be not null")
    String address;

    @Pattern(regexp = "^0\\d{9}$", message = "phone not correct type")
    String phone;

    @Email(message = "email not type")
    String email;

    boolean isCovid;

    public Person() {
    }

    public Person(String fullName, int yearBorn, String gender, String nation, String passportNumber, String vehicle, String numberVehicle, String dateBegin, String dateEnd, String city, String district, String subDistrict, String address, String phone, String email, boolean isCovid) {
        this.fullName = fullName;
        this.yearBorn = yearBorn;
        this.gender = gender;
        this.nation = nation;
        this.passportNumber = passportNumber;
        this.vehicle = vehicle;
        this.numberVehicle = numberVehicle;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.isCovid = isCovid;
    }

    public Person(int id, String fullName, int yearBorn, String gender, String nation, String passportNumber, String vehicle, String numberVehicle, String dateBegin, String dateEnd, String city, String district, String subDistrict, String address, String phone, String email, boolean isCovid) {
        this.id = id;
        this.fullName = fullName;
        this.yearBorn = yearBorn;
        this.gender = gender;
        this.nation = nation;
        this.passportNumber = passportNumber;
        this.vehicle = vehicle;
        this.numberVehicle = numberVehicle;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.city = city;
        this.district = district;
        this.subDistrict = subDistrict;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.isCovid = isCovid;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
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

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCovid() {
        return isCovid;
    }

    public void setCovid(boolean covid) {
        isCovid = covid;
    }
}

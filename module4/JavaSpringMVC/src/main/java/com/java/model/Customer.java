package com.java.model;

public class Customer {
  String id;
  String name;
  String gender;
  String[] hobbits;
  String email;
  String phone;
  String marries;

  public Customer() {
  }

  public Customer(String id, String name, String gender, String[] hobbits,
      String email, String phone, String marries) {
    super();
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.hobbits = hobbits;
    this.email = email;
    this.phone = phone;
    this.marries = marries;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String[] getHobbits() {
    return hobbits;
  }

  public void setHobbits(String[] hobbits) {
    this.hobbits = hobbits;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMarries() {
    return marries;
  }

  public void setMarries(String marries) {
    this.marries = marries;
  }

}

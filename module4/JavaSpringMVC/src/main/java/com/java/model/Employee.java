package com.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhan_vien")
public class Employee {
  @Id
  String ma_nv;
  String ho_ten_nv;
  String gioi_tinh;
  String que_quan;
  Integer tuoi;

  public Employee() {
    super();
  }

  public Employee(String ma_nv, String ho_ten_nv, String gioi_tinh,
      String que_quan, Integer tuoi) {
    super();
    this.ma_nv = ma_nv;
    this.ho_ten_nv = ho_ten_nv;
    this.gioi_tinh = gioi_tinh;
    this.que_quan = que_quan;
    this.tuoi = tuoi;
  }

  public String getMa_nv() {
    return ma_nv;
  }

  public void setMa_nv(String ma_nv) {
    this.ma_nv = ma_nv;
  }

  public String getHo_ten_nv() {
    return ho_ten_nv;
  }

  public void setHo_ten_nv(String ho_ten_nv) {
    this.ho_ten_nv = ho_ten_nv;
  }

  public String getGioi_tinh() {
    return gioi_tinh;
  }

  public void setGioi_tinh(String gioi_tinh) {
    this.gioi_tinh = gioi_tinh;
  }

  public String getQue_quan() {
    return que_quan;
  }

  public void setQue_quan(String que_quan) {
    this.que_quan = que_quan;
  }

  public Integer getTuoi() {
    return tuoi;
  }

  public void setTuoi(Integer tuoi) {
    this.tuoi = tuoi;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "ma_nv='" + ma_nv + '\'' +
            ", ho_ten_nv='" + ho_ten_nv + '\'' +
            ", gioi_tinh='" + gioi_tinh + '\'' +
            ", que_quan='" + que_quan + '\'' +
            ", tuoi=" + tuoi +
            '}';
  }
}

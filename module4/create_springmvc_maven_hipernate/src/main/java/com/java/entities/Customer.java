package com.java.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "khach_hang")
public class Customer {
    @Id
    String makh;
    String tenkh;
    String soCMND;
    String gioitinh;
    Date ngaysinh;
    String diachi;
    String sodt;


}

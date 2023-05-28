package com.java.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Table(name = "nhanvien")
public class Employee {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    String manv;
    @NotBlank(message = "Not blank")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Must alphabet")
    String hotennv;
    @Length(min = 8, max = 10, message = "Length must be from 8 to 10 number")
    String soCMND;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngaysinh;
    @NotBlank(message = "Not blank")
    String diachi;
    @Length(min = 8, max = 10, message = "Length must be from 8 to 10 number")
    String sodt;

    public Employee(String manv, String hotennv, String soCMND, Date ngaysinh, String diachi, String sodt) {
        this.manv = manv;
        this.hotennv = hotennv;
        this.soCMND = soCMND;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sodt = sodt;
    }

    public Employee() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHotennv() {
        return hotennv;
    }

    public void setHotennv(String hotennv) {
        this.hotennv = hotennv;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh ;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }
}
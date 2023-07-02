package com.codegym.vn.formlogin.entity;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "infor")
public class Infor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    @NotBlank(message = "Not empty")
    String name;

    @Column(unique = true)
    String identityNumber;

    @Column
    int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobCode", referencedColumnName = "jobCode")
    Job job;

    @Column
    String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

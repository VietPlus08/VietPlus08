package com.example.demo.dao;

import com.example.demo.entity.House;
import com.example.demo.service.IPersonService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {

    @Autowired
    IPersonService service;

    private Integer id;

    private String name;

    private String address;

    private Date date;

    private Integer numPerson;

    private String personInHouse;

    public HouseDto(House house, Integer numPerson, String personInHouse){
        id = house.getId();
        name = house.getName();
        date = house.getDate();
        address = house.getAddress();
        this.numPerson = numPerson;
        this.personInHouse = personInHouse;
    }

}

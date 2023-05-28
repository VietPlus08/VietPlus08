package com.example.demo.dao;

import com.example.demo.entity.House;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HouseDao {

    private Integer id;

    private String name;

    private String address;

    private Date date;

    public HouseDao(House house) {
        id = house.getId();
        name = house.getName();
        date = house.getDate();
        address = house.getAddress();
    }

}

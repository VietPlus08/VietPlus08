package com.example.first.service;

import com.example.first.models.HouseHold;

import java.util.List;

public interface IHouseHoldService {
    HouseHold findById(String id);

    List<HouseHold> findAll();

}

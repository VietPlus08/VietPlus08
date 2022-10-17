package com.example.first.service.impl;

import com.example.first.models.HouseHold;
import com.example.first.repos.IHouseHoldRepos;
import com.example.first.service.IHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseHoldService implements IHouseHoldService {
    @Autowired
    IHouseHoldRepos houseHoldRepos;

    @Override
    public HouseHold findById(String id) {
        return houseHoldRepos.findById(id).orElse(null);
    }

    @Override
    public List<HouseHold> findAll() {
        return houseHoldRepos.findAll();
    }
}

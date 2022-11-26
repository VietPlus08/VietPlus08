package com.example.demo.services.impl;

import com.example.demo.repos.IPersonRepo;
import com.example.demo.services.IPersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices implements IPersonServices {

    @Autowired
    IPersonRepo repos;

}

package com.example.demo.Service.impl;

import com.example.demo.Repo.IGenderRepo;
import com.example.demo.Service.IGenderService;
import com.example.demo.models.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenderService implements IGenderService {

    @Autowired
    IGenderRepo genderRepo;

    @Override
    public Gender findById(Integer id) {
        return genderRepo.findById(id).orElse(null);
    }

    @Override
    public List<Gender> findAll() {
        return genderRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        genderRepo.deleteById(id);
    }

    @Override
    public void save(Gender gender) {
        genderRepo.save(gender);
    }
}

package com.example.demo.service;

import com.example.demo.dao.HouseDao;
import com.example.demo.dao.HouseDto;
import com.example.demo.entity.House;

import java.util.List;
import java.util.Optional;


public interface IHouseService {

    List<House> findAllHouse();

    List<HouseDto> findAllHouseDto();

    void hideDisplay(Integer id);

    Optional<House> findById(Integer id);

    HouseDao findByIdDao(Integer id);

    void save(HouseDao houseDao);
}

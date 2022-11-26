package com.example.demo.service.impl;

import com.example.demo.dao.HouseDao;
import com.example.demo.dao.HouseDto;
import com.example.demo.entity.House;
import com.example.demo.repo.IHouseRepo;
import com.example.demo.repo.IPersonRepo;
import com.example.demo.service.IHouseService;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class HouseService implements IHouseService {

    @Autowired
    IHouseRepo houseRepo;
    @Autowired
    IPersonService personService;

    @Override
    public List<House> findAllHouse() {
        return houseRepo.findAll();
    }

    @Override
    public List<HouseDto> findAllHouseDto() {
        List<HouseDto> list = new ArrayList<>();
        houseRepo.findAllByDisPlay().forEach(item -> {
            int number = personService.countByHouseId(item.getId());
            String personInHouse = personService.personInHouse(item.getId());
            list.add(new HouseDto(item, number, personInHouse));
        });
        return list;
    }

    @Override
    public void hideDisplay(Integer id) {
        houseRepo.hideDisplay(id);
    }

    @Override
    public Optional<House> findById(Integer id) {
        return houseRepo.findById(id);
    }

    @Override
    public HouseDao findByIdDao(Integer id) {
        Optional<House> house = findById(id);
        if (house.isPresent()) {
            return new HouseDao(house.get());
        }
        return new HouseDao();
    }

    @Override
    public void save(HouseDao houseDao) {
        if (houseDao.getId() == null) {
            houseRepo.saveHouseDto(houseDao.getName(), houseDao.getAddress(), houseDao.getDate());
        }
        houseRepo.save(new House(houseDao));
    }
}

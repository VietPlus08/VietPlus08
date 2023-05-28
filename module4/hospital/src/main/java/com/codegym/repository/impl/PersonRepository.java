package com.codegym.repository.impl;

import com.codegym.models.Person;
import com.codegym.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonRepository implements IBaseRepository<Person> {
    static List<String> listVehicle = new ArrayList<>();
    static List<String> listGender = new ArrayList<>();
    static List<String> listNation = new ArrayList<>();
    static List<String> listCity = new ArrayList<>();
    static List<String> listDistrict = new ArrayList<>();
    static List<String> listSubDistrict = new ArrayList<>();
    static Map<Integer, Person> listPerson = new HashMap<>();

    static {
        listVehicle.add("Plane");
        listVehicle.add("Boat");
        listVehicle.add("Oto");
        listVehicle.add("Other");
        listGender.add("Male");
        listGender.add("Female");
        listNation.add("Vietnam");
        listNation.add("English");
        listNation.add("Japan");
        listNation.add("Korea");
        listNation.add("India");
        listNation.add("USA");
        listNation.add("Italy");
        listCity.add("Da Nang");
        listCity.add("Vinh");
        listCity.add("Ha Noi");
        listCity.add("Sai Gon");
        listCity.add("Hue");
        listDistrict.add("Hai chau");
        listDistrict.add("Hoa Vang");
        listDistrict.add("Thach Thang");
        listDistrict.add("Nam Duong");
        listDistrict.add("Son Tra");
        listSubDistrict.add("District 1");
        listSubDistrict.add("District 2");
        listSubDistrict.add("District 3");
        listSubDistrict.add("District 4");
        listSubDistrict.add("District 5");
    }

    @Override
    public List<String> findAllVehicle() {
        return listVehicle;
    }

    @Override
    public List<String> findAllGender() {
        return listGender;
    }

    @Override
    public List<String> findAllNation() {
        return listNation;
    }

    @Override
    public List<String> findAllCity() {
        return listCity;
    }

    @Override
    public List<String> findAllDistrict() {
        return listDistrict;
    }

    @Override
    public List<String> findAllSubDistrict() {
        return listSubDistrict;
    }

    @Override
    public Map<Integer, Person> findAllPerson() {
        return listPerson;
    }

    @Override
    public Person findById(int id) {
        return listPerson.get(id);
    }

    @Override
    public void save(Person person) {
        listPerson.put((int) (Math.random() * 100000), person);
    }

    @Override
    public void update(int id, Person person) {
        listPerson.replace(id, person);
    }
}

package com.java.repo;

import com.java.entity.Vehicle;

import java.util.List;

public interface IVehicleRepo {

    List<Vehicle> findAll();
}

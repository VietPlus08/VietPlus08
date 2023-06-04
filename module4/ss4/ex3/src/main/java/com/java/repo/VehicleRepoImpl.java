package com.java.repo;

import com.java.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleRepoImpl implements IVehicleRepo{

    static List<Vehicle> list = new ArrayList<>();
    static {
        list.add(new Vehicle(1, "Airplane"));
        list.add(new Vehicle(2, "Ship"));
        list.add(new Vehicle(3, "Train"));
        list.add(new Vehicle(4, "Bus"));
        list.add(new Vehicle(5, "Bike"));
    }

    @Override
    public List<Vehicle> findAll() {
        return list;
    }
}

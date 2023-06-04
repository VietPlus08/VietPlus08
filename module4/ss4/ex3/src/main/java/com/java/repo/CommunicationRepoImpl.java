package com.java.repo;

import com.java.entity.Communication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunicationRepoImpl implements ICommunicationRepo {

    static List<Communication> list = new ArrayList<>();
    static {
        list.add(new Communication(1,"Da Nang","Hai Chau","Nam Duong"));
        list.add(new Communication(2,"Da Nang","Hai Chau","Phuoc Ninh"));
        list.add(new Communication(3,"Da Nang","Thanh Khe","Thach Gian"));
        list.add(new Communication(4,"Da Nang","Thanh Khe","Chinh Gian"));
        list.add(new Communication(5,"Da Nang","Son Tra","An Hai Tay"));
        list.add(new Communication(6,"Da Nang","Son Tra","An Hai Bac"));
        list.add(new Communication(7,"Ho Chi Minh","Quan 1","Thon 1"));
        list.add(new Communication(8,"Ho Chi Minh","Quan 1","Thon 2"));
        list.add(new Communication(9,"Ho Chi Minh","Quan 2","Thon 6"));
        list.add(new Communication(10,"Ho Chi Minh","Quan 2","Thon 7"));
    }

    @Override
    public List<Communication> findAll() {
        return list;
    }
}

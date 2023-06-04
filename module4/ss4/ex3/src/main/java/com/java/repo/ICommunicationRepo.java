package com.java.repo;

import com.java.entity.Communication;

import java.util.List;

public interface ICommunicationRepo {
    List<Communication> findAll();

}

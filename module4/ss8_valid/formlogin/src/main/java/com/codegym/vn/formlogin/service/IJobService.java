package com.codegym.vn.formlogin.service;

import com.codegym.vn.formlogin.entity.Infor;
import com.codegym.vn.formlogin.entity.Job;

import java.util.List;

public interface IJobService {

    List<Job> findAll();

    void save(Job job);
}

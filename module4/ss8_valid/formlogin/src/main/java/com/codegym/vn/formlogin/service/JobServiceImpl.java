package com.codegym.vn.formlogin.service;

import com.codegym.vn.formlogin.entity.Infor;
import com.codegym.vn.formlogin.entity.Job;
import com.codegym.vn.formlogin.repo.IJobRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements IJobService{

    final IJobRepo repo;

    public JobServiceImpl(IJobRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Job> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Job job) {
        repo.save(job);
    }
}

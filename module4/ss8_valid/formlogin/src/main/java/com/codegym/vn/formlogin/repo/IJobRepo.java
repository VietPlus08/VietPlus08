package com.codegym.vn.formlogin.repo;

import com.codegym.vn.formlogin.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepo extends JpaRepository<Job, Integer> {
}

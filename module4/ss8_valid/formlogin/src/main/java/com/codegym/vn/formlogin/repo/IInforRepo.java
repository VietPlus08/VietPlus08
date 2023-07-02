package com.codegym.vn.formlogin.repo;

import com.codegym.vn.formlogin.entity.Infor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInforRepo extends JpaRepository<Infor, Integer> {

}

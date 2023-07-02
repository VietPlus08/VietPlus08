package com.codegym.vn.formlogin.service;

import com.codegym.vn.formlogin.entity.Infor;
import com.codegym.vn.formlogin.exception.DuplicateIdentityNumberException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {

    List<Infor> findAll();

    void save(Infor infor) throws DuplicateIdentityNumberException;

    Page<Infor> findAllWithPaging(Pageable pageable);
}

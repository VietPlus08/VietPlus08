package com.codegym.vn.formlogin.service;

import com.codegym.vn.formlogin.entity.Infor;
import com.codegym.vn.formlogin.exception.DuplicateIdentityNumberException;
import com.codegym.vn.formlogin.repo.IInforRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InforServiceImpl implements IService {

    final IInforRepo repo;

    public InforServiceImpl(IInforRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Infor> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Infor infor) throws DuplicateIdentityNumberException {
        try{
            repo.save(infor);
        }catch (Exception e){
            throw new DuplicateIdentityNumberException();
        }
    }

    @Override
    public Page<Infor> findAllWithPaging(Pageable pageable) {
        return repo.findAll(pageable);
    }
}

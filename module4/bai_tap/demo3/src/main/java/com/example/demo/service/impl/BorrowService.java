package com.example.demo.service.impl;

import com.example.demo.dto.BorrowingDto;
import com.example.demo.entities.Borrow;
import com.example.demo.generator.GeneratorId;
import com.example.demo.repos.IBorrowRepo;
import com.example.demo.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowService implements IBorrowService {

    final
    IBorrowRepo repo;

    public BorrowService(IBorrowRepo repo) {
        this.repo = repo;
    }

    public void save(Borrow borrow, String bookName){
        String getIdAutoIncrement = getIdAuto();
        repo.save(getIdAutoIncrement, bookName, borrow.getStudent().getId(), borrow.getDateIn(), borrow.getDateOut());
    }

    @Override
    public void saveDto(BorrowingDto dto) {
        String getIdAutoIncrement = getIdAuto();
        repo.saveDto(getIdAutoIncrement, dto.getBookId(), dto.getStudentId(), dto.getDateIn(), dto.getDateOut());
    }

    public void returnBook(String bookId) {
        repo.returnBook(bookId);
    }

    public List<Borrow> findAll(){
        return repo.findAll();
    }

    public List<Borrow> findAllByStatus(){
        return repo.findAllByStatus();
    }

    public String getIdAuto(){
        return GeneratorId.getGeneratorId(repo.findAllId());
    }

    public List<String> findAllId() {
        return repo.findAllId();
    }

    public List<BorrowingDto> findAllBorrowing() {
        List<Borrow> borrowList = findAllByStatus();
        return borrowList
                .stream()
                .map(BorrowingDto::new)
                .collect(Collectors.toList());
    }
}

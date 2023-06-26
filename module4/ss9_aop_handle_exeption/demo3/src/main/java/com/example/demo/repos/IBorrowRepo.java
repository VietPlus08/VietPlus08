package com.example.demo.repos;

import com.example.demo.dto.BorrowingDto;
import com.example.demo.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface IBorrowRepo extends JpaRepository<Borrow, String> {

    @Modifying
    @Transactional
    @Query(value = "Call createBorrowing(?1,?2,?3,?4,?5)", nativeQuery = true)
    void save(String borrowId, String bookName, String studentId, Date dateIn, Date dateOut);

    @Modifying
    @Transactional
    @Query(value = "Call createBorrowingDto(?1,?2,?3,?4,?5)", nativeQuery = true)
    void saveDto(String borrowId, String bookId, String studentId, Date dateIn, Date dateOut);

    @Query(value = "SELECT id from borrow", nativeQuery = true)
    List<String> findAllId();

    @Query(value = "SELECT * from borrow where `status` = 1", nativeQuery = true)
    List<Borrow> findAllByStatus();

    @Modifying
    @Transactional
    @Query(value = "Call returnBook(?1)", nativeQuery = true)
    void returnBook(String bookId);

}

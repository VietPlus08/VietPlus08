package com.example.demo.Repo;

import com.example.demo.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public interface IGenderRepo extends JpaRepository<Gender,Integer> {
    // phai la Integer cho. trung voi kieu thuoc tinh cua khoa chinh cho
    Iterator<Gender> findAllByNameContaining(String name);

    @Query(value = "select * from gender where id = ?1", nativeQuery = true)
    Optional<Gender> findById(Integer id);
    // ham ni can gi viet lai :))

//    @Query(value = "delete from gender where id = ?1")
//    void deleteById(String id);



}

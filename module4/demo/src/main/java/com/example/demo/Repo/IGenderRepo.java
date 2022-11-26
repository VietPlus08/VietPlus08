package com.example.demo.Repo;

import com.example.demo.models.Gender;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Iterator;
import java.util.Optional;

public interface IGenderRepo extends JpaRepository<Gender,Integer> {
    Iterator<Gender> findAllByNameContaining(String name);

    @Query(value = "select * from gender where id = ?1", nativeQuery = true)
    Optional<Gender> findById(Integer id);

//    @Query(value = "delete from gender where id = ?1")
//    void deleteById(String id);



}

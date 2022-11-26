package com.example.demo.repo;

import com.example.demo.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface IHouseRepo extends JpaRepository<House, Integer> {

    @Query(value = "select * from house where display = 1", nativeQuery = true)
    List<House> findAllByDisPlay();

    @Modifying
    @Transactional
    @Query(value = "update house set display = 0 where id = ?1", nativeQuery = true)
    void hideDisplay(Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into house (owner_name,address,create_date) values(?1,?2,?3)", nativeQuery = true)
    void saveHouseDto(String name, String address, Date date);
}

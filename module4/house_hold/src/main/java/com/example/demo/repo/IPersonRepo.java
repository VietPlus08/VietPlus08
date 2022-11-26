package com.example.demo.repo;

import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepo extends JpaRepository<Person,Integer> {

    @Query (value = "select count(*) from person where house_id = ?1", nativeQuery = true)
    Integer countByHouseId(Integer houseId);
}

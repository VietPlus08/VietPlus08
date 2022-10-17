package com.example.first.repos;

import com.example.first.models.HouseHold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface IHouseHoldRepos extends JpaRepository<HouseHold,String> {

    Iterable<HouseHold> findAllByNameContaining(String name);

//    @Query("select h from HouseHold as h where h.address like concat('%',:name,'%') ")
    //    Iterable<HouseHold> findAllByAddressHouseHold(@Param("name") String address);

    @Query("select h from HouseHold as h where h.address like concat('%',?1,'%') ")
    Iterable<HouseHold> findAllByAddressHouseHold( String address);

    @Query(value = "select * from house_hold where date = ?1", nativeQuery = true)
    Iterable<HouseHold> findAllByDateHouseHold( Date date);
}

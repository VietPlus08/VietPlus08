package com.example.demo.entity;

import com.example.demo.dao.HouseDao;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

//@Data la gi
@Entity(name = "House")
@Table(name = "house")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "house_code", nullable = false, unique = true)
//    private String house_code;

    @Column(name = "owner_name", nullable = false)
    private String name;

    @Column(name = "create_date", nullable = false)
    private Date date;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "display", columnDefinition = "bit default 1")
    private boolean display;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
    private Set<Person> personSet;

    public House(HouseDao houseDao) {
        id = houseDao.getId();
        name = houseDao.getName();
        date = houseDao.getDate();
        address = houseDao.getAddress();
        display = true;
    }
}

package com.example.first.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "house_hold")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class HouseHold {
    @Id
    String id;

    @Column(name = "name")
            @NotBlank(message = "name not blank")
    String name;

    @Column(name="date")
    Date date;

    @Column(name = "address")
    @NotBlank(message = "address not blank")
    String address;
}

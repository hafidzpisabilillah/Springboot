package com.boniewijaya2021.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_user", schema = "sample")
public class User implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_user", nullable = false)
    private UUID idUser;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private String age;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "consumer_type", nullable = false)
    private String consumerType;

}
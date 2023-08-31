package com.boniewijaya2021.springboot.pojo;

import lombok.*;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobilPojo {
//    private UUID idUser;
    private String name;
    private String age;
    private String city;
    private String consumerType;
    private List<ItemMobil> salesItem;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemMobil implements Serializable {
//        private UUID idMobil;
        private String name;
        private List<String> models;
        private UUID idUser;

    }
}

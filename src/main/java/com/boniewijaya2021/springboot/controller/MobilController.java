package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.pojo.MobilPojo;
import com.boniewijaya2021.springboot.service.GenzGetService;
import com.boniewijaya2021.springboot.service.GenzPostService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sample")
public class MobilController {

    @Autowired
    private GenzGetService genzGetService;

    @Autowired
    private GenzPostService genzPostService;

    @GetMapping("/get/mobil")
    public ResponseEntity getDataMobil(@RequestParam UUID idUser ){
        ResponseEntity responseEntity = genzGetService.getDataMobil(idUser);
        return responseEntity;

    }

    @PostMapping("/post/mobil")
    private ResponseEntity<MessageModel> addDataMobil(@RequestBody MobilPojo mobilPojo) {
        ResponseEntity responseEntity = genzPostService.addDataMobil(mobilPojo);
        return responseEntity;
    }
}
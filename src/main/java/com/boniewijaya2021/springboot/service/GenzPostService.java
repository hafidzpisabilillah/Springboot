package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Mobil;
import com.boniewijaya2021.springboot.entity.User;
import com.boniewijaya2021.springboot.pojo.MobilPojo;
import com.boniewijaya2021.springboot.repository.MobilRepository;
import com.boniewijaya2021.springboot.repository.UsergenzRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenzPostService {

    @Autowired
    private MobilRepository mobilRepository;

    @Autowired
    private UsergenzRepository usergenzRepository;


    public ResponseEntity<MessageModel> addDataMobil(MobilPojo mobilPojo)
    {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try{
            User user = new User();
            user.setName(mobilPojo.getName());
            user.setAge(mobilPojo.getAge());
            user.setCity(mobilPojo.getCity());
            user.setConsumerType(mobilPojo.getConsumerType());
            User save = usergenzRepository.save(user);


            for (MobilPojo.ItemMobil itemMobil: mobilPojo.getSalesItem()){
                Mobil mobil = new Mobil();
                mobil.setName(itemMobil.getName());
                mobil.setModels(String.join(",",itemMobil.getModels()));
                mobil.setIdUser(save.getIdUser());
                mobilRepository.save(mobil);
            }



            msg.setStatus(true);
            msg.setMessage("Succes");
            msg.setData(mobilPojo);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
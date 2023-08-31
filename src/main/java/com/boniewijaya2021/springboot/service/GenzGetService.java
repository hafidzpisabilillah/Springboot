package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Mobil;
import com.boniewijaya2021.springboot.entity.User;
import com.boniewijaya2021.springboot.pojo.MobilPojo;
import com.boniewijaya2021.springboot.repository.MobilRepository;
import com.boniewijaya2021.springboot.repository.UsergenzRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenzGetService {

    @Autowired
    private MobilRepository mobilRepository;

    @Autowired
    private UsergenzRepository usergenzRepository;


    public ResponseEntity getDataMobil(UUID idMobil) {
//        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            User data = usergenzRepository.findById(idMobil).get();
            MobilPojo mobilPojo = new MobilPojo();
            mobilPojo.setName(data.getName());
            mobilPojo.setAge(data.getAge());
            mobilPojo.setCity(data.getCity());
            mobilPojo.setConsumerType(data.getConsumerType());

            List<Mobil> byIdUser = mobilRepository.getByIdUser(data.getIdUser());
            List<MobilPojo.ItemMobil> newList = new ArrayList<>();
            for (Mobil mobil : byIdUser) {
                MobilPojo.ItemMobil itemMobil = new MobilPojo.ItemMobil();
                itemMobil.setName(mobil.getName());
                itemMobil.setModels(Arrays.asList(mobil.getModels().split(",")));
                newList.add(itemMobil);
            }
            mobilPojo.setSalesItem(newList);



            if (data.getIdUser()==null){
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Succes");
                msg.setData(mobilPojo);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }
}
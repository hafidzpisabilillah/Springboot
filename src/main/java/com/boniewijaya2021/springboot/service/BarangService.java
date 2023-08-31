package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.repository.DataBarangRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BarangService {

    @Autowired
    private DataBarangRepository dataBarangRepository;

    public ResponseEntity<MessageModel> addDataBarang(List<Barang> paramInsertBarang) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            List<Barang> param = paramInsertBarang;
            List<Barang> objectSave = new ArrayList<>();
            String pembeliResponSave ="Tersimpan";

            for(Barang map: paramInsertBarang ) {
                Barang object1 = new Barang();
                object1.setNamaBarang(map.getNamaBarang());
                object1.setHarga(map.getHarga());
                object1.setStok(map.getStok());
                objectSave.add(object1);
            }
//            .save(Pembeli);
//            .save(Barang);
//            .save(Transaksi);
            dataBarangRepository.saveAll(objectSave);
            //dataPembeliRepository.save(pembeli);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", pembeliResponSave);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}

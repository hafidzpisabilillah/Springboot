package com.boniewijaya2021.springboot.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class SupplierPojo {
    private String namaSupplier;
    private String noTelp;
    private String alamat;

}

package com.boniewijaya2021.springboot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Pembeli1 implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_pembayaran")
    private UUID idPembayaran;

    @Column(name = "tgl_bayar")
    private Date tglBayar;

    @Column(name = "total_bayar")
    private Integer totalBayar;

    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;
}

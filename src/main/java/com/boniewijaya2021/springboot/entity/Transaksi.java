package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_transaksi", schema = "sample")
public class Transaksi implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_transaksi")
    private UUID idTransaksi;

    @Column(name = "id_barang")
    private UUID idBarang;

    @Column(name = "id_pembeli")
    private UUID idPembeli;

    @Column(name = "tanggal")
    private Date tanggal;

    @Column(name = "keterangan", length = 100)
    private String keterangan;
}

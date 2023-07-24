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

    @ManyToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @ManyToOne
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @Column(name = "tanggal")
    private Date tanggal;

    @Column(name = "keterangan", length = 100)
    private String keterangan;
}

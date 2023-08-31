package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DataTransaksiRepository extends JpaRepository<Transaksi, UUID> {
}

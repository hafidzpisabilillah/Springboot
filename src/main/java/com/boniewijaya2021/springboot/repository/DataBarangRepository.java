package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataBarangRepository extends JpaRepository<Barang, UUID> {
}

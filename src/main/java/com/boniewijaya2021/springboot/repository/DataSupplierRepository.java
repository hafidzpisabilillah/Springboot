package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataSupplierRepository extends JpaRepository<Supplier, UUID> {
}

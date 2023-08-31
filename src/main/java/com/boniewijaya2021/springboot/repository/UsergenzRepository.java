package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Mobil;
import com.boniewijaya2021.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsergenzRepository extends JpaRepository<User, UUID> {
}

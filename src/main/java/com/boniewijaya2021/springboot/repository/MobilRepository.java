package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Mobil;
import com.boniewijaya2021.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MobilRepository extends JpaRepository<Mobil, UUID> {

    List<Mobil> getByIdUser(UUID idUser);
}

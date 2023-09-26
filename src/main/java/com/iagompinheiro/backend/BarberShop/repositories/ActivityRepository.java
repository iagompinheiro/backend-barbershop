package com.iagompinheiro.backend.BarberShop.repositories;

import com.iagompinheiro.backend.BarberShop.domain.domainActivity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}

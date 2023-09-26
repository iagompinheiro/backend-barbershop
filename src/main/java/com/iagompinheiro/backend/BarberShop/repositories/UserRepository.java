package com.iagompinheiro.backend.BarberShop.repositories;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

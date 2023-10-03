package com.iagompinheiro.backend.BarberShop.dto;

import com.iagompinheiro.backend.BarberShop.domain.domainActivity.ActivityType;
import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;

import java.time.LocalDateTime;

public record ActivityDto(LocalDateTime dateTime, ActivityType activityType, User user) {
}

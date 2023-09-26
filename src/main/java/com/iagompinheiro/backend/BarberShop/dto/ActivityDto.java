package com.iagompinheiro.backend.BarberShop.dto;

import com.iagompinheiro.backend.BarberShop.domain.domainActivity.ActivityType;

import java.time.LocalDateTime;

public record ActivityDto(LocalDateTime dateTime, ActivityType activityType) {
}

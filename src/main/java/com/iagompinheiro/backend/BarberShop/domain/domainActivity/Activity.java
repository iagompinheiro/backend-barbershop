package com.iagompinheiro.backend.BarberShop.domain.domainActivity;

import com.iagompinheiro.backend.BarberShop.dto.ActivityDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_activity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    public Activity(ActivityDto activityDto) {
        this.dateTime = activityDto.dateTime();
        this.activityType = activityDto.activityType();
    }
}

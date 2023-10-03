package com.iagompinheiro.backend.BarberShop.domain.domainActivity;

import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
import com.iagompinheiro.backend.BarberShop.dto.ActivityDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_activity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private ActivityType activityType;
    private double valueType;
    @ManyToOne
    @JoinColumn
    private User user;

    public Activity(ActivityDto activityDto) {
        this.dateTime = activityDto.dateTime();
        this.activityType = activityDto.activityType();
        this.user = activityDto.user();
        }
    }


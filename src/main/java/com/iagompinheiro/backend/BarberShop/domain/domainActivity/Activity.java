package com.iagompinheiro.backend.BarberShop.domain.domainActivity;
import com.iagompinheiro.backend.BarberShop.domain.domainUser.User;
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

        switch (this.activityType) {
            case LOWFADE -> {
                this.valueType = 30.0;
                break;
            }
            case MIDFADE -> {
                this.valueType = 35.0;
                break;
            }
            case AMERICAN -> {
                this.valueType = 40.0;
                break;
            }
            case HIGHFADE -> {
                this.valueType = 25.0;
                break;
            }
        }
    }
}

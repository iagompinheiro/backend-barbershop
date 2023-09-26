package com.iagompinheiro.backend.BarberShop.domain.domainUser;

import com.iagompinheiro.backend.BarberShop.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "email")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    public User(UserDto userDto) {
        this.firstName = userDto.firstName();
        this.lastName = userDto.lastName();
        this.email = userDto.email();
    }
}

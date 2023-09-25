package com.kermes.apiecommerce.Entities;

import com.kermes.apiecommerce.DTOs.AddressResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = true)
    private LocalDateTime updated;


}

package com.kermes.apiecommerce.DTOs;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientReponseDTO {
    private Long id;
    private String email;
    private List<AddressResponseDTO> addresses;
}

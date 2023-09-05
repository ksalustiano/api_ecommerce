package com.kermes.apiecommerce.DTOs;

import com.kermes.apiecommerce.Entities.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class ClientCreateDTO {

    @NotBlank
    @Email(message = "O  formato do e-mail está inválido.", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;


}

package com.kermes.apiecommerce.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressCreateDTO {
    @Size(min=8, max = 8, message = "quantidade de caracteres inválido para o CEP, verifique...")
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String localidade;
    private String bairro;
    private String uf;
    private Long clientId;
}

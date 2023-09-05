package com.kermes.apiecommerce.Services;

import com.kermes.apiecommerce.DTOs.AddressResponseDTO;
import com.kermes.apiecommerce.DTOs.Mappers.AddressMapper;
import com.kermes.apiecommerce.Entities.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {
    private final String VIACEP_URL = "https://viacep.com.br/ws/";

    public AddressResponseDTO consultarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        Address address = restTemplate.getForObject(VIACEP_URL + cep + "/json/", Address.class);
        return AddressMapper.toDTO(address);
    }
}


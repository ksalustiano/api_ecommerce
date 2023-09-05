package com.kermes.apiecommerce.DTOs.Mappers;

import com.kermes.apiecommerce.DTOs.ClientCreateDTO;
import com.kermes.apiecommerce.DTOs.ClientReponseDTO;
import com.kermes.apiecommerce.Entities.Client;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static Client toClient(ClientCreateDTO createDto){
        return new ModelMapper().map(createDto, Client.class);
    }

    public static ClientReponseDTO toDTO (Client client){
        return new ModelMapper().map(client, ClientReponseDTO.class);
    }

    public static List<ClientReponseDTO> tolistDTO(List<Client>clients){
        return clients.stream().map(user -> toDTO(user)).collect(Collectors.toList());
    }
}

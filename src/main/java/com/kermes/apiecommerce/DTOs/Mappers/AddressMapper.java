package com.kermes.apiecommerce.DTOs.Mappers;

import com.kermes.apiecommerce.DTOs.AddressCreateDTO;
import com.kermes.apiecommerce.DTOs.AddressResponseDTO;
import com.kermes.apiecommerce.Entities.Address;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Address toAddress(AddressCreateDTO createDto){
        return modelMapper.map(createDto, Address.class);
    }

    public static AddressResponseDTO toDTO(Address addr){
        return modelMapper.map(addr, AddressResponseDTO.class);
    }

    public static List<AddressResponseDTO> toListDTO(List<Address> addresses){
        return addresses.stream()
                .map(AddressMapper::toDTO)
                .collect(Collectors.toList());
    }
}

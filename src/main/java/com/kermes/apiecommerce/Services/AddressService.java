package com.kermes.apiecommerce.Services;

import com.kermes.apiecommerce.DTOs.AddressCreateDTO;
import com.kermes.apiecommerce.DTOs.AddressResponseDTO;
import com.kermes.apiecommerce.DTOs.Mappers.AddressMapper;
import com.kermes.apiecommerce.Entities.Address;
import com.kermes.apiecommerce.Exeptions.UniqueViolationException;
import com.kermes.apiecommerce.Repositories.AddressRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    private final AddressRepository repository;

    @Transactional
    public Address criar(@Valid AddressCreateDTO addr){
        try {
            return repository.save(AddressMapper.toAddress(addr));
        }catch (DataIntegrityViolationException ex){
            throw new UniqueViolationException(ex.getMessage());
        }

    }

    public List<Address> buscarTodos() {
        return repository.findAll();

    }
}

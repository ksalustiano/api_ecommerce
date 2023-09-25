package com.kermes.apiecommerce.Controllers;

import com.kermes.apiecommerce.DTOs.AddressCreateDTO;
import com.kermes.apiecommerce.DTOs.AddressResponseDTO;
import com.kermes.apiecommerce.DTOs.Mappers.AddressMapper;
import com.kermes.apiecommerce.Entities.Address;
import com.kermes.apiecommerce.Services.AddressService;
import com.kermes.apiecommerce.Services.CepService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/address")
public class AddressController {
    private final CepService cepService;
    private final AddressService addressService;

    @GetMapping("/{cep}")
    public AddressResponseDTO findCep(@Valid @PathVariable String cep) {

        return cepService.consultarCep(cep);
    }

    @PostMapping()
    public ResponseEntity<AddressResponseDTO> criar(@Valid @RequestBody AddressCreateDTO addr) {
        Address endereco = addressService.criar(addr);
        return ResponseEntity.status(HttpStatus.CREATED).body(AddressMapper.toDTO(endereco));

    }

    @GetMapping()
    public ResponseEntity<List<AddressResponseDTO>> getAll() {
        List<Address> addresses = addressService.buscarTodos();
        return ResponseEntity.ok(AddressMapper.toListDTO(addresses));
    }
}

package com.kermes.apiecommerce.Controllers;

import com.kermes.apiecommerce.DTOs.ClientCreateDTO;
import com.kermes.apiecommerce.DTOs.ClientReponseDTO;
import com.kermes.apiecommerce.DTOs.Mappers.ClientMapper;
import com.kermes.apiecommerce.Entities.Client;
import com.kermes.apiecommerce.Services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;


    @PostMapping()
    public ResponseEntity<ClientReponseDTO> criar(@Valid @RequestBody ClientCreateDTO cli) {
        Client user = clientService.criar(cli);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClientMapper.toDTO(user));

    }

    @GetMapping("/{email}")
    public ResponseEntity<ClientReponseDTO> getbyEmail(@PathVariable String email) {
        Client client = clientService.buscarPorEmail(email);
        return ResponseEntity.ok(ClientMapper.toDTO(client));
    }

    @GetMapping()
    public ResponseEntity<List<ClientReponseDTO>> getAll() {
        List<Client> clients = clientService.buscarTodos();
        return ResponseEntity.ok(ClientMapper.tolistDTO(clients));
    }
}

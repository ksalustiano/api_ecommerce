package com.kermes.apiecommerce.Services;

import com.kermes.apiecommerce.DTOs.ClientCreateDTO;
import com.kermes.apiecommerce.DTOs.ClientReponseDTO;
import com.kermes.apiecommerce.DTOs.Mappers.ClientMapper;
import com.kermes.apiecommerce.Entities.Client;
import com.kermes.apiecommerce.Exeptions.UniqueViolationException;
import com.kermes.apiecommerce.Repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client findById(Long id) throws Exception {
        return this.clientRepository.findClientById(id).orElseThrow(() -> new Exception("CLiente não localizado"));
    }



    @Transactional
    public Client criar(ClientCreateDTO c){
        try {
            return clientRepository.save(ClientMapper.toClient(c));
        }catch (DataIntegrityViolationException ex){
            throw new UniqueViolationException(String.format("Email: %s já cadastrao na base de dados!", c.getEmail()));
        }

    }

    @Transactional(readOnly = true)
    public List<Client> buscarTodos() {
        return clientRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Client buscarPorId(Long id) {
        return  clientRepository.findById(id).orElseThrow(
                ()->new RuntimeException("CLiente não localizado")
        );
    }

    @Transactional(readOnly = true)
    public Client buscarPorEmail(String email) {
        return clientRepository.findClientByEmail(email).orElseThrow(
                ()->new RuntimeException("CLiente não localizado")
        );
    }
}

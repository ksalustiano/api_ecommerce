package com.kermes.apiecommerce.Repositories;

import com.kermes.apiecommerce.DTOs.ClientReponseDTO;
import com.kermes.apiecommerce.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, Long> {

    public Optional<Client> findClientByEmail(String email);

    public Optional<Client> findClientById(long id);


}

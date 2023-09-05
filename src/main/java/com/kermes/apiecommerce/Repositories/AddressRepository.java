package com.kermes.apiecommerce.Repositories;

import com.kermes.apiecommerce.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

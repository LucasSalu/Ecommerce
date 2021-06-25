package com.salu.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salu.ecommerce.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer >{


}

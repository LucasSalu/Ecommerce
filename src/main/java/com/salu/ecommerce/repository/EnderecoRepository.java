package com.salu.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salu.ecommerce.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer >{


}

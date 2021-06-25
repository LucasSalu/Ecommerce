package com.salu.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salu.ecommerce.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer >{


}

package com.salu.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salu.ecommerce.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer >{


}

package com.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.domain.entity.Cliente;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);
    
}
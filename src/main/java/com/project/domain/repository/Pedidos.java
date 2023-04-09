package com.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.domain.entity.Cliente;
import com.project.domain.entity.Pedido;

import java.util.List;
import java.util.Set;


public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}

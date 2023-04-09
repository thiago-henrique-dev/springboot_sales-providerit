package com.project.service.impl;


import org.springframework.stereotype.Service;
import com.project.domain.repository.Pedidos;
import com.project.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
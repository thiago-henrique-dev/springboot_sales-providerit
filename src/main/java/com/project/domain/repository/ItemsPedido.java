package com.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.domain.entity.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
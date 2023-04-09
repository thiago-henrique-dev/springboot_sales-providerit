package com.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.domain.entity.Produto;

public interface Produtos extends JpaRepository<Produto,Integer> {
}
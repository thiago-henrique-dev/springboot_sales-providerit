package com.project.domain.entity;

import java.time.LocalDate;
import java.math.BigDecimal;

public class Pedido {
    private Integer id;
    private Cliente cliente;
    private LocalDate data;
    private BigDecimal total;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        return total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}

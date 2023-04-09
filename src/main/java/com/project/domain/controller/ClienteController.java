package com.project.domain.controller;

import com.project.domain.entity.Cliente;
import com.project.domain.repository.Clientes;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {

  private Clientes clientes;

  public ClienteController(Clientes clientes) {
    this.clientes = clientes;
  }

  @GetMapping("/api/clientes/{id}")
  @ResponseBody
  public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
    Optional<Cliente> cliente = clientes.findById(id);

    if (cliente.isPresent()) {
      return ResponseEntity.ok(cliente.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping("/api/clientes")
  @ResponseBody
  public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
    Cliente clienteSalvo = clientes.save(cliente);
    return ResponseEntity.ok(clienteSalvo);
  }

  @GetMapping("/api/clientes")
  @ResponseBody
  public ResponseEntity<List<Cliente>> getTodosClientes() {
    List<Cliente> clientes = this.clientes.findAll();

    if (clientes.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(clientes);
  }

  @DeleteMapping("/api/clientes/{id}")
  @ResponseBody
  public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
    Optional<Cliente> cliente = this.clientes.findById(id);

    if (cliente.isPresent()) {
      clientes.delete(cliente.get());
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
  }
}

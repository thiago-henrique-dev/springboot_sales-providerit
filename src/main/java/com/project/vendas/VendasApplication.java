package com.project.vendas;

import com.project.domain.entity.Cliente;
import com.project.domain.entity.Pedido;
import com.project.domain.repository.Clientes;
import com.project.domain.repository.Pedidos;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.project.domain.repository")
@EntityScan("com.project.domain.entity")
@ComponentScan("com.project.domain")

public class VendasApplication {

  @Bean
  public CommandLineRunner init(
    @Autowired Clientes clientes,
    @Autowired Pedidos pedidos
  ) {
    return args -> {
      System.out.println("Salvando clientes");
      Cliente fulano = new Cliente("Fulano");
      clientes.save(fulano);

      Pedido p = new Pedido();
      p.setCliente(fulano);
      p.setDataPedido(LocalDate.now());
      p.setTotal(BigDecimal.valueOf(100));

      pedidos.save(p);
    
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(VendasApplication.class, args);
    System.out.println("Hello");
  }
}

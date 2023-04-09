package com.project.vendas;

import com.project.domain.entity.Cliente;
import com.project.domain.repository.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories("com.project.domain.repository")
@EntityScan("com.project.domain.entity")
@ComponentScan("com.project.domain")
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			System.out.println("Salvando clientes");
            clientes.save(new Cliente("Thiago"));
            clientes.save(new Cliente("Outro Cliente"));

			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Salvando clientes!");
			todosClientes.forEach(e -> {
				e.setNome(e.getNome() + " atualizado.");
				clientes.save(e);
			});

			System.out.println("Buscando clientes!");
			clientes.findByNomeLike("Cli").forEach(System.out::println);
			

			System.out.println("deletando clientes");
			clientes.findAll().forEach(c -> {
				clientes.delete(c);
			});

			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);
			if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado.");
            }else{
                todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
		System.out.println("Hello");
	}

}

package com.project.vendas;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class MinhaConfiguration {
    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }
}

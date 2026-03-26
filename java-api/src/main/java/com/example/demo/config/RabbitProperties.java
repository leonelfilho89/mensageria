package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitProperties {

    @Value("${app.rabbit.fila-envio}")
    private String filaEnvio;

    @Value("${app.rabbit.fila-retorno}")
    private String filaRetorno;

    public String getFilaEnvio() {
        return filaEnvio;
    }

    public String getFilaRetorno() {
        return filaRetorno;
    }
}
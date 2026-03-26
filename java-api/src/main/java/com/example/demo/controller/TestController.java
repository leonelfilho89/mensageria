package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.config.RabbitProperties;
import com.example.demo.dto.PedidoDTO;

@RestController
@RequestMapping("/pedido")
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitProperties props;

	@PostMapping
    public String enviarPedido(@RequestBody PedidoDTO pedido) {

        rabbitTemplate.convertAndSend(
            props.getFilaEnvio(),
            pedido
        );

        return "Pedido enviado: " + pedido.getPedidoId();
    }
}
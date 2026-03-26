package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.demo.dto.PedidoDTO;

@Component
public class RetornoConsumer {

    @RabbitListener(queues = "${app.rabbit.fila-retorno}")
    public void receber(PedidoDTO pedido) {
        System.out.println(
            "Callback: pedidoId=" + pedido.getPedidoId() +
            ", status=" + pedido.getStatus()
        );
    }
}
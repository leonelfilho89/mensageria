package com.example.demo.dto;

public class PedidoDTO {

    private Long pedidoId;
    private String status;

    public PedidoDTO() {
    }

    public PedidoDTO(Long pedidoId, String status) {
        this.pedidoId = pedidoId;
        this.status = status;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
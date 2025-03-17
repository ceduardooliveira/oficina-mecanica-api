package com.oficinamecanica.dto;

import java.util.List;

public class OrdemServicoRequest {
    private Long veiculoId;
    private List<Long> servicosIds;
    private Long mecanicoId;

    // Getters e Setters
    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public List<Long> getServicosIds() {
        return servicosIds;
    }

    public void setServicosIds(List<Long> servicosIds) {
        this.servicosIds = servicosIds;
    }

    public Long getMecanicoId() {
        return mecanicoId;
    }

    public void setMecanicoId(Long mecanicoId) {
        this.mecanicoId = mecanicoId;
    }
}
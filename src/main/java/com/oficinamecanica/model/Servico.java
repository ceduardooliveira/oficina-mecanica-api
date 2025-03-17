package com.oficinamecanica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal valor;

    @ManyToMany(mappedBy = "servicos") // Relacionamento ManyToMany com OrdemServico
    private List<OrdemServico> ordensServico; // Lista de ordens de serviço associadas a este serviço

    @ManyToOne
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico; // Mecânico responsável pelo serviço
}
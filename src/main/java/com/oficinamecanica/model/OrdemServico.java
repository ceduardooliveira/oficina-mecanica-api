package com.oficinamecanica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String status;
    private double valorTotal; // Novo campo para o valor total da ordem de serviço

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToMany
    @JoinTable(
            name = "ordem_servico_servico", // Nome da tabela de relacionamento
            joinColumns = @JoinColumn(name = "ordem_servico_id"), // Coluna da ordem de serviço
            inverseJoinColumns = @JoinColumn(name = "servico_id") // Coluna do serviço
    )
    private List<Servico> servicos; // Lista de serviços associados à ordem de serviço

    @ManyToOne
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico; // Mecânico responsável pela ordem de serviço
}
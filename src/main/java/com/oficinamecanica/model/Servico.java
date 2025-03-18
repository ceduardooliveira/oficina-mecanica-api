package com.oficinamecanica.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonBackReference // Evita serialização cíclica com OrdemServico
    @ManyToMany(mappedBy = "servicos")
    private List<OrdemServico> ordensServico;

    @JsonIgnoreProperties("servicos") // Evita serialização cíclica com Mecanico
    @ManyToOne
    @JoinColumn(name = "mecanico_id")
    private Mecanico mecanico;

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
package com.oficinamecanica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Mecanico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;

    @JsonIgnore // Evita que a lista de serviços seja serializada
    @OneToMany(mappedBy = "mecanico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servico> servicos;

    @Override
    public String toString() {
        return "Mecanico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
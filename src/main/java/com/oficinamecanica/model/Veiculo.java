package com.oficinamecanica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String placa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
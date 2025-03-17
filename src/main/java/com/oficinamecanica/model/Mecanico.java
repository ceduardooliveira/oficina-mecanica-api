package com.oficinamecanica.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mecanico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
}
package com.oficinamecanica.repository;

import com.oficinamecanica.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}
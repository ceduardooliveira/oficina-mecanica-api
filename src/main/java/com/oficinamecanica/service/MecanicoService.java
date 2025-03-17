package com.oficinamecanica.service;

import com.oficinamecanica.model.Mecanico;
import com.oficinamecanica.repository.MecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    public List<Mecanico> findAll() {
        return mecanicoRepository.findAll();
    }

    public Mecanico findById(Long id) {
        return mecanicoRepository.findById(id).orElse(null);
    }

    public Mecanico save(Mecanico mecanico) {
        return mecanicoRepository.save(mecanico);
    }

    public void deleteById(Long id) {
        mecanicoRepository.deleteById(id);
    }
}
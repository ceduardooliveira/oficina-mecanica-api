package com.oficinamecanica.service;

import com.oficinamecanica.model.OrdemServico;
import com.oficinamecanica.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    public OrdemServico findById(Long id) {
        return ordemServicoRepository.findById(id).orElse(null);
    }

    public OrdemServico save(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    public void deleteById(Long id) {
        ordemServicoRepository.deleteById(id);
    }
}
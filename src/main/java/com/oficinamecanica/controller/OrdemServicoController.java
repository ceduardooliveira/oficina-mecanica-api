package com.oficinamecanica.controller;

import com.oficinamecanica.model.OrdemServico;
import com.oficinamecanica.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping
    public List<OrdemServico> findAll() {
        return ordemServicoService.findAll();
    }

    @GetMapping("/{id}")
    public OrdemServico findById(@PathVariable Long id) {
        return ordemServicoService.findById(id);
    }

    @PostMapping
    public OrdemServico save(@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.save(ordemServico);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ordemServicoService.deleteById(id);
    }
}
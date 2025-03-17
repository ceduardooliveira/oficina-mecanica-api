package com.oficinamecanica.controller;

import com.oficinamecanica.model.Servico;
import com.oficinamecanica.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> findAll() {
        return servicoService.findAll();
    }

    @GetMapping("/{id}")
    public Servico findById(@PathVariable Long id) {
        return servicoService.findById(id);
    }

    @PostMapping
    public Servico save(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        servicoService.deleteById(id);
    }
}
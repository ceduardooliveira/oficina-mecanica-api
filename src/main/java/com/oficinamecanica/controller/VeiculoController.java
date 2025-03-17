package com.oficinamecanica.controller;

import com.oficinamecanica.model.Veiculo;
import com.oficinamecanica.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> findAll() {
        return veiculoService.findAll();
    }

    @GetMapping("/{id}")
    public Veiculo findById(@PathVariable Long id) {
        return veiculoService.findById(id);
    }

    @PostMapping
    public Veiculo save(@RequestBody Veiculo veiculo) {
        return veiculoService.save(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        veiculoService.deleteById(id);
    }
}
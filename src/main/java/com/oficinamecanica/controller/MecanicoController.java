package com.oficinamecanica.controller;

import com.oficinamecanica.model.Mecanico;
import com.oficinamecanica.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mecanicos")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping
    public List<Mecanico> findAll() {
        return mecanicoService.findAll();
    }

    @GetMapping("/{id}")
    public Mecanico findById(@PathVariable Long id) {
        return mecanicoService.findById(id);
    }

    @PostMapping
    public Mecanico save(@RequestBody Mecanico mecanico) {
        return mecanicoService.save(mecanico);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        mecanicoService.deleteById(id);
    }
}
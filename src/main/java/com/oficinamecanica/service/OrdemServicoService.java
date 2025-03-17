package com.oficinamecanica.service;

import com.oficinamecanica.dto.OrdemServicoRequest;
import com.oficinamecanica.model.*;
import com.oficinamecanica.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private MecanicoRepository mecanicoRepository;

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

    // Novo método para emitir uma ordem de serviço
    public OrdemServico emitirOrdemServico(OrdemServicoRequest request) {
        // Busca o veículo
        Veiculo veiculo = veiculoRepository.findById(request.getVeiculoId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        // Busca os serviços
        List<Servico> servicos = servicoRepository.findAllById(request.getServicosIds());
        if (servicos.isEmpty()) {
            throw new RuntimeException("Nenhum serviço encontrado");
        }

        // Busca o mecânico
        Mecanico mecanico = mecanicoRepository.findById(request.getMecanicoId())
                .orElseThrow(() -> new RuntimeException("Mecânico não encontrado"));

        // Cria a ordem de serviço
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setVeiculo(veiculo);
        ordemServico.setServicos(servicos); // Associa os serviços à ordem de serviço
        ordemServico.setMecanico(mecanico); // Associa o mecânico à ordem de serviço
        ordemServico.setData(new Date());
        ordemServico.setStatus("EMITIDA");

        // Calcula o valor total
        double valorTotal = servicos.stream()
                .mapToDouble(servico -> servico.getValor().doubleValue()) // Converte BigDecimal para double
                .sum();
        ordemServico.setValorTotal(valorTotal);

        // Salva a ordem de serviço
        return ordemServicoRepository.save(ordemServico);
    }
}
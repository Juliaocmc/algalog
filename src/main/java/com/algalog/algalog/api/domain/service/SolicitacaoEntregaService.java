package com.algalog.algalog.api.domain.service;

import java.time.LocalDateTime;

import com.algalog.algalog.api.domain.exception.NegocioException;
import com.algalog.algalog.api.domain.model.Cliente;
import com.algalog.algalog.api.domain.model.Entrega;
import com.algalog.algalog.api.domain.model.StatusEntrega;
import com.algalog.algalog.api.domain.repository.ClienteRepository;
import com.algalog.algalog.api.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
    
    private CatalagoClienteService catalagoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalagoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDETE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }

}

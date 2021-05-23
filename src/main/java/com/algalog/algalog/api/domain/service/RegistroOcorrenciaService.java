package com.algalog.algalog.api.domain.service;

import com.algalog.algalog.api.domain.exception.NegocioException;
import com.algalog.algalog.api.domain.model.Entrega;
import com.algalog.algalog.api.domain.model.Ocorrencia;
import com.algalog.algalog.api.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        
        return entrega.adicionarOcorrencia(descricao);
    }
}

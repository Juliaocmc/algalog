package com.algalog.algalog.api.domain.service;

import com.algalog.algalog.api.domain.exception.EntidadeNaoEncontradaException;
import com.algalog.algalog.api.domain.exception.NegocioException;
import com.algalog.algalog.api.domain.model.Entrega;
import com.algalog.algalog.api.domain.repository.EntregaRepository;
import com.algalog.algalog.api.model.EntregaModel;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

        public Entrega buscar(Long entregaId){
          return entregaRepository.findById(entregaId)
        .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
        }
}

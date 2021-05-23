package com.algalog.algalog.api.domain.service;

import com.algalog.algalog.api.domain.model.Entrega;
import com.algalog.algalog.api.domain.model.StatusEntrega;
import com.algalog.algalog.api.domain.repository.EntregaRepository;

import org.graalvm.compiler.lir.ssa.SSAUtil.PhiValueVisitor;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public   class FinalizacaoEntregaService {

        private EntregaRepository entregaRepository;
        private BuscaEntregaService buscaEntregaService;

        public void finalizar(Long entregaId){
            Entrega entrega = buscaEntregaService.buscar(entregaId);               
            entrega.finalizar();
            entregaRepository.save(entrega);
        }
}

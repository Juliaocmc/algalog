package com.algalog.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.algalog.algalog.api.assembler.OcorrenciaAssemble;
import com.algalog.algalog.api.domain.model.Entrega;
import com.algalog.algalog.api.domain.model.Ocorrencia;
import com.algalog.algalog.api.domain.service.BuscaEntregaService;
import com.algalog.algalog.api.domain.service.RegistroOcorrenciaService;
import com.algalog.algalog.api.model.OcorrenciaModel;
import com.algalog.algalog.api.model.input.OcorrenciaInput;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entrega/{entregaId}/ocorrencias")
public class OcorrenciaController {
    
    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;

    private OcorrenciaAssemble ocorrenciaAssemble;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
            @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
                Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());

                return ocorrenciaAssemble.toModel(ocorrenciaRegistrada);

    }

    @GetMapping
    public List<OcorrenciaModel> list(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaAssemble.toCollectionModel(entrega.getOcorrencias());
    }



}

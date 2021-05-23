package com.algalog.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.algalog.algalog.api.domain.model.Ocorrencia;
import com.algalog.algalog.api.model.OcorrenciaModel;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssemble {
    
    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }

    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
    } 
}

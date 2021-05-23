package com.algalog.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.algalog.algalog.api.domain.model.Entrega;
import com.algalog.algalog.api.model.EntregaModel;
import com.algalog.algalog.api.model.input.EntregaInput;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {
    
    private ModelMapper modelMapper;
    
    public EntregaModel toModel(Entrega entrega){
    return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }
}

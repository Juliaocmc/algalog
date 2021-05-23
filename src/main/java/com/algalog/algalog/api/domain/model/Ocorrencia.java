package com.algalog.algalog.api.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ocorrencia {

    @Id
    @GeneratedValue(generator = "uuid")
    @EqualsAndHashCode.Include 
    private Long id;
    
    @ManyToOne
    private Entrega entrega;

    private String descricao;
    
    private OffsetDateTime dataRegistro;
    
}

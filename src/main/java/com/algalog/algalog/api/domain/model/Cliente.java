package com.algalog.algalog.api.domain.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
//teste
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "uuid")
    private Long id;

    @NotBlank
    @Size(max=60)
    private String nome;
    
    @NotBlank
    @Email
    @Size(max=255)
    private String email;
    
    @NotBlank
    @Size(max = 20)
    private String telefone;
          
}

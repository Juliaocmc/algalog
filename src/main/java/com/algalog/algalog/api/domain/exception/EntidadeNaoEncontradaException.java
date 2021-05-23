package com.algalog.algalog.api.domain.exception;

import javassist.SerialVersionUID;

public class EntidadeNaoEncontradaException extends NegocioException{
    
    private static final long SerialVersionUID  = 1L;

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
    
}

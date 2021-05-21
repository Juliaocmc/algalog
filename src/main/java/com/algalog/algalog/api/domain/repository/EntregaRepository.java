package com.algalog.algalog.api.domain.repository;

import com.algalog.algalog.api.domain.model.Entrega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{
    
}

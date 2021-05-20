package com.algalog.algalog.api.domain.repository;






import java.util.List;

import com.algalog.algalog.api.domain.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
}

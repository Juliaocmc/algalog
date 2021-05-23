package com.algalog.algalog.api.controller;

import java.util.List;


import com.algalog.algalog.api.domain.model.Cliente;
import com.algalog.algalog.api.domain.repository.ClienteRepository;
import com.algalog.algalog.api.domain.service.CatalagoClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientController {
    
    private ClienteRepository clienteRepository;
    private CatalagoClienteService catalagoClienteService;
    
    @GetMapping
    public List<Cliente> lista(){
        return clienteRepository.findAll();
            }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId)
        .map(cliente -> ResponseEntity.ok(cliente) )
        .orElse(ResponseEntity.notFound().build());
    }
   
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Validated @RequestBody Cliente cliente){
        return catalagoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable  Long clienteId, 
    @Validated @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = catalagoClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> delete(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        catalagoClienteService.exclui(clienteId);
        
        return ResponseEntity.noContent().build();

    }
}

package com.avaliacao.azship.aplicacao.adaptadores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.azship.dominio.Frete;
import com.avaliacao.azship.dominio.dtos.FreteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.FreteServicePort;

@RestController
@RequestMapping("api/frete")
public class FreteController {

    private FreteServicePort freteServicePort;

    @Autowired
    public void FreteServicePort(FreteServicePort freteServicePort) {
        this.freteServicePort = freteServicePort;
    }
	
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getFreteById(@PathVariable Long id) {
    	try {
    	    Frete frete = this.freteServicePort.findById(id);
    	    return ResponseEntity.status(HttpStatus.OK).body(frete);
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @GetMapping
    public Page<Frete> getAllfrete(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
    	
        return this.freteServicePort.findAllBySearch(search, page, size);
    }
    
    @PostMapping
    ResponseEntity<Object> saveFrete(@RequestBody FreteDTO freteDTO) {
    	try {
    		if(freteDTO.getOrigem() == null || freteDTO.getOrigem().isEmpty()) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Favor preencher Origem corretamente!");
    		}
    		
    		if(freteDTO.getDestino() == null || freteDTO.getDestino().isEmpty()) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Favor preencher Destino corretamente!");
    		}
    		
    		this.freteServicePort.saveFrete(freteDTO);
    		
    	    return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  deleteFrete(@PathVariable Long id) {
    	try {
    	    this.freteServicePort.deleteById(id);
    	    return ResponseEntity.status(HttpStatus.OK).body("Frete deletado com sucesso!");
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
}

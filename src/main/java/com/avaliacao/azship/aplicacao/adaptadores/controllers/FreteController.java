package com.avaliacao.azship.aplicacao.adaptadores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
    @GetMapping
    public ResponseEntity<Object> getAllfrete() {
    	try {
    	    List<Frete> freteList = this.freteServicePort.findAll();
    	    return ResponseEntity.status(HttpStatus.OK).body(freteList);
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
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
    public ResponseEntity<Object>  deleteBeneficiario(@PathVariable Long id) {
    	try {
    	    this.freteServicePort.deleteById(id);
    	    return ResponseEntity.status(HttpStatus.OK).body("Frete deletado com sucesso!");
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @PutMapping("/{id}")
    ResponseEntity<Object> updateFrete(@PathVariable Long id, @RequestBody FreteDTO freteDTO) {
        try {
            Frete frete = freteServicePort.findById(id);
            if (frete  == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Frete não encontrado com id: " + id);
            }
 
            System.out.println(id);
            freteServicePort.saveFrete(freteDTO);

            return ResponseEntity.status(HttpStatus.OK).body("Frete atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

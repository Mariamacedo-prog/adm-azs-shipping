package com.avaliacao.azship.aplicacao.adaptadores.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.dtos.AtributoClienteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.AtributoClienteServicePort;


@RestController
@RequestMapping("api/atributo")
public class AtributoClienteController {

	private AtributoClienteServicePort atributoClienteServicePort;

    @Autowired
    public AtributoClienteController(AtributoClienteServicePort atributoClienteServicePort) {
        this.atributoClienteServicePort = atributoClienteServicePort;
    }
	
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAtributoById(@PathVariable Long id) {
    	try {
    		AtributoCliente atributo = this.atributoClienteServicePort.findById(id);
    	    return ResponseEntity.status(HttpStatus.OK).body(atributo);
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
//    @GetMapping("/cliente/{clienteId}")
//    public ResponseEntity<Object> getAtributoByClienteId(@PathVariable Long clienteId) {
//    	try {
//    		List<AtributoCliente> atributo = this.atributoClienteServicePort.findByClienteId(clienteId);
//    	    return ResponseEntity.status(HttpStatus.OK).body(atributo);
//    	} catch (Exception e) {
//    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    	}
//    }
    
    @PostMapping
    ResponseEntity<Object> saveCliente(@RequestBody AtributoClienteDTO atributoDTO) {
    	try {
    		if(atributoDTO.getNome() == null || atributoDTO.getNome().isEmpty()) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Favor preencher Nome corretamente!");
    		}
    		
    		if(atributoDTO.getValor() == null || atributoDTO.getValor().isEmpty()) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Favor preencher Valor corretamente!");
    		}

    		this.atributoClienteServicePort.save(atributoDTO);
    		
    	    return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  deleteAtributo(@PathVariable Long id) {
    	try {
    	    this.atributoClienteServicePort.deleteById(id);
    	    return ResponseEntity.status(HttpStatus.OK).body("Atributo deletado com sucesso!");
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
}
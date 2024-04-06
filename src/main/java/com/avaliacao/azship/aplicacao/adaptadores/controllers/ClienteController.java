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

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.dtos.ClienteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.ClienteServicePort;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

	private ClienteServicePort clienteServicePort;

    @Autowired
    public void ClienteServicePort(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }
	
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable Long id) {
    	try {
    	    Cliente cliente = this.clienteServicePort.findById(id);
    	    return ResponseEntity.status(HttpStatus.OK).body(cliente);
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @GetMapping
    public Page<Cliente> getAllCliente(
        @RequestParam(required = false) String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
	
        	return this.clienteServicePort.findAllBySearch(search, page, size);
    }
    
    @PostMapping
    ResponseEntity<Object> saveCliente(@RequestBody ClienteDTO clienteDTO) {
    	try {
    		if(clienteDTO.getNome() == null || clienteDTO.getNome().isEmpty()) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Favor preencher Nome corretamente!");
    		}
    		
    		this.clienteServicePort.save(clienteDTO);
    		
    	    return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  deleteBeneficiario(@PathVariable Long id) {
    	try {
    	    this.clienteServicePort.deleteById(id);
    	    return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    	} catch (Exception e) {
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
}

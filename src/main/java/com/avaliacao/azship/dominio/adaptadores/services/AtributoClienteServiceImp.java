package com.avaliacao.azship.dominio.adaptadores.services;

import java.util.List;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.dtos.AtributoClienteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.AtributoClienteServicePort;
import com.avaliacao.azship.dominio.portas.repositories.AtributoClienteRepositoryPort;


public class AtributoClienteServiceImp implements AtributoClienteServicePort {
	private final AtributoClienteRepositoryPort atributoRepository;
	  
    public AtributoClienteServiceImp(AtributoClienteRepositoryPort atributoRepository) {
        this.atributoRepository = atributoRepository;
    }

	@Override
	public void save(AtributoClienteDTO atributoclienteDTO) {
		AtributoCliente cliente = new AtributoCliente();
		    
	    this.atributoRepository.save(cliente);
	}

	@Override
	public List<AtributoCliente> findAll() {
	 	List<AtributoCliente> cliente = this.atributoRepository.findAll();
	 	 
	    return cliente;
	}

	@Override
	public AtributoCliente findById(Long id) {
		return this.atributoRepository.findById(id); 
	}

	@Override
	public void deleteById(Long id) {
		this.atributoRepository.deleteById(id);  
	}

	@Override
	public List<AtributoCliente> findByClienteId(Long clienteId) {
		return this.atributoRepository.findByClienteId(clienteId); 
	}

}

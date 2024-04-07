package com.avaliacao.azship.dominio.adaptadores.services;

import java.util.List;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.dtos.AtributoClienteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.AtributoClienteServicePort;
import com.avaliacao.azship.dominio.portas.repositories.AtributoClienteRepositoryPort;

import jakarta.transaction.Transactional;


@Transactional
public class AtributoClienteServiceImp implements AtributoClienteServicePort {
	private final AtributoClienteRepositoryPort atributoClienteRepository;
	  
    public AtributoClienteServiceImp(AtributoClienteRepositoryPort atributoClienteRepository) {
        this.atributoClienteRepository = atributoClienteRepository;
    }

	@Override
	public void save(AtributoClienteDTO atributoclienteDTO) {
		AtributoCliente cliente = new AtributoCliente(atributoclienteDTO);

	    this.atributoClienteRepository.save(cliente);
	}

	@Override
	public AtributoCliente findById(Long id) {
		return this.atributoClienteRepository.findById(id); 
	}

    @Override
    public void deleteById(Long id) {
    	this.atributoClienteRepository.deleteById(id);                                                                               
    }
    
	@Override
	public List<AtributoCliente> findByClienteId(Long clienteId) {
		return this.atributoClienteRepository.findByClienteId(clienteId); 
	}

}

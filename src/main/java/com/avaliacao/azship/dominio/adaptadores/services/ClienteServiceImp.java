package com.avaliacao.azship.dominio.adaptadores.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.dtos.ClienteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.ClienteServicePort;
import com.avaliacao.azship.dominio.portas.repositories.ClienteRepositroyPort;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

import jakarta.transaction.Transactional;

@Transactional
public class ClienteServiceImp  implements ClienteServicePort {
	private final ClienteRepositroyPort clienteRepository;
	  
    public ClienteServiceImp(ClienteRepositroyPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

	@Override
	public void save(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO);
		    
	    this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
	 	List<Cliente> cliente = this.clienteRepository.findAll();
	 	 
	    return cliente;
	}

	@Override
	public Cliente findById(Long id) {
		return this.clienteRepository.findById(id); 
	}

	@Override
	public void deleteById(Long id) {
		this.clienteRepository.deleteById(id);  
	}

	@Override
	public Page<Cliente> findAllBySearch(String search, int page, int size) {
	     Pageable pageable = PageRequest.of(page, size);
	      
        return clienteRepository.findAllBySearch(pageable, search)
                .map(ClienteEntity::toCliente);
	}

}

package com.avaliacao.azship.dominio.portas.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.dtos.ClienteDTO;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

public interface ClienteServicePort {
	void save(ClienteDTO cliente);

	List<Cliente> findAll();

	Cliente findById(Long id) ;
	
	void deleteById(Long id);

	Page<Cliente> findAllBySearch(String search, int page, int size);
}

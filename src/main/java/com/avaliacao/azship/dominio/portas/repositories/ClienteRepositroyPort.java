package com.avaliacao.azship.dominio.portas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

public interface ClienteRepositroyPort {
	void save(Cliente cliente);

	List<Cliente> findAll();

	Cliente findById(Long id);
	
	void deleteById(Long id);

	Page<ClienteEntity> findAllBySearch(Pageable pageable, String search);
}

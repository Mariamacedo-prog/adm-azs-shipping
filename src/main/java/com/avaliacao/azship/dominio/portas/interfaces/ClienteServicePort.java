package com.avaliacao.azship.dominio.portas.interfaces;

import java.util.List;

import com.avaliacao.azship.dominio.Cliente;

public interface ClienteServicePort {
	void save(Cliente frete);

	List<Cliente> findAll();

	Cliente findById(Long id) ;
}

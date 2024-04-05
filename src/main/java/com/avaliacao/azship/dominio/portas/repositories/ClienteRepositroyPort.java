package com.avaliacao.azship.dominio.portas.repositories;

import java.util.List;

import com.avaliacao.azship.dominio.Cliente;

public interface ClienteRepositroyPort {
	void save(Cliente cliente);

	List<Cliente> findAll();

	Cliente findById(Long id);
}

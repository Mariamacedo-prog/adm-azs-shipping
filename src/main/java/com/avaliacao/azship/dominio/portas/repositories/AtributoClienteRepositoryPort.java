package com.avaliacao.azship.dominio.portas.repositories;

import java.util.List;

import com.avaliacao.azship.dominio.AtributoCliente;

public interface AtributoClienteRepositoryPort {

	void save(AtributoCliente cliente);

	AtributoCliente findById(Long id);

	void deleteById(Long id);

	List<AtributoCliente> findAll();

	List<AtributoCliente> findByClienteId(Long clienteId);
}

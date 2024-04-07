package com.avaliacao.azship.dominio.portas.interfaces;

import java.util.List;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.dtos.AtributoClienteDTO;

public interface AtributoClienteServicePort {

	void save(AtributoClienteDTO atributoclienteDTO);

	List<AtributoCliente> findAll();

	AtributoCliente findById(Long id);

	void deleteById(Long id);

	List<AtributoCliente> findByClienteId(Long clienteId);

}

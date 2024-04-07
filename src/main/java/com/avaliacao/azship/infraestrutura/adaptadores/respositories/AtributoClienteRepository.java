package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.portas.repositories.AtributoClienteRepositoryPort;

@Component
public class AtributoClienteRepository implements AtributoClienteRepositoryPort{

	@Override
	public void save(AtributoCliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AtributoCliente findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AtributoCliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AtributoCliente> findByClienteId(Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

}

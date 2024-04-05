package com.avaliacao.azship.dominio.portas.repositories;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.avaliacao.azship.dominio.Frete;

public interface FreteRepositoryPort {
	void save(Frete frete);

	List<Frete> findAll();

	Frete findById(Long id);
	
	void deleteById(Long id);
}

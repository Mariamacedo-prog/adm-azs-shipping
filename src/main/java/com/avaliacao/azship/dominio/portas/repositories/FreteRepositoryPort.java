package com.avaliacao.azship.dominio.portas.repositories;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.avaliacao.azship.dominio.Frete;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.FreteEntity;

public interface FreteRepositoryPort {
	void save(Frete frete);

	List<Frete> findAll();

	Frete findById(Long id);
	
	void deleteById(Long id);

	Page<FreteEntity> findAllByOrigem(Pageable pageable, String destino);
}

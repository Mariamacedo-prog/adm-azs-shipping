package com.avaliacao.azship.dominio.portas.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.Frete;
import com.avaliacao.azship.dominio.dtos.FreteDTO;



public interface FreteServicePort {
	void saveFrete(FreteDTO freteDTO, Cliente cliente);

	List<Frete> findAll();

	Frete findById(Long id);
	
	void deleteById(Long id);

	Page<Frete> findAllBySearch(String search, int page, int size);
}

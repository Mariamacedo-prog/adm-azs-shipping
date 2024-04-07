package com.avaliacao.azship.dominio.adaptadores.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.avaliacao.azship.dominio.Frete;
import com.avaliacao.azship.dominio.dtos.FreteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.FreteServicePort;
import com.avaliacao.azship.dominio.portas.repositories.FreteRepositoryPort;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.FreteEntity;

import jakarta.transaction.Transactional;

@Transactional
public class FreteServiceImp  implements FreteServicePort{
	private final FreteRepositoryPort freteRepository;
	  
    public FreteServiceImp(FreteRepositoryPort freteRepository) {
        this.freteRepository = freteRepository;
    }
    
    @Override
    public void saveFrete(FreteDTO freteDTO) {
        Frete frete = new Frete(freteDTO);
    
        this.freteRepository.save(frete);
    }
    
    @Override
    public List<Frete> findAll() {
    	List<Frete> frete = this.freteRepository.findAll();
 
       return frete;
    }
    
    @Override
    public Frete findById(Long id) {
    	return this.freteRepository.findById(id);                                                                               
    }
    
    @Override
    public void deleteById(Long id) {
    	this.freteRepository.deleteById(id);                                                                               
    }
    
    @Override
    public Page<Frete> findAllBySearch(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
     
        return freteRepository.findAllBySearch(pageable, search)
                .map(FreteEntity::toFrete);
  
    }
}                                                                                                 

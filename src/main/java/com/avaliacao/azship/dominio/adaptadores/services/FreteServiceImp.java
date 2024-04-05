package com.avaliacao.azship.dominio.adaptadores.services;

import java.util.List;

import com.avaliacao.azship.dominio.Frete;
import com.avaliacao.azship.dominio.dtos.FreteDTO;
import com.avaliacao.azship.dominio.portas.interfaces.FreteServicePort;
import com.avaliacao.azship.dominio.portas.repositories.FreteRepositoryPort;

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
}                                                                                                 

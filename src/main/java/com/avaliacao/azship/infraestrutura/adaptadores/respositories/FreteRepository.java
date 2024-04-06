package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.Frete;
import com.avaliacao.azship.dominio.dtos.ClienteDTO;
import com.avaliacao.azship.dominio.portas.repositories.FreteRepositoryPort;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.FreteEntity;

@Component
public class FreteRepository implements FreteRepositoryPort{
	
    private final SpringFreteRepository springFreteRepository;
    private SpringClienteRepository clienteRepository;

    public FreteRepository(SpringFreteRepository springFreteRepository,SpringClienteRepository clienteRepository) {
        this.springFreteRepository = springFreteRepository;
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public void save(Frete frete) {
        ClienteEntity clienteById = this.clienteRepository.findById(frete.getCliente())
       		.orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID fornecido: " + frete.getCliente()));
     	
        if (frete.getId() == null) {
            FreteEntity freteEntity = new FreteEntity(frete, clienteById);
            this.springFreteRepository.save(freteEntity);
        } else {
            Optional<FreteEntity> opt = this.springFreteRepository.findById(frete.getId());
            FreteEntity freteEntity = opt.orElseThrow(() -> new RuntimeException("Frete não encontrado com o ID fornecido: " + frete.getId()));
            freteEntity.updateInfo(frete, clienteById);
            this.springFreteRepository.save(freteEntity);
        }
    }
    
    @Override
    public List<Frete> findAll() {
        List<FreteEntity> freteEntities = this.springFreteRepository.findAll();
        return freteEntities.stream().map(FreteEntity::toFrete).collect(Collectors.toList());
    }
    
    @Override
    public Frete findById(Long id) {
        Optional<FreteEntity> opt = this.springFreteRepository.findById(id);
        return opt.orElseThrow(() -> new RuntimeException("Frete não encontrado com o ID: " + id)).toFrete();
    }

    @Override
    public void deleteById(Long id) {
        this.springFreteRepository.deleteById(id);
    }

	@Override
	public Page<FreteEntity> findAllByOrigem(Pageable pageable, String search) {
		return this.springFreteRepository.findAllByOrigem(pageable, search);
	}
}

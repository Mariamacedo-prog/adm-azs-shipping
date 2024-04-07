package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.portas.repositories.AtributoClienteRepositoryPort;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.AtributoClienteEntity;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AtributoClienteRepository implements AtributoClienteRepositoryPort{
    private SpringAtributoClienteRepository springAtributoClienteRepository;
    private SpringClienteRepository clienteRepository;

    public AtributoClienteRepository(SpringAtributoClienteRepository springAtributoClienteRepository, SpringClienteRepository clienteRepository) {
        this.springAtributoClienteRepository = springAtributoClienteRepository;
        this.clienteRepository = clienteRepository;
    }

	@Override
	public void save(AtributoCliente atributo) {
		ClienteEntity clienteById = this.clienteRepository.findById(atributo.getClienteId())
		       .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID fornecido: " + atributo.getClienteId()));
		
	    if (atributo.getId() == null) {
        	AtributoClienteEntity atributoEntity = new AtributoClienteEntity(atributo, clienteById);
        	
            this.springAtributoClienteRepository.save(atributoEntity);
        } else {
            Optional<AtributoClienteEntity> opt = this.springAtributoClienteRepository.findById(atributo.getId());
  
            AtributoClienteEntity atributoUpdateEntity = opt.orElseThrow(() -> new RuntimeException("Atributo não encontrado com o ID fornecido: " + atributo.getId()));
            atributoUpdateEntity.updateInfo(atributo, clienteById);
    
            this.springAtributoClienteRepository.save(atributoUpdateEntity);
        }
	}

	@Override
	public AtributoCliente findById(Long id) {
		Optional<AtributoClienteEntity> opt = this.springAtributoClienteRepository.findById(id);

        if (opt.isPresent())
            return opt.get().toAtributoCliente();

        throw new RuntimeException("Atributo não encontrado com o ID: " + id);
	}

	@Override
	public void deleteById(Long id) {
		Optional<AtributoClienteEntity> opt = this.springAtributoClienteRepository.findById(id);

        if (opt.isPresent()) {
        	this.springAtributoClienteRepository.delete(opt.get());
        }else {
        	 throw new RuntimeException("Atributo não encontrado com o ID: " + id);
        }
	}

	@Override
	public List<AtributoCliente> findByClienteId(Long clienteId) {
		List<AtributoClienteEntity> atributes = this.springAtributoClienteRepository.findByClienteId(clienteId);

		 return atributes.stream().map(AtributoClienteEntity::toAtributoCliente).collect(Collectors.toList());
	}

}

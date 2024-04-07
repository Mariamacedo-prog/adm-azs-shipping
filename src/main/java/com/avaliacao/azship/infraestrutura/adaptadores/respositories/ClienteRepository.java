package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.avaliacao.azship.dominio.Cliente;

import com.avaliacao.azship.dominio.portas.repositories.ClienteRepositroyPort;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

@Component
public class ClienteRepository implements ClienteRepositroyPort {
	
    private final SpringClienteRepository springClienteRepository;

    public ClienteRepository(SpringClienteRepository springClienteRepository) {
        this.springClienteRepository = springClienteRepository;
    }
    

	@Override
	public List<Cliente> findAll() {
        List<ClienteEntity> clienteEntities = this.springClienteRepository.findAll();
        return clienteEntities.stream().map(ClienteEntity::toCliente).collect(Collectors.toList());
	}

	@Override
	public void save(Cliente cliente) {  	
        if (cliente.getId() == null) {
        	ClienteEntity clienteEntity = new ClienteEntity(cliente);
            this.springClienteRepository.save(clienteEntity);
        } else {
            Optional<ClienteEntity> opt = this.springClienteRepository.findById(cliente.getId());
            ClienteEntity clienteEntity = opt.orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID fornecido: " + cliente.getId()));
            clienteEntity.updateInfo(cliente);
            this.springClienteRepository.save(clienteEntity);
        }
	}

	@Override
	public Cliente findById(Long id) {
        Optional<ClienteEntity> opt = this.springClienteRepository.findById(id);

        if (opt.isPresent())
            return opt.get().toCliente();

        throw new RuntimeException("Cliente não encontrado com o ID: " + id);
	}


	@Override
	public void deleteById(Long id) {
		Optional<ClienteEntity> opt = this.springClienteRepository.findById(id);

        if (opt.isPresent()) {
            this.springClienteRepository.deleteFreteByClienteId(id);
            this.springClienteRepository.deleteAtributoClienteByClienteId(id);
            this.springClienteRepository.deleteById(id);   	
        }else {
        	  throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
	}


	@Override
	public Page<ClienteEntity> findAllBySearch(Pageable pageable, String search) {
		return this.springClienteRepository.findAllBySearch(pageable, search);
	}

}

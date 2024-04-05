package com.avaliacao.azship.infraestrutura.adaptadores.respositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(Long id) {
        Optional<ClienteEntity> opt = this.springClienteRepository.findById(id);

        if (opt.isPresent())
            return opt.get().toCliente();

        throw new RuntimeException("Cliente não encontrado com o ID: " + id);
	}

}

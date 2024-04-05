package com.avaliacao.azship.dominio.adaptadores.services;

import java.util.List;

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.portas.interfaces.ClienteServicePort;
import com.avaliacao.azship.dominio.portas.repositories.ClienteRepositroyPort;

public class ClienteServiceImp  implements ClienteServicePort {
	
	private final ClienteRepositroyPort clienteRepository;
	  
    public ClienteServiceImp(ClienteRepositroyPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

	@Override
	public void save(Cliente frete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

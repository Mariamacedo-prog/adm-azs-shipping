package com.avaliacao.azship.dominio;

import java.util.List;

import com.avaliacao.azship.dominio.dtos.ClienteDTO;


public class Cliente {
	private Long id;
    private String nome; 
    
    public Cliente() {}

    public Cliente(Long id, String nome, List<AtributoCliente> atributos) {
        this.setId(id);
        this.setNome(nome);
    }

    public Cliente (ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}

package com.avaliacao.azship.dominio.dtos;

import java.util.List;

import com.avaliacao.azship.dominio.Cliente;

public class ClienteDTO {
	private Long id;
    private String nome; 
    
    public ClienteDTO() {}
    
    public ClienteDTO(Long id, String nome) {
        this.setId(id);
        this.setNome(nome);
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

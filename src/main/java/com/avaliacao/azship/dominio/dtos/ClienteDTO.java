package com.avaliacao.azship.dominio.dtos;

import java.util.List;

public class ClienteDTO {
	private Long id;
    private String nome; 
    private List<AtributoClienteDTO> atributos;
    
    
    public ClienteDTO(Long id, String nome, List<AtributoClienteDTO> atributos) {
        this.setId(id);
        this.setNome(nome);
        this.setAtributos(atributos);
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
	public List<AtributoClienteDTO> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<AtributoClienteDTO> atributos) {
		this.atributos = atributos;
	}
}

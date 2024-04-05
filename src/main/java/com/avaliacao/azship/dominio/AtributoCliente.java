package com.avaliacao.azship.dominio;

import com.avaliacao.azship.infraestrutura.adaptadores.entidades.AtributoClienteEntity;

public class AtributoCliente {
	private Long id;
	private String nome;
    private String valor;
    
	public AtributoCliente() {}
    

	public AtributoCliente(Long id, String nome, String valor) {
	    this.setId(id);
	    this.setNome(nome);
	    this.setValor(valor);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public static AtributoCliente fromEntity(AtributoClienteEntity atributoClienteEntity) {
        AtributoCliente atributoCliente = new AtributoCliente();
        atributoCliente.setId(atributoClienteEntity.getId());
        atributoCliente.setNome(atributoClienteEntity.getNome());
        atributoCliente.setValor(atributoClienteEntity.getValor());
        return atributoCliente;
    }

    public static AtributoClienteEntity toEntity(AtributoCliente atributoCliente) {
        AtributoClienteEntity atributoClienteEntity = new AtributoClienteEntity();
        atributoClienteEntity.setId(atributoCliente.getId());
        atributoClienteEntity.setNome(atributoCliente.getNome());
        atributoClienteEntity.setValor(atributoCliente.getValor());
        return atributoClienteEntity;
    }
}

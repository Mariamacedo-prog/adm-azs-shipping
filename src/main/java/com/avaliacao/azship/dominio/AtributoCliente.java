package com.avaliacao.azship.dominio;

import com.avaliacao.azship.dominio.dtos.AtributoClienteDTO;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.AtributoClienteEntity;


public class AtributoCliente {
	private Long id;
	private String nome;
    private String valor;
    private Long clienteId;
    
	public AtributoCliente() {}
    

	public AtributoCliente(Long id, String nome, String valor, Long clienteId) {
	    this.setId(id);
	    this.setNome(nome);
	    this.setValor(valor);
	    this.setClienteId(clienteId);
	}
	
    public AtributoCliente(AtributoClienteDTO atributoDTO) {
  	  	this.setId(atributoDTO.getId());
  	  	this.setNome(atributoDTO.getNome());
	    this.setValor(atributoDTO.getValor());
	    this.setClienteId(atributoDTO.getClienteId());
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
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}


	public static AtributoCliente fromEntity(AtributoClienteEntity atributoClienteEntity) {
        AtributoCliente atributoCliente = new AtributoCliente();
        atributoCliente.setId(atributoClienteEntity.getId());
        atributoCliente.setNome(atributoClienteEntity.getNome());
        atributoCliente.setValor(atributoClienteEntity.getValor());
        atributoCliente.setClienteId(atributoClienteEntity.getCliente().getId());
        return atributoCliente;
    }

//    public static AtributoClienteEntity toEntity(AtributoCliente atributoCliente, ClienteEntity cliente) {
//        AtributoClienteEntity atributoClienteEntity = new AtributoClienteEntity();
//        atributoClienteEntity.setId(atributoCliente.getId());
//        atributoClienteEntity.setNome(atributoCliente.getNome());
//        atributoClienteEntity.setValor(atributoCliente.getValor());
//        atributoClienteEntity.setCliente(cliente);
//        return atributoClienteEntity;
//    }
}

package com.avaliacao.azship.dominio.dtos;

import com.avaliacao.azship.dominio.AtributoCliente;

public class AtributoClienteDTO {
	private Long id;
    private String nome;
    private String valor;
    private Long clienteId;
    
	public AtributoClienteDTO(Long id ,String nome, String valor, Long ClienteId) {
        this.setId(id);
	    this.setNome(nome);
	    this.setValor(valor);
	    this.setClienteId(ClienteId);
	}
       
    public AtributoCliente toAtributoCliente() {
        return new AtributoCliente(this.getId(), this.getNome(), this.getValor(), this.getClienteId());
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
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}

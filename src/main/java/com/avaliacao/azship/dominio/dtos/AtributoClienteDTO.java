package com.avaliacao.azship.dominio.dtos;

import com.avaliacao.azship.dominio.AtributoCliente;

public class AtributoClienteDTO {
	private Long id;
    private String nome;
    private String valor;
    
	public AtributoClienteDTO(String nome, String valor) {
	    this.setNome(nome);
	    this.setValor(valor);
	}
       
    public AtributoCliente toAtributoCliente() {
        return new AtributoCliente(this.id, this.nome, this.valor);
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
}

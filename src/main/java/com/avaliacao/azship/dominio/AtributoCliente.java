package com.avaliacao.azship.dominio;


public class AtributoCliente {
	private String nome;
    private String valor;
    
	public AtributoCliente() {}
    

	public AtributoCliente(String nome, String valor) {
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
}

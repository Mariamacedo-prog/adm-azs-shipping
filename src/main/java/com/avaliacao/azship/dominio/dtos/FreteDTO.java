package com.avaliacao.azship.dominio.dtos;

import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

public class FreteDTO {
	private Long id;
    private ClienteEntity cliente; 
    private String origem;
    private String destino;
    
    
    public FreteDTO(Long id, ClienteEntity cliente,String origem, String destino) {
        this.setId(id);
        this.setCliente(cliente);
        this.setOrigem(origem);
        this.setDestino(destino);
    }


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
}

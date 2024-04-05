package com.avaliacao.azship.dominio;

import com.avaliacao.azship.dominio.dtos.FreteDTO;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

public class Frete {
	private Long id;
    private Cliente cliente; 
    private String origem;
    private String destino;
    
    public Frete() {
    }

    public Frete(Long id, Cliente cliente, String origem, String destino) {
        this.setId(id);
        this.setCliente(cliente);
        this.setOrigem(origem);
        this.setDestino(destino);
    }

    public Frete(FreteDTO freteDTO) {
      	  Cliente cliente = new Cliente(freteDTO.getCliente());
    	  this.setId(freteDTO.getId());
          this.setCliente(cliente);
          this.setOrigem(freteDTO.getOrigem());
          this.setDestino(freteDTO.getDestino());
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
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

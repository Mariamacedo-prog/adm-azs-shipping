package com.avaliacao.azship.dominio;

import com.avaliacao.azship.dominio.dtos.FreteDTO;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;

public class Frete {
	private Long id;
    private Long cliente; 
    private String origem;
    private String destino;
    
    public Frete() {
    }

    public Frete(Long id, Long cliente, String origem, String destino) {
        this.setId(id);
        this.setCliente(cliente);
        this.setOrigem(origem);
        this.setDestino(destino);
    }

    public Frete(FreteDTO freteDTO) {
     
    	  this.setId(freteDTO.getId());
          this.setCliente(freteDTO.getCliente());
          this.setOrigem(freteDTO.getOrigem());
          this.setDestino(freteDTO.getDestino());
    }
    
    public FreteDTO toFrete() {
        return new FreteDTO(this.getId(), this.getCliente(), this.getOrigem(), this.getDestino());
    }

    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
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

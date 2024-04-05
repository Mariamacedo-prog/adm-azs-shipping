package com.avaliacao.azship.infraestrutura.adaptadores.entidades;

import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.Frete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "frete")
public class FreteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    private String origem;
    private String destino;
    

	public FreteEntity() {
    }

    public FreteEntity(Frete frete) {
    	ClienteEntity cliente = new ClienteEntity(frete.getCliente());
    	
		this.setId(frete.getId());
		this.setCliente(cliente);
		this.setOrigem(frete.getOrigem());
		this.setDestino(frete.getDestino());
    }

    public Frete toFrete() {
        return new Frete(this.getId(), this.getCliente().toCliente(), this.getOrigem(), this.getDestino());
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

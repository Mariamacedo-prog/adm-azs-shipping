package com.avaliacao.azship.infraestrutura.adaptadores.entidades;

import java.util.ArrayList;
import java.util.List;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.dtos.AtributoClienteDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "atributo_cliente")
public class AtributoClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    
    private String nome;
    private String valor;
    
    public AtributoClienteEntity() {}

    
    public AtributoCliente toAtributoCliente() {
        return new AtributoCliente(this.getId() ,this.getNome(), this.getValor(), this.getCliente().getId());
    }
    
    public AtributoClienteEntity(AtributoCliente atributo, ClienteEntity clienteById) {
        this.setId(atributo.getId());
        this.setNome(atributo.getNome());
        this.setValor(atributo.getValor());
        this.setCliente(clienteById);
    }
    
    public void updateInfo(AtributoCliente atributo, ClienteEntity clienteById) {
 		this.setNome(atributo.getNome());
 		this.setValor(atributo.getValor());
 	    this.setCliente(clienteById);
     }

    public AtributoClienteDTO toAtributoClienteDTO() {
        return new AtributoClienteDTO(this.getId(),this.getNome(), this.getValor(), this.getCliente().getId());
    }
    
    public static List<AtributoCliente> toAtributoClienteList(List<AtributoClienteEntity> atributoClienteEntities) {
        List<AtributoCliente> atributoClientes = new ArrayList<>();
        for (AtributoClienteEntity entity : atributoClienteEntities) {
            atributoClientes.add(entity.toAtributoCliente());
        }
        return atributoClientes;
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

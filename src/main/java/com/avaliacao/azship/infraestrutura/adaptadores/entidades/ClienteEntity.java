package com.avaliacao.azship.infraestrutura.adaptadores.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.avaliacao.azship.dominio.AtributoCliente;
import com.avaliacao.azship.dominio.Cliente;
import com.avaliacao.azship.dominio.Frete;
import com.avaliacao.azship.dominio.dtos.AtributoClienteDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AtributoClienteEntity> atributos = new ArrayList<>();
    
    public ClienteEntity() {
    }
    
    public void updateInfo(Cliente cliente) {
		this.setNome(cliente.getNome());
    }
    
    public Cliente toCliente() {
        return new Cliente(this.getId(), this.getNome());
    }
    
    public ClienteEntity(Cliente cliente) {
        this.setId(cliente.getId());
        this.setNome(cliente.getNome());
    }
    
    public ClienteEntity(Long id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }


    private List<AtributoCliente> toAtributoClienteList(List<AtributoClienteEntity> atributos) {
        return atributos.stream()
                .map(atributoClienteEntity -> atributoClienteEntity.toAtributoCliente())
                .collect(Collectors.toList());
    }

    private List<AtributoClienteEntity> toAtributoClienteEntityList(List<AtributoCliente> atributos) {
        return atributos.stream()
                .map(atributoCliente -> new AtributoClienteEntity())
                .collect(Collectors.toList());
    }
    
    public List<AtributoCliente> toAtributoClienteModelList() {
        return this.atributos.stream()
                .map(AtributoClienteEntity::toAtributoCliente)
                .collect(Collectors.toList());
    }
    
    public List<AtributoClienteDTO> toAtributoClienteDTOList() {
        return this.atributos.stream()
                .map(AtributoClienteEntity::toAtributoClienteDTO)
                .collect(Collectors.toList());
    }

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<AtributoClienteEntity> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<AtributoClienteEntity> atributos) {
		this.atributos = atributos;
	}  
}

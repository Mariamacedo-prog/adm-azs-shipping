package com.avaliacao.azship.dominio;
import java.util.List;

import com.avaliacao.azship.dominio.dtos.ClienteDTO;
import com.avaliacao.azship.infraestrutura.adaptadores.entidades.ClienteEntity;


public class Cliente {
	private Long id;
    private String nome;
    private List<AtributoCliente> atributos;
    
    public Cliente() {}

    public Cliente(Long id, String nome,List<AtributoCliente> atributos) {
        this.setId(id);
        this.setNome(nome);
        this.setAtributos(atributos);
    }

    public Cliente (ClienteDTO clienteDTO) {
        this.setId(clienteDTO.getId());
        this.setNome(clienteDTO.getNome());
    }
    
    public static Cliente fromEntity(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteEntity.getId());
        cliente.setNome(clienteEntity.getNome());
        cliente.setAtributos(clienteEntity.toAtributoClienteModelList());
        return cliente;
    }

    public static ClienteEntity toEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente);

        return clienteEntity;
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
	public List<AtributoCliente> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<AtributoCliente> atributos) {
		this.atributos = atributos;
	}
}

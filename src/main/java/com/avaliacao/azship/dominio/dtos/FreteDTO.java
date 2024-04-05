package com.avaliacao.azship.dominio.dtos;

public class FreteDTO {
	private Long id;
    private ClienteDTO cliente; 
    private String origem;
    private String destino;
    
    
    public FreteDTO(Long id, ClienteDTO cliente,String origem, String destino) {
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
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
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

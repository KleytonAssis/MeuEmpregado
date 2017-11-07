package com.facear.model;

public class TipoDocumento {

	private int idtipo;
	private String descricao;

	public TipoDocumento(int idtipo, String descricao) {
		this.idtipo = idtipo;
		this.descricao = descricao;
	}

	public TipoDocumento() { 
		
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

package com.facear.model;

import java.sql.Date;

public class DocumentoEmpregado {

	
	private int iddocumento;
	private int idcliente;
	private Date datas;
	private String diretorio;
	private String tipodoc;
	private String prop;
	private int idtipo;

	public DocumentoEmpregado(int iddocumento, int idcliente, Date datas, String diretorio, String tipodoc,
			String prop, int idtipo) {
		super();
		this.iddocumento = iddocumento;
		this.idcliente = idcliente;
		this.datas = datas;
		this.diretorio = diretorio;
		this.tipodoc = tipodoc;
		this.prop = prop;
		this.idtipo = idtipo;
	}

	public int getIddocumento() {
		return iddocumento;
	}

	public void setIddocumento(int iddocumento) {
		this.iddocumento = iddocumento;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public Date getDatas() {
		return datas;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public void setDatas(Date datas) {
		this.datas = datas;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public String getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

}

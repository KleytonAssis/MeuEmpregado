package br.edu.facear.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocumentoEmpregado {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer iddocumento;
	private int idcliente;	
	private Date data;
	private String status;
	private TipoDocumento tipodoc;
	private String diretorio;
	
	
	public TipoDocumento getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(TipoDocumento tipodoc) {
		this.tipodoc = tipodoc;
	}
	public String getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}	
	public Integer getIddocumento() {
		return iddocumento;
	}
	public void setIddocumento(Integer iddocumento) {
		this.iddocumento = iddocumento;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	}

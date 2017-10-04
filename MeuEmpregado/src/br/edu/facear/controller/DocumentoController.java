package br.edu.facear.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.catalina.core.ApplicationPart;

import br.edu.facear.dao.DocumentoDAO;
import br.edu.facear.entity.DocumentoEmpregado;
import br.edu.facear.entity.TipoDocumento;

@ManagedBean(name = "DocumentoController")
public class DocumentoController {
	
	
	private Integer iddocumento;
	private int idcliente;	
	private Date data;
	private String status;
	private TipoDocumento tipodoc;
	
	private String diretorio;
	
	private List<DocumentoEmpregado> documentos = new ArrayList<DocumentoEmpregado>();
	
	private ApplicationPart foto;

		@PostConstruct
	public void carregarDocumentos() {
		DocumentoDAO documentoDao = new DocumentoDAO();
		documentos = documentoDao.listarTodos();
	
	}

	

	public String salvar() throws IOException {
		System.out.println("Caminho:" + diretorio);
		//System.out.println("Idade:" + status);

		String diretorio = "";
		if (foto != null) {
			byte[] bytes = new byte[(int) foto.getSize()];
			foto.getInputStream().read(bytes);

			File f = new File("c:\\temp\\" + foto.getSubmittedFileName());

			FileOutputStream fo = new FileOutputStream(f);
			fo.write(bytes);
			fo.close();

			diretorio = "c:\\temp\\" + foto.getSubmittedFileName();
		}

		
		DocumentoEmpregado d = new DocumentoEmpregado();
		d.setIdcliente(idcliente);
		d.setData(data);
		d.setTipodoc(tipodoc);
		d.setStatus(status);
		d.setDiretorio(diretorio);

		DocumentoDAO documentoDao = new DocumentoDAO();

		if (iddocumento == null || iddocumento == 0) {
			documentoDao.inserir(d);
		} else {
			d.setIddocumento(iddocumento);
			documentoDao.alterar(d);
		}

		documentos = documentoDao.listarTodos();

		return "";
	}


	public String carregar(DocumentoEmpregado d) {
		this.iddocumento = iddocumento;
		this.idcliente = idcliente;
		this.data = data;
		this.tipodoc = tipodoc;
		this.status = status;
		this.diretorio = diretorio;
		this.documentos = documentos;
		this.foto = foto;
		return "";
	}

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


	public String getCaminhoImagem() {
		return diretorio;
	}


	public void setCaminhoImagem(String diretorio) {
		this.diretorio = diretorio;
	}


	public List<DocumentoEmpregado> getDocumentos() {
		return documentos;
	}


	public void setDocumentos(List<DocumentoEmpregado> documentos) {
		this.documentos = documentos;
	}


	public ApplicationPart getFoto() {
		return foto;
	}


	public void setFoto(ApplicationPart foto) {
		this.foto = foto;
	}
}

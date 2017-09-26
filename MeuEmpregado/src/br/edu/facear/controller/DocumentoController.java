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

import br.edu.facear.dao.DocumentoDao;
import br.edu.facear.entity.Documento;

@ManagedBean(name = "DocumentoController")
public class DocumentoController {
	
	
	private Integer iddocumento;
	private int idcliente;	
	private Date data;
	private String status;
	private String tipodoc;
	
	private String caminhoImagem;
	
	private List<Documento> documentos = new ArrayList<Documento>();
	
	private ApplicationPart foto;

	@PostConstruct
	public void carregarDocumentos() {
		DocumentoDao documentoDao = new DocumentoDao();
		documentos = documentoDao.listarTodos();
	
	}


	public String salvar() throws IOException {
		System.out.println("Caminho:" + caminhoImagem);
		//System.out.println("Idade:" + status);

		String caminhoImagem = "";
		if (foto != null) {
			byte[] bytes = new byte[(int) foto.getSize()];
			foto.getInputStream().read(bytes);

			File f = new File("c:\\temp\\" + foto.getSubmittedFileName());

			FileOutputStream fo = new FileOutputStream(f);
			fo.write(bytes);
			fo.close();

			caminhoImagem = "c:\\temp\\" + foto.getSubmittedFileName();
		}

		
		Documento d = new Documento();
		d.setIdcliente(idcliente);
		d.setData(data);
		d.setTipodoc(tipodoc);
		d.setStatus(status);
		d.setCaminhoImagem(caminhoImagem);

		DocumentoDao documentoDao = new DocumentoDao();

		if (iddocumento == null || iddocumento == 0) {
			documentoDao.inserir(d);
		} else {
			d.setIddocumento(iddocumento);
			documentoDao.alterar(d);
		}

		documentos = documentoDao.listarTodos();

		return "";
	}


	public String carregar(Documento d) {
		this.iddocumento = iddocumento;
		this.idcliente = idcliente;
		this.data = data;
		this.tipodoc = tipodoc;
		this.status = status;
		this.caminhoImagem = caminhoImagem;
		this.documentos = documentos;
		this.foto = foto;
		return "";
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
		return caminhoImagem;
	}


	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}


	public List<Documento> getDocumentos() {
		return documentos;
	}


	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}


	public ApplicationPart getFoto() {
		return foto;
	}


	public void setFoto(ApplicationPart foto) {
		this.foto = foto;
	}


	public String getTipodoc() {
		return tipodoc;
	}


	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

}

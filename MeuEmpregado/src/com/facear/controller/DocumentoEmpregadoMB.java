package com.facear.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletResponse;

import com.facear.dao.DocumentoDAO;
import com.facear.dao.TipoDocumentoDAO;
import com.facear.model.DocumentoEmpregado;
import com.facear.model.TipoDocumento;
import com.facear.service.DocumentoService;

@SessionScoped
@ManagedBean(name = "DocumentoEmpregadoMB")
public class DocumentoEmpregadoMB {

	 
		
		private DocumentoEmpregado docemp;
		private TipoDocumento tipodo;

		DocumentoService docserv = new DocumentoService();

		private int iddocumento;
		private int idcliente;
		private Date datas;
		private String diretorio;
		private String tipodoc;
		private String prop;

		private List<DocumentoEmpregado> documentos = new ArrayList<DocumentoEmpregado>();
		private List<TipoDocumento> tipos = new ArrayList<TipoDocumento>();

		public DocumentoEmpregadoMB() {
			documentos = docserv.listarTodos();
			 tipos = docserv.listarTodosTipo();
		}

		
		public void pesquisa() {
			System.out.println("Searching... tipo::" + tipodoc);
			this.documentos = docserv.pesquisa(tipodoc);
		}
		
		public String CarregaArquivo() {
			System.out.println("Carregando");
			try {
	    		if(tipodoc != null) {
	    			DocumentoEmpregado d = (DocumentoEmpregado) new DocumentoDAO().listartipo(tipodoc);
	    	    	File f = new File(d.getDiretorio());
	    	    	byte[] arquivo = new byte[(int) f.length()];
	    	    	
	    		FileInputStream fi = new FileInputStream(f);
	    		fi.read(arquivo);
	    		
	    		}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "buscar.xhtml";
			}
		
		
		public List<TipoDocumento> getTipos() {
			return tipos;
		}

		public void setTipos(List<TipoDocumento> tipos) {
			this.tipos = tipos;
		}

		public int getIddocumento() {
			return iddocumento;
		}

		public void setIddocumento(int iddocumento) {
			this.iddocumento = iddocumento;
		}

		public String getProp() {
			return prop;
		}
		public void setProp(String prop) {
			this.prop = prop;
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

		public List<DocumentoEmpregado> getDocumentos() {
			return documentos;
		}

		public void setDocumentos(List<DocumentoEmpregado> documentos) {
			this.documentos = documentos;
		}

		public DocumentoEmpregado getDocemp() {
			return docemp;
		}

		public void setDocemp(DocumentoEmpregado docemp) {
			this.docemp = docemp;
		}


		public TipoDocumento getTipodo() {
			return tipodo;
		}


		public void setTipodo(TipoDocumento tipodo) {
			this.tipodo = tipodo;
		}
	}


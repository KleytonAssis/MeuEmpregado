package com.facear.service;

import java.util.List;

import com.facear.dao.DocumentoDAO;
import com.facear.dao.TipoDocumentoDAO;
import com.facear.model.DocumentoEmpregado;
import com.facear.model.TipoDocumento;

public class DocumentoService {

	
	DocumentoDAO dao = new DocumentoDAO();
	TipoDocumentoDAO tipodao = new TipoDocumentoDAO();

	public List<DocumentoEmpregado> listarTodos(){
		return dao.listarTodos();
	}
	
	public List<TipoDocumento> listarTodosTipo(){
		return tipodao.listarTodos();
	}
	
	public List<DocumentoEmpregado> pesquisa(String tipo) {
		return dao.listartipo(tipo);
	}
		
	
}

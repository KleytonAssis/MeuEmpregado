package br.edu.facear.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.dao.DocumentoDao;
import br.edu.facear.entity.Documento;

@WebServlet("/PesquisarDocumentoService")
public class SalvarDocumentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SalvarDocumentoServlet() {
    super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("iddocumento");
    	//id = "1";
		if(id != null) {
		Documento d = new DocumentoDao().listarId(new Integer(id));
    	
    	String caminhoDaImagem = d.getCaminhoImagem();
    	
    	File f = new File(caminhoDaImagem);
    	byte[] arquivo = new byte[(int) f.length()];
    	FileInputStream fi = new FileInputStream(f);
    	
    	fi.read(arquivo);
    	
    	response.getOutputStream().write(arquivo);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

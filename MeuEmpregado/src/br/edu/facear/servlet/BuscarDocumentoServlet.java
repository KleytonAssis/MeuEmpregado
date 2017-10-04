package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.controller.DocumentoController;
import br.edu.facear.entity.Documento;

/**
 * Servlet implementation class BuscarDocumentoServlet
 */
@WebServlet("/BuscarDocumentoServlet")
public class BuscarDocumentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarDocumentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Documento> documentos = new ArrayList<>();
		
		// 1 - Obter parametro id pela url
		String id = request.getParameter("id");
		
		String nextPage = "/listarDocumentos.jsp";
		
		// 2 - Converter id para integer
		
		DocumentoController service = new DocumentoController();
		Documento c = null;
			documentos = service.getDocumentos();

		
		request.setAttribute("cliente", c);

//Fazer as alterações para carregar uma lista com o conteudo buscado 		
		nextPage = "/detalhesDocumento.jsp";
		// 4 - Redirecionar para detalhesDocumento.jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
			
		doGet(request, response);
	}

}

package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.DocumentoEmpregado;


public class DocumentoDAO  implements InterfaceDao<DocumentoEmpregado>{

	@Override
	public void inserir(DocumentoEmpregado d) {
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void alterar(DocumentoEmpregado d) {
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.merge(d);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<DocumentoEmpregado> listarTodos() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Documento");
		List<DocumentoEmpregado> documentos = q.getResultList();
		em.close();
		return documentos;
	}

	@Override
	public DocumentoEmpregado listarId(int iddocumento) {
		EntityManager em = Conexao.getInstance();
		DocumentoEmpregado d = em.find(DocumentoEmpregado.class, iddocumento);
		em.close();	
		return d;
	}

}

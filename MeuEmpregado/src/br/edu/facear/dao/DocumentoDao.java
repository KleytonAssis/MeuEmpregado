package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Documento;


public class DocumentoDao  implements InterfaceDao<Documento>{

	@Override
	public void inserir(Documento d) {
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void alterar(Documento d) {
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.merge(d);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Documento> listarTodos() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Documento");
		List<Documento> documentos = q.getResultList();
		em.close();
		return documentos;
	}

	@Override
	public Documento listarId(int iddocumento) {
		EntityManager em = Conexao.getInstance();
		Documento d = em.find(Documento.class, iddocumento);
		em.close();	
		return d;
	}

}

package br.edu.facear.dao;

import java.util.List;

public interface InterfaceDao <D> {

	public void inserir(D d);	
	public void alterar(D d);	
	public List<D> listarTodos();
	public D listarId(int iddocumento);
	

	
}
package com.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facear.model.DocumentoEmpregado;

public class DocumentoDAO extends GenericDAO {

	private String ListarTodos = "SELECT * FROM Documento;";

	private PreparedStatement ps;

	public List<DocumentoEmpregado> listarTodos() {
		List<DocumentoEmpregado> lista = new ArrayList<DocumentoEmpregado>();

		try {
			// Abrir conexão
			openConnection();

			// Preparar comando de SELECT
			ps = connect.prepareStatement(ListarTodos);

			// Retorno da consulta com os dados no ResultSet
			ResultSet rs = ps.executeQuery();

			// Se houve retorno
			if (rs != null) {
				while (rs.next()) {
					// Para cada registro do ResultSet, instanciar um objeto DocumentoEmpregado
				DocumentoEmpregado d = new DocumentoEmpregado(rs.getInt("iddocumento"), rs.getInt("idcliente"), rs.getDate("datas"), rs.getString("diretorio"), rs.getString("tipodoc"),rs.getString("prop"),rs.getInt("idtipo"));
					// Adicionar na lista de DocumentoEmpregados
					lista.add(d);
				}
			}

			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error aos Connecting");
			
		}

		// Se por acado não houve retorno do banco de dados, retorna
		return lista;
	}

	public List<DocumentoEmpregado> listartipo(String tipo) {
		ArrayList<DocumentoEmpregado> lista = new ArrayList<DocumentoEmpregado>();
		try {
			// Abrir conexão
			openConnection();

			 String ListarTipo = "Select * from Documento d inner join TipoDocumento t on d.idtipo = t.idtipo where d.tipodoc like'"+tipo+"'";

			
			// Preparar comando de SELECT
			ps = connect.prepareStatement(ListarTipo);

			// Retorno da consulta com os dados no ResultSet
			ResultSet rs = ps.executeQuery();

			// Se houve retorno
			if (rs != null) {
				while (rs.next()) {
					// Para cada registro do ResultSet, instanciar um objeto DocumentoEmpregado
				DocumentoEmpregado d = new DocumentoEmpregado(rs.getInt("iddocumento"), rs.getInt("idcliente"), rs.getDate("datas"), rs.getString("diretorio"), rs.getString("tipodoc"),rs.getString("prop"),rs.getInt("idtipo"));
					// Adicionar na lista de DocumentoEmpregados
					lista.add(d);
				}
			}

			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("Error aos Connecting");
			
		}

		return lista;
	}
}

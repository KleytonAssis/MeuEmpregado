package com.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facear.model.DocumentoEmpregado;
import com.facear.model.TipoDocumento;

public class TipoDocumentoDAO extends GenericDAO {

	private String ListarTodos = "SELECT * FROM TipoDocumento;";

	private PreparedStatement ps;

	public List<TipoDocumento> listarTodos() {

		List<TipoDocumento> lista = new ArrayList<TipoDocumento>();

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
				TipoDocumento t = new TipoDocumento(rs.getInt("idtipo"),rs.getString("descricao"));
					// Adicionar na lista de DocumentoEmpregados
					lista.add(t);
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
}

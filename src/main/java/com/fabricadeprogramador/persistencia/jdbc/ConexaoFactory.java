package com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConexao() {


		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(
					"jdbc:postgresql:cjweb", "postgres", "toor");

		} catch (SQLException ex) {
			throw new RuntimeException("Erro na Conexao com o banco", ex);
		}catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}

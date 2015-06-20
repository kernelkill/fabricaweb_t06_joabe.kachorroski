package com.frabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class UsuarioDAO {
	
	public void cadastrarUsuario(Usuario usu){
		
		//Primeiro: pega a conexao.
		Connection con = ConexaoFactory.getConxao();
		
		//Segundo: construir o sql.
		String sql = "INSERT INTO usuario(nome, login, senha) VALUES (?,?,?)";
		
		//Terceiro: pega o Statement.
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
			//Quarto: executo o Statement.
			preparador.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}

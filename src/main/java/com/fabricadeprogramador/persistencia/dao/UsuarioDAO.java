package com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.management.RuntimeErrorException;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class UsuarioDAO {

	// Primeiro: pega a conexao.
	Connection con = ConexaoFactory.getConexao();

	public void cadastrarUsuario(Usuario usu) {

		// Segundo: construir o sql.
		String sql = "INSERT INTO usuario(nome, login, senha) VALUES (?,?,md5(?))";

		// Terceiro: pega o Statement.
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());

			// Quarto: executo o Statement.
			preparador.execute();

		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao cadastrar o Usuario!!", ex);
		}
	}

	public void alterar(Usuario usu) {

		// Montar o sql
		String sql = "UPDATE usuario SET nome=?, login=?, senha=md5(?) WHERE id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			// Pegar o Statement
			
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());

			// Executa o SQL
			preparador.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao cadastrar o Usuario!!", e);
			
		}

	}

	public void excluir(Integer id) {

		// Montar o SQL
		String sql = "DELETE FROM usuario WHERE id=?";

		// Pegando o statement
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			// Setando o id
			preparador.setInt(1, id);

			// executar
			preparador.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao deletar no banco", e);
		}

	}

	public void salvar(Usuario usu) {
		if (usu.getId() != null && usu.getId() > 0) {
			alterar(usu);
		} else {
			cadastrarUsuario(usu);
		}
	}

	public Usuario buscarPoId(Integer id) {

		// sql
		String sql = "SELECT * FROM usuario WHERE id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setInt(1, id);
			ResultSet result = preparador.executeQuery();

			if (result.next()) {
				
				// instancia do usuario
				Usuario usuRetorno = new Usuario();
				
				// retornando usuario
				usuRetorno.setId(result.getInt("id"));
				usuRetorno.setNome(result.getString("nome"));
				usuRetorno.setLogin(result.getString("login"));
				usuRetorno.setSenha(result.getString("senha"));

				// Retorna meu usuario preenchido
				return usuRetorno;

			} else {
				System.out.println("Não existe usuario");
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar no banco", e);
		}
	}
	public List<Usuario> buscaTodos(){
		
		//Montar SQL
		String sql = "SELECT * FROM usuario order by id asc";
		
		//Pegar Statement
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			List<Usuario> listaRetorno = new ArrayList<Usuario>();
			
			ResultSet result = preparador.executeQuery();
			
			while(result.next()){
				
				//Estancia a classe usuario
				Usuario usu = new Usuario();
				
				usu.setId(result.getInt("ID"));
				usu.setNome(result.getString("nome"));
				usu.setLogin(result.getString("login"));
				usu.setSenha(result.getString("senha"));
				
				//adicionar o usuario na lista
				listaRetorno.add(usu);
			}
			return listaRetorno;
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar no banco", e);
			
		}	
	}
	
public Usuario autenticar(Usuario usu){
		
		//sql
		String sql = "SELECT * FROM usuario WHERE login=? and senha=md5(?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql))
		{
			
			preparador.setString(1, usu.getLogin());
			preparador.setString(2, usu.getSenha());
			
			ResultSet result = preparador.executeQuery();
			if(result.next()){
				
				Usuario retorno = new Usuario();
				retorno.setId(result.getInt("id"));
				retorno.setNome(result.getString("nome"));
				retorno.setLogin(result.getString("login"));
				retorno.setSenha(result.getString("senha"));
				
				return retorno;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao autenticar!", e);
		}
	}

}

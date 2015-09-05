package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

public interface UsuarioDAO {
	
	public void cadastrar(Usuario usuario) throws DAOException;
	
	public void alterar(Usuario usuario) throws DAOException;
	
	public void excluir(Integer id) throws DAOException;
	
	public void salvar(Usuario usuario) throws DAOException;
	
	public Usuario buscarPorId(Integer id) throws DAOException;
	
	public List<Usuario> buscarTodos() throws DAOException;
	
	public Usuario autenticar(Usuario usu) throws DAOException;

	Usuario buscarPorLogin(String login) throws DAOException;

}
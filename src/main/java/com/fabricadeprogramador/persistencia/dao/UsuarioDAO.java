package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import com.fabricadeprogramador.persistencia.entidade.Usuario;

public interface UsuarioDAO {
	
	public void cadastrar(Usuario usuario);
	
	public void alterar(Usuario usuario);
	
	public void excluir(Integer id);
	
	public void salvar(Usuario usuario);
	
	public Usuario buscarPoId(Integer id);
	
	public List<Usuario> buscarTodos();
	
	public Usuario autenticar(Usuario usu);

}
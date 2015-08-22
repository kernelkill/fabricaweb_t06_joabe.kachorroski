package com.fabricadeprogramador.persistencia.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.fabricadeprogramador.persistencia.jpa.JPAUtil;

@Repository("Spring")
public class UsuarioDAOJPA implements UsuarioDAO{
	
	EntityManager em = JPAUtil.getEntityManager();
	
	@Override
	public void cadastrar(Usuario usuario) {
		
		//Começar a transação
		em.getTransaction().begin();
		//Persisti o usuario
		em.persist(usuario);
		//commit
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void alterar(Usuario usuario) {
		
		em.getTransaction().begin();
		
		em.merge(usuario);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void excluir(Integer id) {
		
		em.getTransaction().commit();
		
		//Find
		Usuario usuarioRemove = em.find(Usuario.class, id);
		
		//remove
		em.remove(usuarioRemove);
		
		em.getTransaction().begin();
		em.close();
		
	}

	@Override
	public void salvar(Usuario usuario) {
		
		em.getTransaction().begin();
		
		em.merge(usuario);
		
		em.getTransaction().commit();
		em.close();

		
	}

	@Override
	public Usuario buscarPoId(Integer id) {
		
		Usuario usuarioRetorno = em.find(Usuario.class, id);
		return usuarioRetorno;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario autenticar(Usuario usu) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

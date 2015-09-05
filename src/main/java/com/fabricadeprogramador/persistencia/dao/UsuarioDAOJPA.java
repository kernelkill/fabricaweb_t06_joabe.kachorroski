package com.fabricadeprogramador.persistencia.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@Repository("Spring")
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public void cadastrar(Usuario usuario) throws DAOException {
		try {
			// Persisti o usuario
			em.persist(usuario);
		} catch (IllegalArgumentException ex) {
			throw new DAOException("Verifique se a classe é uma entidade JPA", ex);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro! Corrija! Seu Burro!", e);
		}

	}

	@Transactional
	public void alterar(Usuario usuario) throws DAOException {
		try {
			// merge
			em.merge(usuario);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro!", e);
		}
	}

	@Transactional
	public void salvar(Usuario usuario) throws DAOException {
		try {
			// merge
			em.merge(usuario);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro!", e);
		}
	}

	@Transactional
	public void excluir(Integer id) throws DAOException {
		try {
			// find
			Usuario usuarioRemove = em.find(Usuario.class, id);

			// remove
			em.remove(usuarioRemove);
		} catch (Exception e) {
			throw new DAOException("Ocorreu um erro!", e);
		}

	}

	@Override
	public Usuario buscarPorId(Integer id) throws DAOException{
		
		Usuario usaurioRetorno = null;
		
		try{
			usaurioRetorno = em.find(Usuario.class, id);
			
		}catch(NoResultException ex){
			throw new DAOException("Nenhum resultado encontrado!", ex);
		}catch (Exception e) {
			throw new DAOException("Ocorreu um erro genérico", e);
		}finally{
			return usaurioRetorno;
		}
	}

	@Override
	public List<Usuario> buscarTodos() throws DAOException{

		List<Usuario> usuarios = null;
		try{
			// sql (jpql)
			String jpql = "select u from Usuario u";
			Query query = em.createQuery(jpql);
			usuarios = query.getResultList();
			
		}catch(NoResultException ex){
			throw new DAOException("Nenhum resultado encontrado!", ex);
		}catch(Exception e){
			throw new DAOException("Ocorreu um erro genérico!", e);
		}finally {
			return usuarios;
		}
		
	}

	@Override
	public Usuario autenticar(Usuario usuario) {
		
		//Objeto de retorno
		Usuario usuarioAutenticado = null;
		try{
			
			// sql (jpql)
			String jpql = "select u from Usuario u where u.login=:pLogin and u.senha=:pSenha";
			Query query = em.createQuery(jpql);
			
			//setar os parametros
			query.setParameter("pLogin", usuario.getLogin());
			query.setParameter("pSenha", usuario.getSenha());
			
			//Pegar o retorna da query
			usuarioAutenticado = (Usuario)query.getSingleResult();
			
		}catch(NonUniqueResultException ex){
			throw new DAOException("Mais de um resultado foi encontrado!", ex);
		}catch(NoResultException ex){
			throw new DAOException("Nenhum resultado encontrado!", ex);
		}catch(Exception e){
			throw new DAOException("Ocorreu um erro genérico!", e);
		}finally {
			return usuarioAutenticado;
		}
	}

	@Override
	public Usuario buscarPorLogin(String login) throws DAOException {
		
		Usuario usuarioBuscado = null;
		
		try{
			//JPQL
			String jpql = "select u from Usuario u where u.login=:pLogin";
			
			//montar a query
			Query query = em.createQuery(jpql);
			//setar os parametros
			query.setParameter("pLogin", login);
			
			//pegar o resultatdo
			usuarioBuscado = (Usuario)query.getSingleResult();
		}catch(NonUniqueResultException e){
			throw new DAOException("Mais de um usuário foi encontrado!", e);
		}catch(NoResultException e){
			throw new DAOException("Nenhum usuário foi encontrado!", e);
		}catch(Exception e){
			throw new DAOException("Ocorreu um erro genérico!", e);
		}finally {
			return usuarioBuscado;
		}
	}

}



package cjweb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.dao.exception.DAOException;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UsuarioDAOJPATeste {

	@Qualifier("Spring")
	@Autowired
	UsuarioDAO dao;
	
	public Usuario getUsuario() {
		// Istanciando o usuário para ser persistido
		Usuario usu = new Usuario();
		usu.setNome("Antonio");
		usu.setLogin("toinho");
		usu.setSenha("123");
		
		return getUsuario();
	}

	public void testeCadastrar() {
		// cadastrar
		try {
			dao.cadastrar(getUsuario());
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testeBuscarTodos(){
		//metodo buscarTodos do DAO
		List<Usuario> usuarios = null;
		try {
			usuarios = dao.buscarTodos();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		for (Usuario usu : usuarios) {
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println(usu.toString());
			System.out.println("+++++++++++++++++++++++++++++");
		}
	}
}
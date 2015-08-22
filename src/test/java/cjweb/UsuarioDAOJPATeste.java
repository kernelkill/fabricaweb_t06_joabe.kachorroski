package cjweb;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJPA;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAOJPATeste{
	
	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAOJPA();
		
		//Istanciando o usuário para ser persistido
		Usuario usu = new Usuario();
		usu.setNome("Antonio");
		usu.setLogin("toinho");
		usu.setSenha("123");
		
		//cadastrar
		dao.cadastrar(usu);
		
		
	}
}
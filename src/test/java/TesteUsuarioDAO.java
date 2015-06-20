import java.util.Scanner;

import com.fabricadeprogramador.persistencia.entidade.Usuario;
import com.frabricadeprogramador.presistencia.dao.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		Usuario usu = new Usuario();

		System.out.println("Digite o Nome do Usuario: ");
		usu.setNome(teclado.nextLine());

		System.out.println("Digite o Login do Usuario: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Digite a Senha do Usuario: ");
		usu.setSenha(teclado.nextLine());

		teclado.close();

		// Instancia do UsuarioDAO.
		UsuarioDAO dao = new UsuarioDAO();

		// Invocar o metodo cadastrarUsuario.
		dao.cadastrarUsuario(usu);
		
		System.out.println("Usuario Cadastrado com Sucesso!!!");

	}

	public static void testaCadastrar() {
		// Criar um usuario para ser persistido
		Usuario usu = new Usuario();
		usu.setNome("Zé");
		usu.setLogin("zeze");
		usu.setSenha("123");

		// Instancia do UsuarioDAO.
		UsuarioDAO dao = new UsuarioDAO();

		// Invocar o metodo cadastrarUsuario.
		dao.cadastrarUsuario(usu);

	}

}

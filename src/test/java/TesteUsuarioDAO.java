import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		
		//Instancia Classe Teclado
		Scanner teclado = new Scanner(System.in);
		
		//Instancia Classe usuario
		Usuario usu = new Usuario();
		
		//Instancia do DAO
		UsuarioDAO dao =new UsuarioDAO();
		
		//CadastrarUsuario(usu, teclado, dao);
		//AterarUsuario(usu, teclado, dao);
		//ExcluirUsuario(teclado, dao);
		//salvarUsuario(usu, teclado, dao);
		//buscaUsuarioPorId(teclado, dao);
		buscarTodos(dao);
		teclado.close();	
	}
	
	public static void CadastrarUsuario(Usuario usu, Scanner teclado, UsuarioDAO dao){
		
		System.out.println("Digite o Nome do Usuario: ");
		usu.setNome(teclado.nextLine());

		System.out.println("Digite o Login do Usuario: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Digite a Senha do Usuario: ");
		usu.setSenha(teclado.nextLine());
		
		// Invocar o metodo cadastrarUsuario.
		dao.cadastrarUsuario(usu);
		
		//System.out.println("Usuario Cadastrado com Sucesso!!!");
		System.out.println("Usuario Cadastrado com Sucesso!!!");
	}
	
	public static void AterarUsuario(Usuario usu, Scanner teclado, UsuarioDAO dao){
		
		System.out.println("Digite o ID do usuario a ser Alterado: ");
		usu.setId(teclado.nextInt());
		teclado.nextLine();
		
		System.out.println("Digite o Nome do Usuario: ");
		usu.setNome(teclado.nextLine());

		System.out.println("Digite o Login do Usuario: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Digite a Senha do Usuario: ");
		usu.setSenha(teclado.nextLine());
		
		// Invocar o metodo AlterarUsuario.
		dao.alterar(usu);
		
		//System.out.println("Usuario Cadastrado com Sucesso!!!");
		System.out.println("Usuario Alterado com Sucesso!!!");
		
	}
	
	public static void ExcluirUsuario(Scanner teclado, UsuarioDAO dao){
		
		System.out.println("Digite o ID do Usuario a ser exluido: ");
		Integer id = teclado.nextInt();
		
		//invocar metodo exluir
		dao.excluir(id);
		System.out.println("Usuario com o id " + id + " exluido com sucesso!");
	}
	
	public static void salvarUsuario(Usuario usu, Scanner teclado, UsuarioDAO dao){
		
		System.out.println("Digite o ID do usuario a ser Alterado: ");
		usu.setId(teclado.nextInt());
		teclado.nextLine();
		
		System.out.println("Digite o Nome do Usuario: ");
		usu.setNome(teclado.nextLine());

		System.out.println("Digite o Login do Usuario: ");
		usu.setLogin(teclado.nextLine());

		System.out.println("Digite a Senha do Usuario: ");
		usu.setSenha(teclado.nextLine());
		
		// Invocar o metodo AlterarUsuario.
		dao.salvar(usu);
		
		//System.out.println("Usuario Cadastrado com Sucesso!!!");
		System.out.println("Usuario salvo com Sucesso!!!");
		
	}
	
	public static void buscaUsuarioPorId(Scanner teclado, UsuarioDAO dao){
		
		System.out.println("Digite o ID do usuario a ser buscado: ");
		Integer id = teclado.nextInt();
		
		//Invocar o metodo excluir
		Usuario usuRetornado = dao.buscarPoId(id);
		
		if(usuRetornado != null){
			//Imprimindo o usuario de retorno
			System.out.println("ID: " + usuRetornado.getId());
			System.out.println("Nome: " + usuRetornado.getNome());
			System.out.println("Login: " + usuRetornado.getLogin());
			System.out.println("Senha: " + usuRetornado.getSenha());
		}
	}
	public static void buscarTodos(UsuarioDAO dao){
		
		//invocar o metodo buscarTodos
		List<Usuario> lista = dao.buscaTodos();
		
		//imprimir
		for(Usuario usu : lista){
			
			System.out.println();
			System.out.println("ID: " + usu.getId());
			System.out.println("Nome: " + usu.getNome());
			System.out.println("Login: " + usu.getLogin());
			System.out.println("Senha: " + usu.getSenha());
			
			System.out.println();
		}
	}
}

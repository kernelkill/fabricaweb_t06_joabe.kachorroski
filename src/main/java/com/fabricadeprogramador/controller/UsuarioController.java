package com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAO;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@WebServlet("/usucontroller")
public class UsuarioController extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Chamando o init...");

		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Pegando os dados da requisição
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		// Instanciando o usuario
		Usuario usu = new Usuario();
		// Instanciando o UsuairioDAO
		UsuarioDAO dao = new UsuarioDAO();

		if (acao.equalsIgnoreCase("cad") || acao.equalsIgnoreCase("alt")) {

			usu.setNome(nome);
			usu.setLogin(login);
			usu.setSenha(senha);

			dao.cadastrarUsuario(usu);
			resp.getWriter().print("Usuario Cadastrado com Sucesso!");

		} else if (acao.equalsIgnoreCase("alt")) {

			if (id != null && !id.isEmpty() && Integer.parseInt(id) > 0) {

				usu.setId(Integer.parseInt(id));
				usu.setNome(nome);
				usu.setLogin(login);
				usu.setSenha(senha);

				dao.alterar(usu);
			} else {
				resp.getWriter().print("<h1>ID incorreto</h1>");
			}

		} else if (acao.equalsIgnoreCase("form")) {

			// dao.excluir(Integer.parseInt(id));
			// resp.sendRedirect("WEB-INF/formusu.jsp");
			req.getRequestDispatcher("WEB-INF/formusu.jsp").forward(req, resp);

		} else if (acao.equalsIgnoreCase("list")) {

			List<Usuario> listaUsuario = dao.buscaTodos();

			req.setAttribute("lista", listaUsuario);

			req.getRequestDispatcher("WEB-INF/listausu.jsp").forward(req, resp);

		}

		//System.out.println("Cadastrado com Sucesso!");
		//
		//System.out.println("\n---------------Cadastrando Coisas-------------\n");
		//System.out.println("CPF: " + cpf);
		//System.out.println("Nome :" + nome);
		//System.out.println("Login: " + login);
		//System.out.println("Senha: " + senha);
		//System.out.println("Chamando o doGet");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String acao = req.getParameter("acao");
		// Instanciando o usuario
		Usuario usu = new Usuario();
		// Instanciando o UsuairioDAO
		UsuarioDAO dao = new UsuarioDAO();

		if (acao.equalsIgnoreCase("cad")) {

			// Pega os dados da tela
			String nome = req.getParameter("nome");
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			String id = req.getParameter("id");

			if (id != null && !id.isEmpty() && Integer.parseInt(id) > 0) {

				// Seta atributos pego na instancia de Usuario
				usu.setId(Integer.parseInt(id));
				usu.setNome(nome);
				usu.setLogin(login);
				usu.setSenha(senha);

				dao.alterar(usu);

				resp.getWriter().print(
						"<h1>Usuario: " + usu.getId()
								+ " alterado com Sucesso!</h1>");
				
				resp.sendRedirect("usucontroller?acao=list");

			} else {

				usu.setNome(nome);
				usu.setLogin(login);
				usu.setSenha(senha);

				dao.cadastrarUsuario(usu);
				resp.getWriter().print(
						"<h1>Usuario " + usu.getNome()
								+ " Cadastrado com Sucesso!</h1>");
				
				resp.sendRedirect("usucontroller?acao=list");

			}

		} else if (acao.equalsIgnoreCase("exc")) {

			String[] ids = req.getParameterValues("id");

			for (String id : ids) {

				dao.excluir(Integer.parseInt(id));

			}
			
			resp.sendRedirect("usucontroller?acao=list");
		}

	}

	@Override
	public void destroy() {

		super.destroy();
	}

}

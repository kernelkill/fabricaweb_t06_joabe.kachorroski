package com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJDBC;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@WebServlet("/autenticaController.do")
public class AutenticaController extends HttpServlet{
	
	/**
	 * 
	 */
	
	UsuarioDAOJDBC dao = new UsuarioDAOJDBC();
	
	private static final long serialVersionUID = 1L;

	public AutenticaController(){
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//pega a acao da requisição
		String acao = req.getParameter("acao");
		
		if (acao.equalsIgnoreCase("pagina-principal")) {
			
			//redirecionar para index.jsp
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

			
		}else if(acao.equalsIgnoreCase("sair")){
			
			HttpSession session = req.getSession(false);
			session.invalidate();
			
			//voltar para atela de login
			resp.sendRedirect("login.jsp");	
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Validar usuario
		//Peguei os parametros "login" e "senha"
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//Instancia um usuario
		Usuario usuAutenticar = new Usuario();
		usuAutenticar.setLogin(login);
		usuAutenticar.setSenha(senha);
		
		//Chamar o Metodo autenticar o dao
		Usuario usuAutenticado = dao.autenticar(usuAutenticar);
		
		//Verificar se o usuAutenticado é nulo ou nao
		if (usuAutenticado != null) {
			
			//Criar usu sessao para p usuario autenticado
			HttpSession session = req.getSession();
			
			//Colocar usuario validado dentr da sessao
			session.setAttribute("usuario", usuAutenticado);
			
			//Setar um tempo limite 
			session.setMaxInactiveInterval(300);
			
			//Se o usuario for realmente autenticado -> manda para o index.jsp
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}else{
			//Se o usuario nao for realmente autenticado -> manda para o login.jsp
			resp.sendRedirect("login.jsp");
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}

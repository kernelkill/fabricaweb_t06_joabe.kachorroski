package com.fabricadeprogramador.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import com.fabricadeprogramador.persistencia.entidade.Usuario;


@SuppressWarnings("unused")
//@WebFilter(dispatcherTypes={DispatcherType.REQUEST}, urlPatterns={"/*"})
public class FiltroAutenticacao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//Validar Usuario
		
		//Pegar a Sessao
		HttpSession session = req.getSession();
		
		//Peguei a url
		String url = req.getRequestURI();
		
		int loginjsp = url.lastIndexOf("/login.jsp");
		int autenticaController = url.lastIndexOf("/autenticaController");
		
		if (session.getAttribute("usuario") != null  || loginjsp > -1 || autenticaController > -1 ) {
			
			//Liberar
			chain.doFilter(request, response);
		}else{
			
			//Volto o usuario para a tela de login
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	public void destroy() {
		
		
	}

}

package com.fabricadeprogramador.controller;

import javax.faces.bean.ManagedBean;

import com.fabricadeprogramador.persistencia.entidade.Usuario;


@ManagedBean
public class UsuarioJSFController {
	
	private Usuario usuario;
	
	public UsuarioJSFController(){
		usuario = new Usuario();
	}
	
	public void salvar(){
		System.out.println(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

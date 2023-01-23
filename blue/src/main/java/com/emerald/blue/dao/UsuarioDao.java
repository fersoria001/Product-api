package com.emerald.blue.dao;

import java.util.List;

import com.emerald.blue.models.Usuario;

public interface UsuarioDao {

	public List<Usuario> getUsuarios();
	public void eliminarUsuario(Long id);
	public void registrarUsuario(Usuario usuario);
	public Usuario verificarUsuario(Usuario usuario);
}


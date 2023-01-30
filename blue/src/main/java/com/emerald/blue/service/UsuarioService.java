package com.emerald.blue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.blue.models.Usuario;
import com.emerald.blue.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> getUsuarios()
	{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarioRepository.findAll().forEach(usuarios1 -> usuarios.add(usuarios1));
		return usuarios;
	}
	
	public Usuario getUsuarioById(Integer id)
	{
		return usuarioRepository.findById(id).get();
	}
	
	public void saveUsuario(Usuario usuario)
	{
		usuarioRepository.save(usuario);
	}
	
	public void deleteUsuario(Integer id)
	{
		usuarioRepository.deleteById(id);
	}
	
	public void updateUsuario(Usuario usuario, Integer usuarioId)
	{
		usuarioRepository.save(usuario);
	}
}


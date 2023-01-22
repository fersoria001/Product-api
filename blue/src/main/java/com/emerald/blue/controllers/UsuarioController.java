package com.emerald.blue.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.emerald.blue.dao.UsuarioDao;
import com.emerald.blue.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
@RequestMapping(value = "usuarios", method = RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return usuarioDao.getUsuarios();
	}

@RequestMapping(value = "usuarios/{id}", method = RequestMethod.DELETE)
public void eliminarUsuario(@PathVariable Long id){
	usuarioDao.eliminarUsuario(id);
}
	@PostMapping("/usuarios")
	public void registrarUsuario(@RequestBody Usuario usuario){
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
		usuario.setPassword(hash);
		usuarioDao.registrarUsuario(usuario);
}
}

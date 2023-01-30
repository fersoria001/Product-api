package com.emerald.blue.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.emerald.blue.models.Usuario;
import com.emerald.blue.service.UsuarioService;
import com.emerald.blue.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	
	@CrossOrigin(origins = "http://localhost:5173")
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
		public List<Usuario> getUsuarios(){
			return usuarioService.getUsuarios();
	}
	
	
	@CrossOrigin(origins = "http://localhost:5173")
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
		public void eliminarUsuario(@PathVariable Integer id){
		 usuarioService.deleteUsuario(id);
		}
	
	@CrossOrigin(origins = "http://localhost:5173")
		@PostMapping("/usuarios")
		public void registrarUsuario(@RequestBody Usuario usuario){
			usuarioService.saveUsuario(usuario);
	}
	@CrossOrigin(origins = "http://localhost:5173")
		@PutMapping("/usuarios")
		public Usuario modificarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
			usuarioService.updateUsuario(usuario, id);
			return usuario;
		}
	
}

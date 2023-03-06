package com.emerald.blue.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.emerald.blue.models.Usuario;
import com.emerald.blue.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
		public List<Usuario> getUsuarios(){
			return usuarioService.getUsuarios();
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
		public void eliminarUsuario(@PathVariable Integer id){
		 usuarioService.deleteUsuario(id);
		}
	
	@CrossOrigin(origins = "*")
		@PostMapping("/usuarios")
		public void registrarUsuario(@RequestBody Usuario usuario){
			usuarioService.saveUsuario(usuario);
	}
	@CrossOrigin(origins = "*")
		@PutMapping("/usuario")
		public Usuario modificarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
			usuarioService.updateUsuario(usuario, id);
			return usuario;
		}
	
}

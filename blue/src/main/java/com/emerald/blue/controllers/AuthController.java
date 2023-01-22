package com.emerald.blue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emerald.blue.dao.UsuarioDao;
import com.emerald.blue.models.Usuario;

@RestController
public class AuthController {
	@Autowired
	private UsuarioDao usuarioDao;
	
	@PostMapping("/login")
	public String login(@RequestBody Usuario usuario){
		if(usuarioDao.verificarUsuario(usuario)) {
			return "OK";
		}
		else {
			return "FAIL";
		}
}
}

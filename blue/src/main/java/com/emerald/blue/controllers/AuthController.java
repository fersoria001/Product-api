package com.emerald.blue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emerald.blue.dao.UsuarioDao;
import com.emerald.blue.models.Usuario;
import com.emerald.blue.utils.JWTUtil;



@RestController
public class AuthController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@PostMapping("/login")
	public String login(@RequestBody Usuario usuario){
		
		Usuario usuarioLogeado = usuarioDao.verificarUsuario(usuario);
		if(usuarioLogeado != null) {
			String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogeado.getId()), usuarioLogeado.getEmail());
			return tokenJwt;
		}
		else {
			return "FAIL";
		}
}
}

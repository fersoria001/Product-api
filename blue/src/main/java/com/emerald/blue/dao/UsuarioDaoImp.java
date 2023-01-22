package com.emerald.blue.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emerald.blue.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Usuario> getUsuarios(){
		String query = "FROM Usuario";
		return entityManager.createQuery(query).getResultList();
	}
	@Override
	public void eliminarUsuario(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
	
	}
	@Override
	public void registrarUsuario(Usuario usuario) {
		entityManager.merge(usuario);
	}
	@Override
	public boolean verificarUsuario(Usuario usuario) {
		String query = "FROM Usuario WHERE email = :email";
		List<Usuario> lista = entityManager.createQuery(query)
				.setParameter("email",usuario.getEmail())
		 		.getResultList();
		if(lista.isEmpty()) {
			return false;
		}
		String passwordhashed = lista.get(0).getPassword();
		
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		return argon2.verify(passwordhashed, usuario.getPassword());
	}
	

	
}

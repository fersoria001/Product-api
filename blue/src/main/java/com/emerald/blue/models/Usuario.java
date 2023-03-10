package com.emerald.blue.models;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name= "usuarios")
public class Usuario {
	@Column(name= "id")
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name= "nombre")
	private String nombre;
	@Column(name= "apellido")
	private String apellido;
	@Column(name="email")
	private String email;
	@Column(name= "password")
	private String password;
	@Column(name= "telefono")
	private Integer telefono;
	@Column(name="enabled")
	private boolean enabled;
	private boolean tokenExpired;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(
					name = "usuarios_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))

	private Collection<Role> roles;
	public Usuario() {}

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", telefono=" + telefono +
				", enabled=" + enabled +
				", tokenExpired=" + tokenExpired +
				", roles=" + roles +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return id.equals(usuario.id) && Objects.equals(email, usuario.email) && Objects.equals(telefono, usuario.telefono);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, telefono);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}



	public boolean isEnabled() {
		return enabled;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setEnabled(boolean b) {
		this.enabled = b;
	}
}
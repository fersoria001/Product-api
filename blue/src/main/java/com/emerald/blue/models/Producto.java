package com.emerald.blue.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "productos")
@Entity
public class Producto {
	
	
	@Column(name= "id")
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name= "nombre")
	private String nombre;
	@Column(name= "descripcion")
	private String descripcion;
	@Column(name= "imgUrl")
	private String imgUrl;
	@Column(name= "precio")
	private Integer precio;
	
	public Producto() {}
	
	public Producto(String nombre, String descripcion, String imgUrl, Integer price) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imgUrl = imgUrl;
		this.precio = price;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, imgUrl, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
}

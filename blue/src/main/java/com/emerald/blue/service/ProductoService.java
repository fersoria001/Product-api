package com.emerald.blue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.blue.models.Producto;
import com.emerald.blue.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> getProductos()
	{
		List<Producto> productos = new ArrayList<Producto>();
		productoRepository.findAll().forEach(productos1 -> productos.add(productos1));
		return productos;
	}
	
	public Producto getProductoById(Integer id)
	{
		return productoRepository.findById(id).get();
	}
	
	public void saveProducto(Producto producto)
	{
		productoRepository.save(producto);
	}
	
	public void deleteProducto(Integer id)
	{
		productoRepository.deleteById(id);
	}
	
	public void updateProducto(Producto producto, Integer productoId)
	{
		productoRepository.save(producto);
	}
}

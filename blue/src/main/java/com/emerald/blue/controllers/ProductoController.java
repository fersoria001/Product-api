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
import com.emerald.blue.models.Producto;
import com.emerald.blue.repositories.ProductoRepository;
import com.emerald.blue.service.ProductoService;


@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/producto", method = RequestMethod.GET)
		public List<Producto> getProductos(){
			return productoService.getProductos();
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.DELETE)
		public void eliminarProducto(@PathVariable("productoId") Integer id){
			productoService.deleteProducto(id);
	}
	
	
	@CrossOrigin(origins = "*")
		@PostMapping("/productos")
		public Integer guardarProducto(@RequestBody Producto producto){
			productoService.saveProducto(producto);
			return producto.getId();
	}
	
	
	@CrossOrigin(origins = "*")
		@PutMapping("/productos")
		public Producto modificarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
			productoService.updateProducto(producto, id);
			return producto;
	}
}

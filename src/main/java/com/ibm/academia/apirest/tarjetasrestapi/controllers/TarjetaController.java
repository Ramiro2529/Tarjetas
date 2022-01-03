package com.ibm.academia.apirest.tarjetasrestapi.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.tarjetasrestapi.entities.Tarjeta;
import com.ibm.academia.apirest.tarjetasrestapi.exceptions.NotFoundException;
import com.ibm.academia.apirest.tarjetasrestapi.services.TarjetaDao;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {
	
	@Autowired
	private TarjetaDao tarjetaDao;
	
	
	/**
	 * Método que permite todos los tipos de tarjeta y parametros necesarios para solicitarla
	 * 
	 * */
	@GetMapping("/todos")
	public Iterable<Tarjeta> mostrarTodos(){
		
		
		
		return tarjetaDao.buscarTodos();
		
	}
	
	/**
	 * Método que permite saber que tipo de tareta puede solicitar un usuario
	 * @param preferencia del usuario
	 * @param salarioMensual salario mensual del usuario
	 * @param age edad del usuario
	 *
	 */
	
	@GetMapping("/filtro")
	public ResponseEntity<List<Tarjeta>> busquedaPorFiltro(@RequestParam(name = "preferencia", required = true) String preferencia, 
			@RequestParam(name = "salarioMensual", required = true) BigDecimal salarioMensual, 
			@RequestParam(name = "edad", required = true) Integer edad){
		
		Optional<List<Tarjeta>> tarjetaUsuario= tarjetaDao.filtro(preferencia, salarioMensual, edad);
		
		if(tarjetaUsuario.isEmpty()) {
			throw new NotFoundException("Lo sentimos, no se encontró ninguna tarjeta con base a los parametros que diste");
			
			
				
		
		}
		
				return ResponseEntity.ok(tarjetaUsuario.get());
		
	}
	
	
	
	{
		
	}

}

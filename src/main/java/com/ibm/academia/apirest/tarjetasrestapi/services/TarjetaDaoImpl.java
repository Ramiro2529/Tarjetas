package com.ibm.academia.apirest.tarjetasrestapi.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.tarjetasrestapi.entities.Tarjeta;
import com.ibm.academia.apirest.tarjetasrestapi.repositories.TarjetaRepository;

@Service
public class TarjetaDaoImpl implements TarjetaDao{
	
	@Autowired
	private TarjetaRepository tarjetaRepo;

	
	@Override
	public Iterable<Tarjeta> buscarTodos() {
		
		
		return tarjetaRepo.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Optional<List<Tarjeta>> filtro(String preferencia, BigDecimal salarioMensual, Integer edad) {
	List <Tarjeta> filtroTarjeta = tarjetaRepo.encotrarFiltroTarjeta(preferencia, salarioMensual, edad);
	
	
	if(filtroTarjeta !=null && !filtroTarjeta.isEmpty()) {
		return Optional.of(filtroTarjeta);
	}
	
	return Optional.empty();
	
	}



	

}

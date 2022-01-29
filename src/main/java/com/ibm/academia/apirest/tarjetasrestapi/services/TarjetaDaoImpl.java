package com.ibm.academia.apirest.tarjetasrestapi.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.tarjetasrestapi.entities.Tarjeta;
import com.ibm.academia.apirest.tarjetasrestapi.exceptions.NotFoundException;
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
	public Optional<List<Tarjeta>> filtro(String preferencia, BigDecimal salarioMensual, Integer edad) throws NotFoundException {
	List <Tarjeta> filtroTarjeta = tarjetaRepo.encotrarFiltroTarjeta(preferencia, salarioMensual, edad);
	BigDecimal lowSalary= new BigDecimal(7000);
	
	
	if(filtroTarjeta !=null && !filtroTarjeta.isEmpty()) {
		return Optional.of(filtroTarjeta);
	}
	if (salarioMensual.compareTo(lowSalary)<-0) {
		 throw new NotFoundException("No existen tarjetas con un salario menor a 7000, por favor vuelve a ingresar tu salario");
	} if(edad<18) {
		throw new NotFoundException("No existen tarjetas para menor de edad, por favor vuelve a ingresar tu edad");
	} if(edad>75) {
		throw new NotFoundException("No existen tarjetas para mayores de edad, por favor vuelve a ingresar tu edad");
	}
	
	return Optional.empty();
	
	}



	

}

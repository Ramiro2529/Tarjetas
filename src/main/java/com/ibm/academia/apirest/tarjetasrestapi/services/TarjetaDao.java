package com.ibm.academia.apirest.tarjetasrestapi.services;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.ibm.academia.apirest.tarjetasrestapi.entities.Tarjeta;

public interface TarjetaDao {

	public Iterable <Tarjeta> buscarTodos();
	Optional<List<Tarjeta>> filtro(String preferencia, BigDecimal salarioMensual, Integer edad);
}

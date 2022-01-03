package com.ibm.academia.apirest.tarjetasrestapi.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.tarjetasrestapi.entities.Tarjeta;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer>{
	
	@Query("select c from Tarjeta c where c.preferencia = ?1 and ?2 between salario_minimo and salario_maximo and ?3 between edad_minima and edad_maxima")
	public List<Tarjeta> encotrarFiltroTarjeta(String preferencia, BigDecimal salario, Integer edad);

}

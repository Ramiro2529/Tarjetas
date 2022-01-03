package com.ibm.academia.apirest.tarjetasrestapi.entities;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tarjetas")
public class Tarjeta implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name="preferencia")
	private String preferencia;
	
	@Column(name="salario_minimo", nullable = false)
	private BigDecimal salarioMinimo;
	
	@Column(name="salario_maximo",nullable = false)
	private BigDecimal salarioMaximo;
	
	@Column(name="edad_minima",nullable = false)
	private Integer edadMinima;
	
	@Column(name="edad_maxima",nullable = false)
	private Integer edadMaxima;
	
	public Tarjeta() {
		
	}
	
	

	public Tarjeta(Integer id, String nombre, String preferencia, BigDecimal salarioMinimo, BigDecimal salarioMaximo,
			Integer edadMinima, Integer edadMaxima) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
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

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public BigDecimal getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(BigDecimal salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public BigDecimal getSalarioMaximo() {
		return salarioMaximo;
	}

	public void setSalarioMaximo(BigDecimal salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	public Integer getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}

	public Integer getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(Integer edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	
	
	
	
	
	
	
	

}
  
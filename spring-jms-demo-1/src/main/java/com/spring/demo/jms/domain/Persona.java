package com.spring.demo.jms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	public String id;
	public String nombreCompleto;
	public String genero;
	public Integer edad;
	public BigDecimal ingresoMensual;
	public Date fechaNacimiento;
	
	
	public Persona(){
		super();
	}
	
	public Persona(String id, String nombreCompleto, String genero, Integer edad, BigDecimal ingresoMensual,
			Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.genero = genero;
		this.edad = edad;
		this.ingresoMensual = ingresoMensual;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public BigDecimal getIngresoMensual() {
		return ingresoMensual;
	}
	public void setIngresoMensual(BigDecimal ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombreCompleto=" + nombreCompleto + ", genero=" + genero + ", edad=" + edad
				+ ", ingresoMensual=" + ingresoMensual + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
}

package com.webapp.hotel.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {

	 @DateTimeFormat(pattern = "yyyy-MM-dd")//Fortmateo(Comandante) de la fecha para que no se rompa con la view de Thymeleaft
	 private Date fechaInicio;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")//Fortmateo(Comandante) de la fecha para que no se rompa con la view de Thymeleaft
	 private Date fechaFin;
	 private int cantPersonas;
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	 
}

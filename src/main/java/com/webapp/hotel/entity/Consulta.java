package com.webapp.hotel.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {

	 @DateTimeFormat(pattern = "yyyy-MM-dd")//Fortmateo(Comandante) de la fecha para que no se rompa con la view de Thymeleaft
	 private LocalDate fechaInicio;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")//Fortmateo(Comandante) de la fecha para que no se rompa con la view de Thymeleaft
	 private LocalDate fechaFin;
	 private int cantPersonas;
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	 
}

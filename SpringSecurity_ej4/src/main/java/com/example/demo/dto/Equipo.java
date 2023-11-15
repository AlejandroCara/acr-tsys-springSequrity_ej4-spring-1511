package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo {
	
	@Id
	private String numSerie;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;
	
	@OneToMany
	@JoinColumn(name = "numSerie")
	private List<Reserva> reservas;
	
	public Equipo() {
		
	}

	public Equipo(String numSerie, String nombre, Facultad facultad, List<Reserva> reservas) {
		this.numSerie = numSerie;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "num_serie_equipo")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}

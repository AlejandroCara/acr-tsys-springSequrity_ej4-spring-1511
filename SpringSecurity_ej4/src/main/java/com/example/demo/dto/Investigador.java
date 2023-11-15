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
@Table(name="investigador")
public class Investigador {
	
	@Id
	private String dni;
	private String nomapels;

	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;
	
	@OneToMany
	@JoinColumn(name = "dni_investigador")
	private List<Reserva> reservas;
	
	public Investigador() {
		
	}

	public Investigador(String dni, String nomapels, Facultad facultad, List<Reserva> reservas) {
		this.dni = dni;
		this.nomapels = nomapels;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dni_investigador")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}

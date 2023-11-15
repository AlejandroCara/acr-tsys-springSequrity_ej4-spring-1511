package com.example.demo.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "num_serie_equipo")
	private Equipo equipo;
	
	@ManyToOne
	@JoinColumn(name = "dni_investigador")
	private Investigador investigador;
	
	@Temporal(TemporalType.DATE)
	private Date comienzo;
	
	@Temporal(TemporalType.DATE)
	private Date fin;
	
	public Reserva() {
		
	}

	public Reserva(int id, Equipo equipo, Investigador investigador, Date comienzo, Date fin) {
		this.id = id;
		this.equipo = equipo;
		this.investigador = investigador;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}
}

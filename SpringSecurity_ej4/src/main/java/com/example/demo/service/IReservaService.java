package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Reserva;

public interface IReservaService {
	// Metodos del CRUD
	public List<Reserva> listAll();

	public Reserva add(Reserva reserva);

	public Reserva getOne(int id);

	public Reserva update(Reserva reserva);

	public void eliminar(int id);
}

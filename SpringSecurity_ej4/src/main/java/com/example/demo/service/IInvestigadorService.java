package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigador;

public interface IInvestigadorService {
	// Metodos del CRUD
	public List<Investigador> listAll();

	public Investigador add(Investigador investigador);

	public Investigador getOne(String dni);

	public Investigador update(Investigador investigador);

	public void eliminar(String dni);
}

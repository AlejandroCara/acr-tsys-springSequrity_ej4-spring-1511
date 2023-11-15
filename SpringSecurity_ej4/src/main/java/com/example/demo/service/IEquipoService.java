package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipo;

public interface IEquipoService {

	// Metodos del CRUD
	public List<Equipo> listAll();

	public Equipo add(Equipo equipo);

	public Equipo getOne(String id);

	public Equipo update(Equipo equipo);

	public void eliminar(String id);
}

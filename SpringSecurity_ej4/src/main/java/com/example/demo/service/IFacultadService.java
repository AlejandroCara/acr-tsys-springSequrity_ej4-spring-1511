package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadService {
	// Metodos del CRUD
	public List<Facultad> listAll();

	public Facultad add(Facultad facultad);

	public Facultad getOne(int id);

	public Facultad update(Facultad facultad);

	public void eliminar(int id);
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;

@Service
public class EquipoService implements IEquipoService{

	@Autowired(required = true)
	IEquipoDAO iEquipoDAO;

	@Override
	public List<Equipo> listAll() {
		return iEquipoDAO.findAll();
	}

	@Override
	public Equipo add(Equipo equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public Equipo getOne(String id) {
		return iEquipoDAO.findById(id).get();
	}

	@Override
	public Equipo update(Equipo equipo) {
		return iEquipoDAO.save(equipo);
	}

	@Override
	public void eliminar(String id) {
		iEquipoDAO.deleteById(id);
	}
}

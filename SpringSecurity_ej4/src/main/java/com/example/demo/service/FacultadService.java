package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;

@Service
public class FacultadService implements IFacultadService{
	
	@Autowired(required = true)
	IFacultadDAO iFacultadDAO;

	@Override
	public List<Facultad> listAll() {
		return iFacultadDAO.findAll();
	}

	@Override
	public Facultad add(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public Facultad getOne(int id) {
		return iFacultadDAO.findById(id).get();
	}

	@Override
	public Facultad update(Facultad facultad) {
		return iFacultadDAO.save(facultad);
	}

	@Override
	public void eliminar(int id) {
		iFacultadDAO.deleteById(id);
	}
}

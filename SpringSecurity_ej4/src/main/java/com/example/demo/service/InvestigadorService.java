package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;

@Service
public class InvestigadorService implements IInvestigadorService{
	
	@Autowired(required = true)
	IInvestigadorDAO iInvestigadorDAO;

	@Override
	public List<Investigador> listAll() {
		return iInvestigadorDAO.findAll();
	}

	@Override
	public Investigador add(Investigador investigador) {
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public Investigador getOne(String dni) {
		return iInvestigadorDAO.findById(dni).get();
	}

	@Override
	public Investigador update(Investigador investigador) {
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public void eliminar(String dni) {
		iInvestigadorDAO.deleteById(dni);
	}
}

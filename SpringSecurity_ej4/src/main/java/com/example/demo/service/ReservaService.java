package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service
public class ReservaService implements IReservaService{
	
	@Autowired(required = true)
	IReservaDAO iReservaDAO;

	@Override
	public List<Reserva> listAll() {
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva add(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public Reserva getOne(int id) {
		return iReservaDAO.findById(id).get();
	}

	@Override
	public Reserva update(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public void eliminar(int id) {
		iReservaDAO.deleteById(id);
	}
	
	
}

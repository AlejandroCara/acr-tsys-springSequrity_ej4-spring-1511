package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Equipo;
import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired(required = true)
	ReservaService reservaService;
	
	@GetMapping("/all")
	public List<Reserva> listarReservas(){
		return reservaService.listAll();
	}
	
	@PostMapping("/add")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaService.add(reserva);
	}
	
	@GetMapping("/{id}")
	public Reserva listarUnaReserva(@PathVariable(name="id") int id) {
		return reservaService.getOne(id);
	}
	
	@PutMapping("/update/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id,@RequestBody Reserva reserva) {
		
		Reserva preReserva = new Reserva();
		Reserva newReserva = new Reserva();
		
		preReserva = reservaService.getOne(id);
		
		preReserva.setInvestigador(reserva.getInvestigador());
		preReserva.setEquipo(reserva.getEquipo());
		
		newReserva = reservaService.update(preReserva);
		
		return newReserva;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarReserva(@PathVariable(name="id")int id) {
		reservaService.eliminar(id);
	}
	
}

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
import com.example.demo.service.EquipoService;

@RestController
@RequestMapping("/equipo")
public class EquipoController {
	
	@Autowired(required = true)
	EquipoService equipoService;
	
	@GetMapping("/all")
	public List<Equipo> listarEquipos(){
		return equipoService.listAll();
	}
	
	@PostMapping("/add")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		return equipoService.add(equipo);
	}
	
	@GetMapping("/{numSerie}")
	public Equipo listarUnEquipo(@PathVariable(name="numSerie") String numSerie) {
		return equipoService.getOne(numSerie);
	}
	
	@PutMapping("/update/{numSerie}")
	public Equipo actualizarEquipo(@PathVariable(name="numSerie")String numSerie,@RequestBody Equipo equipo) {
		
		Equipo preEquipo = new Equipo();
		Equipo newEquipo = new Equipo();
		
		preEquipo = equipoService.getOne(numSerie);
		
		preEquipo.setFacultad(equipo.getFacultad());
		preEquipo.setNombre(equipo.getNombre());
		
		newEquipo = equipoService.update(preEquipo);
		
		return newEquipo;
	}
	
	@DeleteMapping("/delete/{numSerie}")
	public void eliminarEquipo(@PathVariable(name="numSerie")String numSerie) {
		equipoService.eliminar(numSerie);
	}
}

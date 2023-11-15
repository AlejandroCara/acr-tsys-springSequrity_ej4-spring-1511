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

import com.example.demo.dto.Facultad;
import com.example.demo.service.FacultadService;

@RestController
@RequestMapping("/facultad")
public class FacultadController {

	@Autowired(required = true)
	FacultadService facultadService;
	
	@GetMapping("/all")
	public List<Facultad> listarFacultades(){
		return facultadService.listAll();
	}
	
	@PostMapping("/add")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		return facultadService.add(facultad);
	}
	
	@GetMapping("/{codigo}")
	public Facultad listarUnaFacultad(@PathVariable(name="codigo") int codigo) {
		return facultadService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo")int codigo,@RequestBody Facultad facultad) {
		
		Facultad prevFacultad = new Facultad();
		Facultad newFacultad = new Facultad();
		
		prevFacultad = facultadService.getOne(codigo);
		
		prevFacultad.setNombre(facultad.getNombre());
		
		newFacultad = facultadService.update(prevFacultad);
		
		return newFacultad;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void eliminarFacultad(@PathVariable(name="codigo")int codigo) {
		facultadService.eliminar(codigo);
	}
}

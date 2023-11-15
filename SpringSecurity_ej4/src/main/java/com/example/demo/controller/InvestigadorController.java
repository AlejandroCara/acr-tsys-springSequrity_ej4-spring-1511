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

import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorService;

@RestController
@RequestMapping("/investigador")
public class InvestigadorController {

	@Autowired(required = true)
	InvestigadorService investigadorService;
	
	@GetMapping("/all")
	public List<Investigador> listarInvestigadores(){
		return investigadorService.listAll();
	}
	
	@PostMapping("/add")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		return investigadorService.add(investigador);
	}
	
	@GetMapping("/{dni}")
	public Investigador listarUnInvestigador(@PathVariable(name="dni") String dni) {
		return investigadorService.getOne(dni);
	}
	
	@PutMapping("/update/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name="dni")String dni,@RequestBody Investigador investigador) {
		
		Investigador preInvestigador = new Investigador();
		Investigador newInvestigador = new Investigador();
		
		preInvestigador = investigadorService.getOne(dni);
		
		preInvestigador.setNomapels(investigador.getNomapels());
		preInvestigador.setFacultad(investigador.getFacultad());
		
		newInvestigador = investigadorService.update(preInvestigador);
		
		return newInvestigador;
	}
	
	@DeleteMapping("/delete/{dni}")
	public void eliminarInvestigador(@PathVariable(name="dni")String dni) {
		investigadorService.eliminar(dni);
	}
}

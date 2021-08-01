package com.devtest.patientregister.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devtest.patientregister.entities.Enfermeiro;
import com.devtest.patientregister.entities.Patient;
import com.devtest.patientregister.repositories.EnfermeiroRepository;

@RestController 
@RequestMapping(value = "/enfermeiro")
public class EnfermeiroResource {
	
	@Autowired
	private EnfermeiroRepository enfermeiroRepository;

	/*@GetMapping("/{id}")
	public Enfermeiro buscarPorId(@PathVariable(value = "id") Integer id) {

		Optional<Enfermeiro>enfermeiro = enfermeiroRepository.findById(id);
		return enfermeiro.get();
	}*/
	
	@GetMapping("/{cpf}")
	public Enfermeiro buscarCPF(@PathVariable(value = "cpf") String cpf) {
		Enfermeiro enf = enfermeiroRepository.findByCPF(cpf);
		if (enf == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Enfermeiro Não encontrado");
		}
		return enf;
	}
	
	@PostMapping
	public Enfermeiro criar(@RequestBody Enfermeiro enfermeiro) {

		Enfermeiro enfermeiroSalvo;
		enfermeiroSalvo = enfermeiroRepository.save(enfermeiro);
		return enfermeiroSalvo;
	}

}

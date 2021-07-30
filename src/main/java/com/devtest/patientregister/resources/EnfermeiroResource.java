package com.devtest.patientregister.resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devtest.patientregister.entities.Enfermeiro;
import com.devtest.patientregister.entities.Patient;
import com.devtest.patientregister.repositories.EnfermeiroRepository;
import com.devtest.patientregister.repositories.PatientRepository;

@RestController 
@RequestMapping(value = "/enfermeiro")
public class EnfermeiroResource {
	
	@Autowired
	private EnfermeiroRepository enfermeiroRepository;

	@GetMapping("/{id}")
	public Enfermeiro buscarPorId(@PathVariable(value = "id") Integer id) {

		Optional<Enfermeiro>enfermeiro = enfermeiroRepository.findById(id);
		return enfermeiro.get();
	}

}

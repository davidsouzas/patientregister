package com.devtest.patientregister.resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devtest.patientregister.entities.Patient;
import com.devtest.patientregister.repositories.PatientRepository;

@RestController
@RequestMapping(value = "/patients")
public class PatitentResource {
	
	@Autowired
	private PatientRepository patientRepository;

	@GetMapping	
	public List<Patient> listarTodos() {

		List<Patient> pacientes = new ArrayList<Patient>();
		pacientes = patientRepository.findAll();

		return pacientes;
	}
	
	@PostMapping
	public Patient criar(@RequestBody Patient paciente) {

		Patient pacienteSalvo;
		pacienteSalvo = patientRepository.save(paciente);
		return pacienteSalvo;
	}


}

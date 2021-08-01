package com.devtest.patientregister.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.devtest.patientregister.services.Authorization;
import com.devtest.patientregister.entities.Patient;
import com.devtest.patientregister.repositories.PatientRepository;

@RestController
@RequestMapping(value = "/patients")
public class PatitentResource {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private Authorization authorization;

	@GetMapping	
	public List<Patient> listarTodos(@RequestHeader Map<String, String> Headers) {
		if (authorization.checkAuthorization(true, true, Headers) == false) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Não Autorizado!");
		}
		List<Patient> pacientes = new ArrayList<Patient>();
		pacientes = patientRepository.findAll();

		return pacientes;
	}
	
	@PostMapping
	public Patient criar(@RequestHeader Map<String,String> Headers, @RequestBody Patient paciente) {
		if (authorization.checkAuthorization(true, true, Headers) == false) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Não Autorizado!");
		}
		Patient pacienteSalvo;
		pacienteSalvo = patientRepository.save(paciente);
		return pacienteSalvo;
	}


}

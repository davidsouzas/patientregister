package com.devtest.patientregister.resources;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.devtest.patientregister.entities.Enfermeiro;
import com.devtest.patientregister.repositories.EnfermeiroRepository;
import com.devtest.patientregister.services.Authorization;

@RestController 
@RequestMapping(value = "/enfermeiro")
public class EnfermeiroResource {
	
	@Autowired
	private EnfermeiroRepository enfermeiroRepository;
	
	@Autowired
	private Authorization authorization;

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
	public Enfermeiro criar(@RequestHeader Map<String, String> Headers, @RequestBody Enfermeiro enfermeiro) {
		if (authorization.checkAuthorization(true, false, Headers) == false) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Não Autorizado!");
		}
		Enfermeiro enfermeiroSalvo;
		enfermeiroSalvo = enfermeiroRepository.save(enfermeiro);
		return enfermeiroSalvo;
	}

}

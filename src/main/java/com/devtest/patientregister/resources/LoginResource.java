package com.devtest.patientregister.resources;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devtest.patientregister.entities.Enfermeiro;
import com.devtest.patientregister.entities.Login;
import com.devtest.patientregister.entities.Medico;
import com.devtest.patientregister.entities.Patient;
import com.devtest.patientregister.entities.Token;
import com.devtest.patientregister.repositories.EnfermeiroRepository;
import com.devtest.patientregister.repositories.MedicoRepository;
import com.devtest.patientregister.repositories.TokenRepository;



@RestController 
@RequestMapping(value = "/login")
public class LoginResource {
	private String login;
	private String senha;
	
	
	@Autowired
	private EnfermeiroRepository enfermeiroRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	 protected static SecureRandom random = new SecureRandom();
	
	@PostMapping
	public Token logar(@RequestBody Login login) {

		Enfermeiro enfermeiro = enfermeiroRepository.findByCPF(login.getCpf());
		Medico medico = medicoRepository.findByCPF(login.getCpf());
		
		if (enfermeiro != null && enfermeiro.getSenha().equals(login.getSenha())) {
			   long longToken = Math.abs( random.nextLong() );
               String random = Long.toString( longToken, 16 );
               Token token = new Token();
               token.setToken(random);
               token.setValidade(new Date());
               Calendar calendar = Calendar.getInstance();
               calendar.add(Calendar.HOUR_OF_DAY, 10);
               token.setExpiration(calendar.getTime());
               token.setEnfermeiro(enfermeiro);
               tokenRepository.save(token);
               
               System.out.println(token.expirado());
               return token;
		}else
			if (medico != null && medico.getSenha().equals(login.getSenha())) {
				   long longToken = Math.abs( random.nextLong() );
	                String random = Long.toString( longToken, 16 );
	                Token token = new Token();
	                token.setToken(random);
	                token.setValidade(new Date());
	                Calendar calendar = Calendar.getInstance();
	                calendar.add(Calendar.HOUR_OF_DAY, 10);
	                token.setExpiration(calendar.getTime());
	                token.setMedico(medico);
	                
	                tokenRepository.save(token);
	                
	               

				return token;
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Login não encontrado");
		}
		
	}

}

package com.devtest.patientregister.services;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtest.patientregister.entities.Token;
import com.devtest.patientregister.repositories.TokenRepository;

@Service
public class Authorization {
	@Autowired
	private TokenRepository tokenRepository;
	
	public Boolean checkAuthorization(Boolean medicAuth, Boolean enferAuth, Map<String, String> headers) {
		String tokenHeader = headers.get("authorization");
		if (tokenHeader != null) {			
			Token token = tokenRepository.findByToken(tokenHeader);
			
			if (token.expirado()) {
				return false;
			}
			
			if (token.getMedico() != null && !medicAuth) {
				return false;
			}
			
			if (token.getEnfermeiro() != null && !enferAuth) {
				return false;
			}
			return true;
		}
		return false;
	}
}

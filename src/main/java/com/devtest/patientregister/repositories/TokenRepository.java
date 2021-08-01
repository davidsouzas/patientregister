package com.devtest.patientregister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.devtest.patientregister.entities.Token;

@Component
public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	@Query("SELECT tk FROM Token tk WHERE tk.token = :token")
	Token findByToken(@Param("token") String token);
}

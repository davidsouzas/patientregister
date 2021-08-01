package com.devtest.patientregister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.devtest.patientregister.entities.Token;

@Component
public interface TokenRepository extends JpaRepository<Token, Integer> {

}

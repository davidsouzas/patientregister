package com.devtest.patientregister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Component;

import com.devtest.patientregister.entities.Enfermeiro;

@Component
public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Integer>{
	
	@Query("SELECT pf FROM Enfermeiro pf WHERE pf.cpf = :cpf")
	Enfermeiro findByCPF(@Param("cpf") String cpf);

}

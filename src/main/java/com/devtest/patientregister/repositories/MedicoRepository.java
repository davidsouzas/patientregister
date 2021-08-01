package com.devtest.patientregister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.devtest.patientregister.entities.Medico;

@Component
public interface MedicoRepository extends JpaRepository<Medico, Integer>{

	@Query("SELECT pf FROM Medico pf WHERE pf.cpf = :cpf")
	Medico findByCPF(@Param("cpf") String cpf);
}

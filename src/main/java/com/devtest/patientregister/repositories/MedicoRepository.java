package com.devtest.patientregister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Component;

import com.devtest.patientregister.entities.Medico;
import com.devtest.patientregister.entities.Patient;

@Component
public interface MedicoRepository extends JpaRepository<Medico, Integer>{


}

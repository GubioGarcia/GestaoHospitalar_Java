package com.api.GestaoHospitalar.repositories;

import com.api.GestaoHospitalar.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findById(int id);
}

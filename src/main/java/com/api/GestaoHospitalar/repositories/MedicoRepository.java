package com.api.GestaoHospitalar.repositories;

import com.api.GestaoHospitalar.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Medico findById(int id);
}

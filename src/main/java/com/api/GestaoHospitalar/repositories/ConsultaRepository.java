package com.api.GestaoHospitalar.repositories;

import com.api.GestaoHospitalar.models.Consulta;
import com.api.GestaoHospitalar.models.Medico;
import com.api.GestaoHospitalar.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    Consulta findById(int id);
    boolean existsByMedicoAndDataAndHorarioBetween(Medico medico, LocalDate data, LocalTime inicio, LocalTime fim);
    boolean existsByPacienteAndDataAndHorarioBetween(Paciente paciente, LocalDate data, LocalTime inicio, LocalTime fim);
}

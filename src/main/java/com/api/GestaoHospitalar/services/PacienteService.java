package com.api.GestaoHospitalar.services;

import com.api.GestaoHospitalar.models.Paciente;
import com.api.GestaoHospitalar.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(Integer id) {
        return this.pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public Paciente save(Paciente medico) {
        return this.pacienteRepository.save(medico);
    }

    public Paciente update(Paciente medico) {
        return this.pacienteRepository.save(medico);
    }

    public void delete(Integer id) {
        this.pacienteRepository.deleteById(id);
    }
}

package com.api.GestaoHospitalar.controllers;

import com.api.GestaoHospitalar.models.Paciente;
import com.api.GestaoHospitalar.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente getById(@PathVariable Integer id) {
        return pacienteService.findById(id);
    }

    @PostMapping
    public Paciente savePaciente(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @PutMapping
    public Paciente updatePaciente(@RequestBody Paciente paciente) {
        return pacienteService.update(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Integer id) {
        this.pacienteService.delete(id);
    }
}

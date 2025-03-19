package com.api.GestaoHospitalar.controllers;

import com.api.GestaoHospitalar.models.Medico;
import com.api.GestaoHospitalar.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public Medico getById(@PathVariable Integer id) {
        return medicoService.findById(id);
    }

    @PostMapping
    public Medico saveMedico(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @PutMapping
    public Medico updateMedico(@RequestBody Medico medico) {
        return medicoService.update(medico);
    }

    @DeleteMapping("/{id}")
    public void deleteMedico(@PathVariable Integer id) {
        this.medicoService.delete(id);
    }
}

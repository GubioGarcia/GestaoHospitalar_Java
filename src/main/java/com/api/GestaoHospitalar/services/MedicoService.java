package com.api.GestaoHospitalar.services;

import com.api.GestaoHospitalar.models.Medico;
import com.api.GestaoHospitalar.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Integer id) {
        return this.medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico não encontrado"));
    }

    public Medico save(Medico medico) {
        return this.medicoRepository.save(medico);
    }

    public Medico update(Medico medico) {
        return this.medicoRepository.save(medico);
    }

    public void delete(Integer id) {
        this.medicoRepository.deleteById(id);
    }
}

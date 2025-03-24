package com.api.GestaoHospitalar.controllers;

import com.api.GestaoHospitalar.dto.ConsultaDTO;
import com.api.GestaoHospitalar.models.Consulta;
import com.api.GestaoHospitalar.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {
    
    @Autowired
    private ConsultaService consultaService;
    
    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public Consulta getById(@PathVariable Integer id) {
        return consultaService.findById(id);
    }

    @PostMapping("/agendarConsulta")
    public Consulta saveConsulta(@RequestBody ConsultaDTO consulta) {
        return consultaService.save(consulta);
    }

    @PutMapping("/cancelarConsulta/{idConsulta}")
    public void cancelarConsulta(@PathVariable Integer idConsulta) {
        this.consultaService.cancelarConsulta(idConsulta);
    }

    @PutMapping("/reagendarConsulta/{idConsulta}")
    public void cancelarConsulta(@PathVariable Integer idConsulta, @RequestBody ConsultaDTO consultaDto) {
        this.consultaService.reagendarConsulta(consultaDto, idConsulta);
    }

    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable Integer id) {
        this.consultaService.delete(id);
    }
}

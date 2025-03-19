package com.api.GestaoHospitalar.services;

import com.api.GestaoHospitalar.dto.ConsultaDTO;
import com.api.GestaoHospitalar.models.Consulta;
import com.api.GestaoHospitalar.models.Medico;
import com.api.GestaoHospitalar.models.Paciente;
import com.api.GestaoHospitalar.repositories.ConsultaRepository;
import com.api.GestaoHospitalar.repositories.MedicoRepository;
import com.api.GestaoHospitalar.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Consulta findById(Integer id) {
        return this.consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public Consulta save(ConsultaDTO consultaDto) {
        Consulta consulta = new Consulta();
        consulta.setData(LocalDate.parse(consultaDto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        consulta.setHorario(LocalTime.parse(consultaDto.getHorario(), DateTimeFormatter.ofPattern("HH:mm:ss")));
        consulta.setStatus(consultaDto.getStatus());

        Medico medico = medicoRepository.findById(consultaDto.getMedicoId());
        if (medico == null) throw new RuntimeException("Médico não encontrado.");
        consulta.setMedico(medico);

        Paciente paciente = pacienteRepository.findById(consultaDto.getPacienteId());
        if (paciente == null) throw new RuntimeException("Paciente não encontrado.");
        consulta.setPaciente(paciente);

        validarDisponibilidadeHorarioMedico(consulta.getMedico(), consulta.getData(), consulta.getHorario());
        validarDisponibilidadeHorarioPaciente(consulta.getPaciente(), consulta.getData(), consulta.getHorario());
        return this.consultaRepository.save(consulta);
    }

    public Consulta update(Consulta consulta) {
        validarDisponibilidadeHorarioMedico(consulta.getMedico(), consulta.getData(), consulta.getHorario());
        validarDisponibilidadeHorarioPaciente(consulta.getPaciente(), consulta.getData(), consulta.getHorario());
        return this.consultaRepository.save(consulta);
    }

    public void delete(Integer id) {
        this.consultaRepository.deleteById(id);
    }

    private void validarDisponibilidadeHorarioMedico(Medico medico, LocalDate data, LocalTime horario) {
        LocalTime inicio = horario.minusMinutes(30);
        LocalTime fim = horario.plusMinutes(30);

        boolean conflito = consultaRepository.existsByMedicoAndDataAndHorarioBetween(medico, data, inicio, fim);
        if (conflito) throw new RuntimeException("Médico já possui uma consulta nesse horário. Consulta possui intervalo de 30 minutos.");
    }

    private void validarDisponibilidadeHorarioPaciente(Paciente paciente, LocalDate data, LocalTime horario) {
        LocalTime inicio = horario.minusMinutes(30);
        LocalTime fim = horario.plusMinutes(30);

        boolean conflito = consultaRepository.existsByPacienteAndDataAndHorarioBetween(paciente, data, inicio, fim);
        if (conflito) throw new RuntimeException("Paciente já possui uma consulta nesse horário. Consulta possui intervalo de 30 minutos.");
    }
}

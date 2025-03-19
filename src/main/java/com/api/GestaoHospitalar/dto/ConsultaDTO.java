package com.api.GestaoHospitalar.dto;

import com.api.GestaoHospitalar.models.StatusConsulta;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaDTO {

    @NotNull
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "A data deve estar no formato dd/MM/yyyy")
    @Schema(example = "18/03/2025", description = "Data da consulta no formato dd/MM/yyyy")
    private String data;

    @NotNull
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message = "O horário deve estar no formato HH:mm:ss")
    @Schema(example = "09:15:00", description = "Horário da consulta no formato HH:mm:ss")
    private String horario;

    @NotNull
    private int medicoId;

    @NotNull
    private int pacienteId;

    @NotNull
    private StatusConsulta status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }
}

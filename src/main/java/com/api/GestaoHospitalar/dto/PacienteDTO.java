package com.api.GestaoHospitalar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class PacienteDTO {
    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    @NotNull
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "A data deve estar no formato dd/MM/yyyy")
    @Schema(example = "18/03/1952", description = "Data de nascimento no formato dd/MM/yyyy")
    private String dataDeNascimento;

    @NotNull
    private String telefone;
}

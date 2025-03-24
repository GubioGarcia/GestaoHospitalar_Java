package com.api.GestaoHospitalar.dto;

import jakarta.validation.constraints.NotNull;

public class MedicoDTO {
    @NotNull
    private String nome;

    @NotNull
    private String especialidade;

    @NotNull
    private String crm;
}

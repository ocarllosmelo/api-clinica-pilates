package com.carlos.fisiosync.agendamentos.dto;

import jakarta.validation.constraints.NotBlank;

//DTO de entrada (request)
public record DadosCadastroPaciente (
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotBlank String email) {
}

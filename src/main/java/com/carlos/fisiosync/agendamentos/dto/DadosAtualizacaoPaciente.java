package com.carlos.fisiosync.agendamentos.dto;

import jakarta.validation.constraints.NotNull;

//DTO de entrada (request)
public record DadosAtualizacaoPaciente(@NotNull Long id, String nome, String cpf, String email) {
}

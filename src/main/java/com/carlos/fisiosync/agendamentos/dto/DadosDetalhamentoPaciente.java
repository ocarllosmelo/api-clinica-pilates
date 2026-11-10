package com.carlos.fisiosync.agendamentos.dto;

import com.carlos.fisiosync.agendamentos.model.Paciente;

//DTO de saída (response)
public record DadosDetalhamentoPaciente(Long id, String nome, String cpf, String email) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}

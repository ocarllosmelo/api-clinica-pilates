package com.carlos.fisiosync.agendamentos.dto;

import com.carlos.fisiosync.agendamentos.model.Paciente;

//DTO de saída (response)
public record DadosListagemPaciente(Long id, String nome, String cpf, String email) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}

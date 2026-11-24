package com.carlos.fisiosync.agendamentos.service;

import com.carlos.fisiosync.agendamentos.dto.DadosCadastroAgendamento;
import com.carlos.fisiosync.agendamentos.dto.DadosCadastroPaciente;
import com.carlos.fisiosync.agendamentos.model.Agendamento;
import com.carlos.fisiosync.agendamentos.repository.AgendamentoRepository;
import com.carlos.fisiosync.agendamentos.repository.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Quem lê aqui é o Spring
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;
    @Autowired
    private PacientesRepository pacientesRepository;

    public void agendar(DadosCadastroAgendamento dados){
        var paciente = pacientesRepository.findById(dados.idPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        long agendamentosNoHorario = repository.countByDataHora(dados.dataHora());

        if (agendamentosNoHorario >= 5){
            throw new RuntimeException("Horário lotado! Limite de 5 alunos atingindo.");
        }

        var agendamento = new Agendamento();
        agendamento.setPaciente(paciente);
        agendamento.setDataHora(dados.dataHora());

        repository.save(agendamento);
    }
}

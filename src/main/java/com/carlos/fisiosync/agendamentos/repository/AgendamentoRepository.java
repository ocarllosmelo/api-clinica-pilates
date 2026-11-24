package com.carlos.fisiosync.agendamentos.repository;

import com.carlos.fisiosync.agendamentos.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Long countByDataHora(LocalDateTime dataHora);
}

package com.carlos.fisiosync.agendamentos.controller;

import com.carlos.fisiosync.agendamentos.dto.DadosCadastroAgendamento;
import com.carlos.fisiosync.agendamentos.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")

public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<Void> agendar (@RequestBody @Valid DadosCadastroAgendamento dados){

        service.agendar(dados);

        //Vai devolver o status 201 created para o user
        return ResponseEntity.status(201).build();
    }
}

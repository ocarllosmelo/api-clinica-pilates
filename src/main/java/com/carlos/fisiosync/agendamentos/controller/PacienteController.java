package com.carlos.fisiosync.agendamentos.controller;

import com.carlos.fisiosync.agendamentos.dto.DadosAtualizacaoPaciente;
import com.carlos.fisiosync.agendamentos.dto.DadosCadastroPaciente;
import com.carlos.fisiosync.agendamentos.dto.DadosDetalhamentoPaciente;
import com.carlos.fisiosync.agendamentos.dto.DadosListagemPaciente;
import com.carlos.fisiosync.agendamentos.model.Paciente;
import com.carlos.fisiosync.agendamentos.repository.PacientesRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    @Autowired
    private PacientesRepository repository;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoPaciente> cadastrar(
            @RequestBody @Valid DadosCadastroPaciente dados, org.springframework.web.util.UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(dados);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"id"})Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativar();

        return ResponseEntity.noContent().build();
    }
}

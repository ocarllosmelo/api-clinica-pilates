package com.carlos.fisiosync.agendamentos.model;

import com.carlos.fisiosync.agendamentos.dto.DadosAtualizacaoPaciente;
import com.carlos.fisiosync.agendamentos.dto.DadosCadastroPaciente;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pacientes")
public class Paciente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String cpf;
        private String email;
        private Boolean ativo;

        public Paciente(DadosCadastroPaciente dados){
            this.nome = dados.nome();
            this.cpf = dados.cpf();
            this.email = dados.email();
            this.ativo = true;
        }

        public void atualizarInformacoes(DadosAtualizacaoPaciente dados){
            if(dados.nome() != null){
                this.nome = dados.nome();
            }
            if(dados.cpf() != null){
                this.cpf = dados.cpf();
            }
            if(dados.email() != null){
                this.email = dados.email();
            }
        }

        public void inativar(){
            this.ativo = false;
        }
}

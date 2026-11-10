### 🧘‍♀️ API Clínica de Fisioterapia e Pilates

Este projeto é uma API RESTful construída com **Java 21 e Spring Boot** para gerenciar agendamentos e rotinas de uma clínica de fisioterapia e estúdio de Pilates.

O foco da arquitetura é a **Confiabilidade e Integridade dos Dados**, seguindo boas práticas de Engenharia de Software, com alto nível de isolamento de responsabilidades e regras de negócio rígidas.

### 🚀 Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA & Hibernate**
* **Lombok**
* **PostgreSQL** (Ambiente de Produção planejado)
* **Padrão DTO (Data Transfer Object)** via Java Records

### ⚙️ Arquitetura e Boas Práticas
* **Isolamento de Camadas:** Separação estrita entre `Controllers`, `DTOs`, `Repositories` e `Entities`.
* **Programação Defensiva:** Validação rigorosa de dados de entrada com anotações `@Valid`, `@NotBlank` e `@NotNull`.
* **Soft Delete (Exclusão Lógica):** Pacientes inativados ao invés de apagados do banco, garantindo que o histórico de saúde e agendamentos não fique órfão.
* **Transações Seguras:** Uso de `@Transactional` para garantir *rollback* em caso de falhas de persistência.

### 🚧 Próximos Passos (Backlog)
- [ ] Tratamento Global de Erros (Padronização de respostas HTTP).
- [ ] Entidade `Agendamento` (Regra de negócio: limite máximo de 5 alunos por hora).
- [ ] Spring Security (Controle de acesso Fisioterapeuta vs Alunos).
- [ ] Documentação automatizada com Swagger OpenAPI.
- [ ] Geração de Relatórios em PDF.
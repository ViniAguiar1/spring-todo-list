# Spring Todo List

Este é um projeto de lista de tarefas (To-Do List) desenvolvido em **Java** utilizando **Spring Boot**. Ele permite realizar operações básicas como adicionar, listar, atualizar e excluir tarefas. O projeto segue a arquitetura MVC (Model-View-Controller), utilizando JPA para persistência de dados e um banco de dados em memória **H2**.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.3**
- **Maven**
- **Spring Data JPA**
- **Banco de dados H2 (runtime)**
- **Lombok** para simplificação de código
- **Bcrypt** para hashing de senhas

## Estrutura do Projeto

```bash
Todolist
├── .mvn
├── .vscode
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── viniciusaguiar
│   │               └── todolist
│   │                   ├── filter
│   │                   ├── task
│   │                   │   ├── ITaskRepository.java
│   │                   │   ├── TaskController.java
│   │                   │   └── TaskModel.java
│   │                   └── user
│   └── resources
├── test
├── target
└── pom.xml
```
## Funcionalidades
- Adicionar uma nova tarefa
- Listar todas as tarefas
- Atualizar o status ou os detalhes de uma tarefa
- Excluir uma tarefa
- Hashing de senhas com Bcrypt para autenticação futura (com potencial expansão para um sistema de usuários)

## Como Executar o Projeto - Requisitos
- Java 17
- Maven

### Passos para Rodar Localmente
    git clone https://github.com/seu-usuario/spring-todo-list.git
    cd spring-todo-list
    mvn spring-boot:run

### Banco de dados
    Este projeto utiliza um banco de dados H2 em memória por padrão. O console do H2 pode ser acessado em:
    - http://localhost:8080/h2-console

### Use as seguintes credenciais para acessar:

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: (vazio)

### Endpoints Principais
- GET /tasks: Retorna todas as tarefas cadastradas.
- POST /tasks: Cria uma nova tarefa.
- PUT /tasks/{id}: Atualiza os detalhes de uma tarefa específica.
- DELETE /tasks/{id}: Remove uma tarefa.

Este projeto inclui o framework de testes do Spring Boot para garantir a qualidade e funcionamento das funcionalidades principais.

#### Para rodar os testes, use o seguinte comando:
    mvn test

### Contribuindo
- Faça um fork do repositório para o seu GitHub.
- Crie uma branch nova para fazer suas alterações:
    ```
    git checkout -b minha-feature
    ```
- Depois de fazer as modificações, faça o commit das suas mudanças:
    ```
    git commit -m 'Adiciona minha feature'
    ```
- Envie suas alterações para o seu repositório remoto:
    ```
    git push origin minha-feature
    ```


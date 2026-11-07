# Salão Cabeleireiro

Projeto em desenvolvimento para organizar as informações de um salão de
cabeleireiro. A ideia é evoluir aos poucos de um exemplo em Java para uma
aplicação que ajude a gerenciar clientes e serviços.

## O que já existe

- Cadastro básico de clientes com nome, telefone e e-mail.
- Cadastro básico de serviços com preço e duração.
- Exemplos de clientes e serviços exibidos no terminal.

## Tecnologias

- Java
- `BigDecimal` para representar os preços dos serviços

## Como executar

É necessário ter o JDK instalado. Na pasta do projeto, compile os arquivos:

```bash
javac -d out src/Main.java src/model/Cliente.java src/model/Servico.java
```

Depois, execute a aplicação:

```bash
java -cp out Main
```

## Próximos passos

- Permitir cadastrar e consultar clientes e serviços.
- Adicionar agendamentos e validações.
- Persistir os dados para que continuem disponíveis entre execuções.

Este projeto ainda está em construção; funcionalidades e estrutura podem mudar.

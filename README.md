# Salão de Cabeleireiro

Aplicação de linha de comando em Java para gerenciar clientes, serviços e agendamentos de um salão.

## Funcionalidades

- Cadastrar e listar clientes.
- Cadastrar e listar serviços, com preço e duração.
- Agendar clientes para serviços em uma data e horário futuros.
- Impedir agendamentos com horários sobrepostos.
- Consultar e cancelar agendamentos.

Os dados ficam armazenados em memória e são perdidos ao encerrar a aplicação.

## Requisitos

- JDK 17 ou superior.

## Como executar

Clone o repositório e entre na pasta do projeto:

```bash
git clone https://github.com/Pedro-Nex/Salao-Cabeleireiro.git
cd Salao-Cabeleireiro
```

No PowerShell, compile e execute:

```powershell
$sources = Get-ChildItem -Recurse src -Filter *.java
javac -d out $sources.FullName
java -cp out Main
```

No IntelliJ IDEA, abra o projeto e execute a classe `Main`.

No menu, siga as opções para cadastrar clientes e serviços antes de criar um agendamento. Informe a data e hora no formato `dd/MM/yyyy HH:mm`.

## Estrutura

```text
src/
├── Main.java
├── model/       # Cliente, serviço e agendamento
└── service/     # Regras de cadastro e agenda
```

## Licença

Este projeto está disponível sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE).

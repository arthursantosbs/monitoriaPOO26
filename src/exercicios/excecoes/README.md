# Exercicios - Excecoes

Esta pasta guarda a lista de exercicios sobre excecoes em Java.

## Estrutura

```text
src/exercicios/excecoes/
├── exercicio01/
│   └── ConversorDeNotas.java
├── exercicio02/
│   ├── Exercicio02.java
│   ├── RelatorioAlunosComFinally.java
│   ├── RelatorioAlunosTryWithResources.java
│   └── RelatorioAlunosUtil.java
├── exercicio03/
│   ├── Agenda.java
│   ├── AgendamentoInvalidoException.java
│   ├── Exercicio03.java
│   └── HorarioIndisponivelException.java
└── exercicio04/
    ├── CartaoExpiradoException.java
    ├── Exercicio04.java
    ├── PagamentoException.java
    ├── ProcessadorDePagamento.java
    └── SaldoInsuficienteException.java
```

O arquivo de entrada do Exercício 2 fica em:

```text
resources/exercicios/excecoes/exercicio02/alunos.csv
```

Os relatórios são gerados em:

```text
out/relatorios/exercicio02/
```

## Como compilar

Execute a partir da raiz do projeto:

```bash
javac -encoding UTF-8 -d out/exercicios $(find src/exercicios/excecoes -name "*.java")
```

## Como executar

```bash
java -cp out/exercicios exercicios.excecoes.exercicio01.ConversorDeNotas
java -cp out/exercicios exercicios.excecoes.exercicio02.Exercicio02
java -cp out/exercicios exercicios.excecoes.exercicio03.Exercicio03
java -cp out/exercicios exercicios.excecoes.exercicio04.Exercicio04
```

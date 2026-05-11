# Monitoria POO 26

Projeto de monitoria de Programacao Orientada a Objetos em Java.

## Estrutura

```text
MonitoriaPOO26/
├── README.md
├── MonitoriaPOO26.iml
├── docs/
│   ├── GUIA_COMPLETO.md
│   ├── INDICE.md
│   └── RESUMO.txt
├── resources/
│   └── exercicios/
│       └── excecoes/
│           └── exercicio02/
│               └── alunos.csv
└── src/
    ├── aulas/
    │   ├── Main.java
    │   ├── Aula1_Encapsulamento.java
    │   ├── Aula2_Heranca.java
    │   ├── Aula3_Polimorfismo.java
    │   ├── Aula4_Abstracao.java
    │   └── CheatSheet.java
    └── exercicios/
        ├── lista07/
        │   ├── README.md
        │   ├── Questao01.java
        │   ├── Questao02.java
        │   ├── Questao03.java
        │   └── Questao04.java
        └── excecoes/
            ├── README.md
            ├── exercicio01/
            ├── exercicio02/
            ├── exercicio03/
            └── exercicio04/
```

## Como compilar

Execute a partir da raiz do projeto:

```bash
javac -encoding UTF-8 -d out/classes $(find src -name "*.java")
```

## Como executar

### Aulas principais

```bash
java -cp out/classes aulas.Main
```

### Lista 07

```bash
java -cp out/classes exercicios.lista07.Questao01
java -cp out/classes exercicios.lista07.Questao02
java -cp out/classes exercicios.lista07.Questao03
java -cp out/classes exercicios.lista07.Questao04
```

### Exercicios de excecoes

```bash
java -cp out/classes exercicios.excecoes.exercicio01.ConversorDeNotas
java -cp out/classes exercicios.excecoes.exercicio02.Exercicio02
java -cp out/classes exercicios.excecoes.exercicio03.Exercicio03
java -cp out/classes exercicios.excecoes.exercicio04.Exercicio04
```

## Conteudo

- `src/aulas`: exemplos dos quatro pilares da orientacao a objetos.
- `src/exercicios/lista07`: questoes resolvidas da Lista 07.
- `src/exercicios/excecoes`: exercicios sobre tratamento de excecoes.
- `resources`: arquivos de entrada usados pelos exercicios.
- `docs`: material de apoio e resumo do projeto.

Os arquivos gerados em execucao ficam em `out/`, que nao deve ser versionado.

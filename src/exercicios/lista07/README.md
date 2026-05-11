# Lista 07 - Exercicios de Programacao Orientada a Objetos

Esta pasta guarda as quatro questoes da Lista 07.

## Estrutura

```text
src/exercicios/lista07/
├── Questao01.java    <- Sistema Fiscal (Polimorfismo)
├── Questao02.java    <- Armazenamento com Cache (LSP)
├── Questao03.java    <- Motor de Descontos (Strategy)
└── Questao04.java    <- Sistema de Log (Polimorfismo)
```

## Como compilar

Execute a partir da raiz do projeto:

```bash
javac -encoding UTF-8 -d out/classes $(find src -name "*.java")
```

## Como executar

```bash
java -cp out/classes exercicios.lista07.Questao01
java -cp out/classes exercicios.lista07.Questao02
java -cp out/classes exercicios.lista07.Questao03
java -cp out/classes exercicios.lista07.Questao04
```

## Conceitos abordados

- Questao 01: Polimorfismo e Strategy Pattern
- Questao 02: Principio da Substituicao de Liskov (LSP)
- Questao 03: Padrao Strategy e extensibilidade
- Questao 04: Polimorfismo em atributos e metodos

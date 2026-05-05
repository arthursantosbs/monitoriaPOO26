# 📘 Guia Completo (organizado) — Pilares da OO em Java

## Contexto

- Disciplina: Programação Orientada a Objetos
- Professor: Antonio Dias
- Referência (site): https://antoniodias.me/docs/disciplinas/poo-ads/
- Referência (Notion Superior): https://antoniodias.notion.site/Superior-3581ec0493a04c7c80236a5061713b82

---

## Módulo 1 — Encapsulamento

### O que aprender
- Proteger estado interno com `private`.
- Expor comportamento com métodos públicos.
- Validar entrada antes de alterar atributos.

### Onde estudar no projeto
- `src/Aula1_Encapsulamento.java`

### Checklist
- [ ] Entendi por que atributo público é arriscado.
- [ ] Sei criar getter/setter com validação.
- [ ] Sei negar atualização inválida de estado.

---

## Módulo 2 — Herança

### O que aprender
- Relacionamento “é um”.
- Reuso via classe base (`extends`).
- Especialização via `@Override`.

### Onde estudar no projeto
- `src/Aula2_Heranca.java`

### Checklist
- [ ] Sei quando usar herança e quando evitar.
- [ ] Sei usar `super(...)` em construtores.
- [ ] Sei sobrescrever comportamento corretamente.

---

## Módulo 3 — Polimorfismo

### O que aprender
- Tratar diferentes objetos por um tipo comum.
- Diferença entre override e overload.
- Reduzir condicionais com despacho dinâmico.

### Onde estudar no projeto
- `src/Aula3_Polimorfismo.java`

### Checklist
- [ ] Sei aplicar override entre classes relacionadas.
- [ ] Sei usar overload no mesmo escopo.
- [ ] Sei percorrer coleções heterogêneas por interface/base.

---

## Módulo 4 — Abstração

### O que aprender
- Definir contratos com interfaces.
- Usar classe abstrata para base parcial.
- Separar “o que faz” de “como faz”.

### Onde estudar no projeto
- `src/Aula4_Abstracao.java`

### Checklist
- [ ] Sei criar e implementar interface.
- [ ] Sei quando preferir abstract class.
- [ ] Sei trocar implementações sem mudar o cliente.

---

## Plano de estudo (5 dias)

1. **Dia 1:** README + Encapsulamento.
2. **Dia 2:** Herança + exercícios simples.
3. **Dia 3:** Polimorfismo + testes mentais de fluxo.
4. **Dia 4:** Abstração + interfaces múltiplas.
5. **Dia 5:** Revisão geral com `CheatSheet` e lista07.

---

## Como praticar melhor

- Rode `Main.java` e altere pequenos trechos para observar impacto.
- Crie um exemplo próprio para cada pilar.
- Explique cada pilar em voz alta em 1 minuto.
- Refaça 1 exercício da `lista07` sem consultar solução.

---

## Erros comuns

- Usar herança para qualquer reuso (prefira composição quando necessário).
- Confundir sobrecarga com sobrescrita.
- Expor atributos diretamente.
- Criar interfaces genéricas demais sem objetivo claro.

---

## Comandos de execução

```bash
javac src/*.java src/LIsta07/*.java
java -cp src Main
```

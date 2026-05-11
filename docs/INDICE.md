# 📚 ÍNDICE NAVEGÁVEL - PILARES DA OO

Bem-vindo! Este arquivo é seu guia para navegar pelos materials de aprendizado.

---

## 🗺️ MAPA DE NAVEGAÇÃO

```
START AQUI ⬇️
```

### 1. **../README.md** ← Comece aqui!
📄 Visão geral do projeto e quick start
- 🎯 O que é cada pilar
- ⚡ Como executar o código
- 🎓 Conceitos importantes

---

### 2. Execute o programa
```bash
cd /home/arthur/IdeaProjects/MonitoriaPOO26
java -cp out/classes aulas.Main
```
📺 Veja todos os exemplos rodando!

---

### 3. **GUIA_COMPLETO.md** ← Estude detalhes
📖 Guia completo e aprofundado
- 📚 Explicações de cada pilar
- 💡 Exemplos práticos
- 🏋️ Exercícios propostos
- ❓ Perguntas frequentes

---

### 4. **Arquivos de Aulas**
Estude na seguinte ordem:

#### **src/aulas/Aula1_Encapsulamento.java** (NÍVEL: Iniciante)
```
Conceitos:
✓ private, public, protected
✓ getters e setters
✓ Validação de dados
✓ Proteção de integridade

Exemplos:
• Classe Pessoa
• Conta Bancária

Tempo: 15-20 min
```

#### **src/aulas/Aula2_Heranca.java** (NÍVEL: Iniciante)
```
Conceitos:
✓ extends
✓ super
✓ Hierarquia de classes
✓ @Override

Exemplos:
• Animal → Cachorro, Gato, Vaca
• Veiculo → Carro, Moto

Tempo: 20-25 min
```

#### **src/aulas/Aula3_Polimorfismo.java** (NÍVEL: Intermediário)
```
Conceitos:
✓ Override (sobrescrita)
✓ Overload (sobrecarga)
✓ Interface de mesmo tipo
✓ Flexibilidade de código

Exemplos:
• Formas Geométricas
• Métodos de Pagamento
• Funcionários diferentes
• Calculadora

Tempo: 25-30 min
```

#### **Aula4_Abstracao.java** (NÍVEL: Intermediário)
```
Conceitos:
✓ Classes abstratas
✓ Interfaces
✓ Múltiplas implementações
✓ Contratos

Exemplos:
• Veículos abstratos
• Animais com interfaces
• Repositório de dados

Tempo: 25-30 min
```

#### **CheatSheet.java** (REFERÊNCIA RÁPIDA)
```
Quick Reference:
✓ Resumo de cada pilar
✓ Comparação entre conceitos
✓ Erros comuns
✓ Dicas finais

Uso: Consulte quando tiver dúvidas rápidas
```

---

## 📊 ESTRUTURA DO PROJETO

```
📦 MonitoriaPOO26
│
├── 📄 README.md                      ← Leia primeiro!
├── 📂 docs/                          ← Guias e resumos
├── 📂 resources/                     ← Arquivos usados nos exercícios
│
└── 📂 src
    ├── 📂 aulas/                     ← Exemplos dos 4 pilares
    │   ├── Main.java                 ← Execute isto!
    │   ├── Aula1_Encapsulamento.java
    │   ├── Aula2_Heranca.java
    │   ├── Aula3_Polimorfismo.java
    │   ├── Aula4_Abstracao.java
    │   └── CheatSheet.java
    │
    └── 📂 exercicios/
        ├── lista07/
        └── excecoes/
```

---

## 🎓 PLANO DE ESTUDO SUGERIDO

### Dia 1: Fundamentos (1-2 horas)
- [ ] Leia README.md
- [ ] Execute `aulas.Main`
- [ ] Estude `src/aulas/Aula1_Encapsulamento.java`
- [ ] Entenda o conceito de proteger dados

### Dia 2: Reutilização (1-2 horas)
- [ ] Estude Aula2_Heranca.java
- [ ] Crie sua própria hierarquia
- [ ] Entenda @Override

### Dia 3: Flexibilidade (1-2 horas)
- [ ] Estude Aula3_Polimorfismo.java
- [ ] Compreenda Override vs Overload
- [ ] Veja como código fica flexível

### Dia 4: Abstrair (1-2 horas)
- [ ] Estude Aula4_Abstracao.java
- [ ] Entenda abstract vs interface
- [ ] Veja padrões de design

### Dia 5: Integração (1-2 horas)
- [ ] Leia GUIA_COMPLETO.md
- [ ] Faça os exercícios práticos
- [ ] Integre todos os 4 pilares

**Total:** ~7-10 horas (ritmo confortável)

---

## 💡 ROTEIRO DE LEITURA RECOMENDADO

### Para Iniciantes Completos
1. README.md
2. Main.java (execute)
3. Aula1_Encapsulamento.java (leia)
4. Aula2_Heranca.java (leia)
5. GUIA_COMPLETO.md (leia com calma)

### Para Intermediários
1. README.md (skim)
2. Main.java (execute e estude)
3. Todas as aulas (leia código)
4. GUIA_COMPLETO.md (estude exercícios)
5. CheatSheet.java (use como referência)

### Para Avançados
1. Main.java (estude estrutura)
2. CheatSheet.java (review rápido)
3. Aulas 3-4 (foco em padrões)
4. GUIA_COMPLETO.md (faça exercícios avançados)

---

## 🔍 PROCURANDO ALGO ESPECÍFICO?

### "Quero aprender sobre Encapsulamento"
→ Vá para `Aula1_Encapsulamento.java`

### "Preciso de exemplos práticos"
→ Execute `Main.java`

### "Qual é a diferença entre abstract e interface?"
→ Leia `GUIA_COMPLETO.md` seção 4

### "Quero um resumo rápido"
→ Consulte `CheatSheet.java`

### "Não entendi hierarquia"
→ Estude `Aula2_Heranca.java` seção de Animal

### "Como usar polimorfismo?"
→ Veja `Aula3_Polimorfismo.java` seção de Pagamento

### "Quero praticar"
→ GUIA_COMPLETO.md tem 4 exercícios

### "Preciso validar código"
→ Abra cada `AulaX.java` em sua IDE

---

## 🎯 OBJETIVOS DE APRENDIZADO

### Ao terminar, você será capaz de:

**ENCAPSULAMENTO** ✅
- [ ] Criar classes com dados protected
- [ ] Usar getters e setters
- [ ] Validar dados na entrada

**HERANÇA** ✅
- [ ] Criar hierarquias com `extends`
- [ ] Usar `super` para acessar classe pai
- [ ] Entender relação "é um"

**POLIMORFISMO** ✅
- [ ] Sobrescrever métodos com `@Override`
- [ ] Sobrecarregar métodos
- [ ] Tratar objetos de tipos diferentes

**ABSTRAÇÃO** ✅
- [ ] Criar classes abstratas
- [ ] Criar interfaces
- [ ] Saber quando usar cada uma

---

## 📝 DICAS DE ESTUDO

### 💻 Dica 1: Execute enquanto lê
Abra o arquivo Java, rode, veja output, entenda

### 📖 Dica 2: Leia o código de trás para frente
Comece pelo `Main.java` e vá para as aulas

### 🖊️ Dica 3: Copie e modifique
Não apenas leia, digite e teste mudanças

### 🤔 Dica 4: Questione o design
Por que cada classe foi feita assim?

### 💾 Dica 5: Crie variações
Estude um exemplo, crie a sua versão

### 🎯 Dica 6: Ensine alguém
O melhor jeito de aprender é ensinando

---

## 🚀 PRÓXIMOS PASSOS

Após dominar os 4 pilares, estude:

1. **Padrões de Design**
   - Singleton
   - Strategy
   - Factory
   - Observer

2. **Princípios SOLID**
   - Single Responsibility
   - Open/Closed
   - Liskov Substitution
   - Interface Segregation
   - Dependency Inversion

3. **Frameworks Java**
   - Spring Boot
   - Hibernate
   - JavaFX

---

## 📞 CHECKLIST FINAL

- [ ] Li README.md
- [ ] Executei Main.java
- [ ] Estudei Aula1_Encapsulamento
- [ ] Estudei Aula2_Heranca
- [ ] Estudei Aula3_Polimorfismo
- [ ] Estudei Aula4_Abstracao
- [ ] Li GUIA_COMPLETO.md
- [ ] Consultei CheatSheet.java
- [ ] Fiz pelo menos 1 exercício
- [ ] Criei meu próprio exemplo
- [ ] Ensinei alguém sobre OO

**Se marcou tudo:** Parabéns! Você domina os 4 pilares! 🎉

---

## 💬 RESUMO RÁPIDO POR PILAR

```
┌─────────────────────────────────────────────────────────┐
│ 1️⃣  ENCAPSULAMENTO - Aula1_Encapsulamento.java          │
│ Proteger dados com private + getters/setters            │
└─────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────┐
│ 2️⃣  HERANÇA - Aula2_Heranca.java                        │
│ Compartilhar código com extends + super                 │
└─────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────┐
│ 3️⃣  POLIMORFISMO - Aula3_Polimorfismo.java              │
│ Flexibilidade com @Override + Overload                  │
└─────────────────────────────────────────────────────────┘
                            ↓
┌─────────────────────────────────────────────────────────┐
│ 4️⃣  ABSTRAÇÃO - Aula4_Abstracao.java                    │
│ Simplicidade com abstract + interface                   │
└─────────────────────────────────────────────────────────┘
```

---

## 🎓 MENSAGEM FINAL

Você tem em mãos um curso completo de OO em Java!

- ✅ 4 aulas com exemplos práticos
- ✅ 1 guia completo com exercícios
- ✅ 1 quick reference (cheat sheet)
- ✅ 1 programa executável que demonstra tudo
- ✅ Centenas de linhas de código comentado

**O resto depende de você!**

Estude, pratique, crie, mude, quebre, conserte, aprenda.

## 🌟 Bom estudo! Happy Coding! 🚀

---

**Última atualização:** Abril de 2026  
**Versão:** 1.0  
**Status:** Completo e Funcional ✅

```
╔════════════════════════════════════════════════╗
║ TODOS OS 4 PILARES ESTÃO PRONTOS PARA VOCÊ!   ║
╚════════════════════════════════════════════════╝
```

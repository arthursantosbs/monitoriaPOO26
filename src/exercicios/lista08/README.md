# LISTA 08 - EXCEÇÕES EM JAVA

## 📋 DESCRIÇÃO

Esta lista contém 8 questões práticas sobre tratamento de exceções em Java, cobrindo:

- ✅ Checked vs Unchecked Exceptions
- ✅ Try/Catch/Finally
- ✅ Try-With-Resources
- ✅ Exceções Personalizadas
- ✅ Encadeamento de Exceções
- ✅ Hierarquia de Exceções

## 🚀 COMO EXECUTAR

### Pré-requisitos
- Java 17+
- Arquivos CSV criados (alunos.csv, alunos_q6.csv)

### Compilação e Execução

```bash
# Navegar para o diretório do projeto
cd /home/arthur/IdeaProjects/MonitoriaPOO26

# Compilar todas as questões
javac -cp src src/exercicios/lista08/*.java

# Executar cada questão
java -cp src lista08.Questao01
java -cp src lista08.Questao02
java -cp src lista08.Questao03
java -cp src lista08.Questao04
java -cp src lista08.Questao05
java -cp src lista08.Questao06
java -cp src lista08.Questao07
java -cp src lista08.Questao08
```

## 📝 QUESTÕES

### Questão 1: Validação de Alunos
- **Arquivo:** `Questao01.java`
- **Demonstra:** checked exceptions, try-with-resources, encadeamento
- **Arquivo necessário:** `alunos.csv`

### Questão 2: Sistema de Autenticação
- **Arquivo:** `Questao02.java`
- **Demonstra:** checked exceptions, entrada do usuário
- **Interativo:** Digite login e senha

### Questão 3: Conversor de Notas
- **Arquivo:** `Questao03.java`
- **Demonstra:** checked + unchecked exceptions
- **Interativo:** Digite 5 notas

### Questão 4: Gerenciador de Tarefas
- **Arquivo:** `Questao04.java`
- **Demonstra:** checked vs unchecked, validação de dados

### Questão 5: Conversor para Conceitos
- **Arquivo:** `Questao05.java`
- **Demonstra:** unchecked exceptions, loop de validação
- **Interativo:** Digite nota até ser válida

### Questão 6: Gerador de Relatório
- **Arquivo:** `Questao06.java`
- **Demonstra:** try-with-resources vs finally
- **Arquivo necessário:** `alunos_q6.csv`
- **Gera:** `relatorio_a.txt`, `relatorio_b.txt`

### Questão 7: Sistema de Agendamento
- **Arquivo:** `Questao07.java`
- **Demonstra:** múltiplas checked exceptions, delegação

### Questão 8: Sistema de Pagamentos
- **Arquivo:** `Questao08.java`
- **Demonstra:** hierarquia de exceções, encadeamento

## 📊 ESTRUTURA DOS ARQUIVOS

```
src/lista08/
├── Questao01.java  ← Validação CSV
├── Questao02.java  ← Autenticação
├── Questao03.java  ← Conversor notas
├── Questao04.java  ← Tarefas com prazos
├── Questao05.java  ← Conceitos escolares
├── Questao06.java  ← Relatórios
├── Questao07.java  ← Agendamento oficina
└── Questao08.java  ← Pagamentos
```

## 🎯 CONCEITOS IMPORTANTES

### Checked Exceptions
- Devem ser tratadas ou declaradas
- Ex: `IOException`, `SQLException`
- Usam `throws` na assinatura

### Unchecked Exceptions
- Não obrigatórias de tratar
- Ex: `IllegalArgumentException`, `NullPointerException`
- Herdam de `RuntimeException`

### Try-With-Resources
- Fecha recursos automaticamente
- Implementa `AutoCloseable`
- Mais seguro que `finally`

### Encadeamento
- `new Exception(mensagem, causa)`
- Preserva stack trace original
- Use `getCause()` para acessar

## 📚 REFERÊNCIAS

- [Site do Professor](https://antoniodias.me/docs/disciplinas/poo-ads/)
- Lista 07 disponível em `src/lista07/`

---

**Desenvolvido para a disciplina de POO - Abril 2026**

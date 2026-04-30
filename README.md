# 🎓 PILARES DA ORIENTAÇÃO A OBJETOS - CURSO COMPLETO

Bem-vindo ao curso prático sobre os **4 pilares da Programação Orientada a Objetos** em Java! 

Este projeto contém exemplos práticos, bem organizados e fáceis de entender.

---

## 📁 ESTRUTURA DO PROJETO

```
📦 MonitoriaPOO26
 ┣ 📄 README.md                      ← Você está aqui!
 ┣ 📄 GUIA_COMPLETO.md              ← Guia detalhado com exercícios
 ┣ 📂 src/
 ┃ ┣ 🔵 Main.java                   ← Execute isto (tem todos os exemplos)
 ┃ ┣ 📄 Aula1_Encapsulamento.java   ← Pilar 1: Proteção de dados
 ┃ ┣ 📄 Aula2_Heranca.java          ← Pilar 2: Reutilização
 ┃ ┣ 📄 Aula3_Polimorfismo.java     ← Pilar 3: Múltiplas formas
 ┃ ┣ 📄 Aula4_Abstracao.java        ← Pilar 4: Simplicidade
 ┃ ┣ 📄 CheatSheet.java             ← Quick Reference (resumo)
 ┃ ┗ 📂 exercicios/excecoes/        ← Lista de exercícios sobre exceções
 ┗ 📄 .iml                           ← Configuração do projeto
```

---

## 🚀 COMO USAR

### Opção 1: IDEs (IntelliJ, Eclipse, VS Code com Java Extension)
1. Abra a pasta do projeto
2. Clique Run em `Main.java` (▶️)
3. Veja toda a magia acontecer! ✨

### Opção 2: Terminal
```bash
# Compile todos os arquivos
javac src/*.java

# Execute o programa principal
java -cp src Main
```

---

## 📚 OS 4 PILARES

### 1️⃣ **ENCAPSULAMENTO** - Proteção de Dados

🎯 **Objetivo:** Esconder dados internos e controlar acesso

```java
class ContaBancaria {
    private double saldo;  // Protegido
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;  // Validação
        }
    }
}
```

📁 **Arquivo:** `Aula1_Encapsulamento.java`  
✅ **Exemplos:** Pessoa, ContaBancaria

---

### 2️⃣ **HERANÇA** - Reutilização de Código

🎯 **Objetivo:** Criar hierarquias e compartilhar código

```java
class Animal { /* ... */ }
class Cachorro extends Animal { /* ... */ }
```

📁 **Arquivo:** `Aula2_Heranca.java`  
✅ **Exemplos:** Animal→Cachorro/Gato/Vaca, Veiculo→Carro/Moto

---

### 3️⃣ **POLIMORFISMO** - Múltiplas Formas

🎯 **Objetivo:** Mesmo método, comportamentos diferentes

```java
Animal dog = new Cachorro();
Animal cat = new Gato();

dog.fazer_som();  // "Au au!"
cat.fazer_som();  // "Miau!"
```

📁 **Arquivo:** `Aula3_Polimorfismo.java`  
✅ **Exemplos:** Override (FormaGeometrica), Overload (Calculadora)

---

### 4️⃣ **ABSTRAÇÃO** - Esconder Complexidade

🎯 **Objetivo:** Definir o essencial, esconder implementação

```java
abstract class Veiculo { }      // Classe abstrata
interface Pagavel { }            // Interface
```

📁 **Arquivo:** `Aula4_Abstracao.java`  
✅ **Exemplos:** Classe abstrata (Veiculo), Interface (Animal), Repositório

---

## 💡 RESUMO RÁPIDO

| Pilar | O Quê | Quando | Como |
|-------|-------|--------|------|
| **Encapsulamento** | Proteger dados | Sempre! | `private` + `getters/setters` |
| **Herança** | Reutilizar código | 2-3 níveis | `extends` |
| **Polimorfismo** | Flexibilidade | Subclasses diferentes | `@Override` ou `overload` |
| **Abstração** | Simplificar | Definir contrato | `abstract` ou `interface` |

---

## 🎯 EXEMPLOS PRÁTICOS

### Aula 1: Conta Bancária
```java
ContaBancaria conta = new ContaBancaria("João", "12345");
conta.depositar(1000);   // ✅ Válido
conta.sacar(200);        // ✅ Válido
conta.sacar(2000);       // ❌ Saldo insuficiente (validação!)
```

### Aula 2: Hierarquia de Animais
```java
Cachorro dog = new Cachorro("Rex", 3, "Marrom", true);
dog.fazer_som();      // Au au!
dog.buscar();         // Método específico do Cachorro
```

### Aula 3: Diferentes Pagamentos
```java
MetodoPagamento[] pagamentos = {
    new PagamentoCartao("1234-5678-9012-3456"),
    new PagamentoPix("joao@email.com"),
    new PagamentoBoleto("12345-67890")
};

for (MetodoPagamento pag : pagamentos) {
    pag.processar(100.0);  // Cada uma se comporta diferente!
}
```

### Aula 4: Múltiplos Repositórios
```java
RepositorioDados repo;

repo = new RepositorioEmMemoria();     // Implementação 1
repo = new RepositorioArquivo();       // Implementação 2
repo = new RepositorioBancoDados();    // Implementação 3

repo.salvar(objeto);  // Comportamento diferente cada uma!
```

---

## 🎓 EXERCÍCIOS PRÁTICOS

Desafios para você praticar (veja `GUIA_COMPLETO.md` para detalhes):

1. **Encapsulamento:** Crie classe `Livro` com validação
2. **Herança:** Hierarquia de `Funcionario`
3. **Polimorfismo:** Formas Geométricas
4. **Abstração:** Sistema de Notificação

---

## 📖 CONCEITOS IMPORTANTES

### Modificadores de Acesso
```
private       → Apenas nesta classe
protected     → Nesta classe + subclasses  
public        → Visível em qualquer lugar
(sem)         → Package-private
```

### Palavras-chave
- `extends` - herança de classe
- `implements` - implementação de interface
- `abstract` - classe/método abstrato
- `super` - referência à classe pai
- `@Override` - marca sobrescrita

### Boas Práticas
✅ Sempre use `private` para atributos  
✅ Use `public` para métodos que fazem sentido  
✅ Heranças com máximo 2-3 níveis  
✅ Prefira `interface` para contratos  
✅ Use `@Override` quando sobrescrever  

---

## 🔍 CONSULTA RÁPIDA

### Precisa lembrar algo?
- **Cheat Sheet:** Veja `src/CheatSheet.java`
- **Guia Completo:** Veja `GUIA_COMPLETO.md`
- **Exemplos:** Execute `Main.java`

---

## ⚡ QUICK START

```bash
# Clone ou baixe o projeto
cd MonitoriaPOO26/src

# Compile
javac *.java

# Execute
java Main

# Veja todos os 4 pilares em ação! 🎉
```

---

## 🎯 O QUE VOCÊ VAI APRENDER

Após estudar este material você saberá:

✅ Criar classes com dados protegidos  
✅ Usar herança para reutilizar código  
✅ Aproveitar polimorfismo para flexibilidade  
✅ Usar abstrações para simplicidade  
✅ Combinar os 4 pilares em projetos reais  

---

## 📊 COMPARAÇÃO VISUAL

```
SEM CONHECIMENTO           COM CONHECIMENTO
─────────────────         ──────────────────
public int idade;    →    private int idade;
                          public void setIdade(int i) { }

Copiar-colar código  →    Usar herança

Métodos confusos     →    Polimorfismo claro

Código complexo      →    Abstração limpa
```

---

## 🚦 PRÓXIMOS PASSOS

1. ✅ Leia este README
2. ✅ Execute `Main.java`
3. ✅ Estude cada arquivo de aula
4. ✅ Leia `GUIA_COMPLETO.md`
5. ✅ Faça os exercícios propostos
6. ✅ Adapte exemplos para outros cenários
7. ✅ Estude padrões de design (depois!)

---

## 🤔 DÚVIDAS FREQUENTES

**P: Por que usar `private`?**  
R: Para proteger dados e forçar validação através de setters.

**P: Qual é a diferença entre `abstract` e `interface`?**  
R: `abstract` = herança com código comum. `interface` = contrato puro.

**P: Posso ter múltiplas heranças?**  
R: Não com classes. Mas sim com interfaces!

**P: Quando usar cada pilar?**  
R: Encapsulamento (sempre), Herança (hierarquia), Polimorfismo (flexibilidade), Abstração (contratos).

---

## 📝 NOTAS IMPORTANTES

⚠️ **Este é um projeto educacional**  
- Código comentado e bem estruturado
- Propósito: aprender os conceitos
- Use como base para seus projetos

📌 **Dica:** Não apenas leia o código, ESCREVA seu próprio!

🎓 **Maxima:** _"O melhor jeito de aprender OO é praticando OO"_

---

## 🎓 CRÉDITOS

Desenvolvido para fins educacionais  
**Monitoria:** Programação Orientada a Objetos  
**Linguagem:** Java  
**Data:** Abril de 2026  

---

## 🌟 DIVIRTA-SE!

Este material foi criado pensando em você! 

Explore o código, rode os exemplos, adapte, mude, quebre, conserte.  
**Isso é aprender! 🚀**

---

### 📞 ENTRE EM CONTATO

Dúvidas? Sugestões? Aqui está o que fazer:

1. **Revise os conceitos** em `GUIA_COMPLETO.md`
2. **Estude o código** em cada arquivo
3. **Execute os exemplos** em `Main.java`
4. **Pratique os exercícios** propostos

---

**Bom estudo! Happy Coding! 💻✨**

```
╔════════════════════════════════════════╗
║  VOCÊ VAI APRENDER OO E VAI AMAR! 💪   ║
╚════════════════════════════════════════╝
```

# 📚 PILARES DA ORIENTAÇÃO A OBJETOS - GUIA COMPLETO

## Bem-vindo! Bem-vindo ao curso de OO em Java!

Este projeto contém **4 aulas práticas** sobre os pilares fundamentais da Programação Orientada a Objetos (POO) com exemplos hands-on e bem organizados.

---

## 🎯 ESTRUTURA DO PROJETO

```
MonitoriaPOO26/
├── Main.java                    ← Executa todos os exemplos
├── Aula1_Encapsulamento.java   ← Proteção de dados
├── Aula2_Heranca.java          ← Reutilização de código
├── Aula3_Polimorfismo.java     ← Múltiplas formas
└── Aula4_Abstracao.java        ← Simplicidade
```

---

## 📖 PILARES EXPLICADOS

### 1️⃣ ENCAPSULAMENTO

**O que é?**
O encapsulamento protege os dados internos de uma classe e controla o acesso através de métodos (getters e setters).

**Benefícios:**
- ✅ Proteção de integridade de dados
- ✅ Validação de valores
- ✅ Flexibilidade interna
- ✅ Reduz bugs

**Exemplo Prático:**
```java
class Pessoa {
    private int idade;  // Privado - não pode acessar direto
    
    public void setIdade(int idade) {
        if (idade > 0 && idade < 150) {
            this.idade = idade;  // Valida antes de atribuir
        }
    }
    
    public int getIdade() {
        return idade;
    }
}
```

**Quando usar:**
- Sempre! Use `private` para atributos
- Use `public` apenas para métodos que fazem sentido público

---

### 2️⃣ HERANÇA

**O que é?**
Herança permite que uma classe filha herde atributos e métodos de uma classe pai.

**Benefícios:**
- ✅ Reutilização de código
- ✅ Organização hierárquica
- ✅ Manutenção mais fácil
- ✅ Reduz redundância

**Exemplo Prático:**
```java
class Animal {  // Classe PAI
    protected String nome;
    public void fazer_som() { }
}

class Cachorro extends Animal {  // Classe FILHA
    @Override
    public void fazer_som() {
        System.out.println("Au au!");
    }
}
```

**Conceitos Importantes:**
- `extends` - herda de uma classe
- `super` - acessa construtor/método da classe pai
- `@Override` - sobrescreve método da classe pai

**Quando usar:**
- Quando tem relação "é um" (cachorro É um animal)
- Para compartilhar código comum

---

### 3️⃣ POLIMORFISMO

**O que é?**
Polimorfismo ("muitas formas") permite tratar objetos de classes diferentes através de uma mesma interface.

**Tipos:**

#### A) Sobrescrita (Override)
```java
Animal dog = new Cachorro("Rex");
Animal cat = new Gato("Miau");

dog.fazer_som();  // Au au!
cat.fazer_som();  // Miau!
```

#### B) Sobrecarga (Overload)
```java
public int somar(int a, int b) { return a + b; }
public double somar(double a, double b) { return a + b; }
public int somar(int a, int b, int c) { return a + b + c; }
```

**Benefícios:**
- ✅ Código genérico
- ✅ Flexibilidade
- ✅ Fácil extensão
- ✅ Reduz acoplamento

**Quando usar:**
- Quando diferentes classes fazem a mesma ação de forma diferente
- Para criar código reutilizável

---

### 4️⃣ ABSTRAÇÃO

**O que é?**
Abstração esconde complexidade e mostra apenas o essencial. Usa classes abstratas e interfaces.

**Classes Abstratas:**
```java
abstract class Veiculo {  // Não pode instanciar
    abstract void iniciar();  // Obriga subclasses implementarem
    
    public void exibir() { }  // Método concreto
}
```

**Interfaces:**
```java
interface Animal {
    void fazer_som();
    void mover();
}

class Gato implements Animal {
    @Override
    public void fazer_som() { ... }
    
    @Override
    public void mover() { ... }
}
```

**Benefícios:**
- ✅ Simplicidade
- ✅ Define contratos claros
- ✅ Facilita testes
- ✅ Promove modularidade

**Quando usar:**
- Use classes abstratas para classes relacionadas (herança)
- Use interfaces para contratos não relacionados (implementação)

---

## 🚀 COMO EXECUTAR

### Opção 1: Executar tudo de uma vez
```bash
javac src/*.java
java -cp src Main
```

### Opção 2: Usar sua IDE (recomendado)
1. Abra o arquivo `Main.java`
2. Clique em "Run" (▶️)
3. Veja todos os exemplos em ação!

---

## 📝 EXEMPLOS PRÁTICOS NO CÓDIGO

### Aula 1: Encapsulamento
- **Pessoa** - Classe simples com validação
- **ContaBancaria** - Sistema bancário com transações

### Aula 2: Herança
- **Animal** → Cachorro, Gato, Vaca
- **Veiculo** → Carro, Moto

### Aula 3: Polimorfismo
- **FormaGeometrica** → Circulo, Retangulo, Triangulo
- **MetodoPagamento** → CartãoCredito, PIX, Boleto
- **Funcionario** → Desenvolvedor, Designer, Gerente

### Aula 4: Abstração
- **Veiculo2** (abstrata) → Carro2, Moto2, Bicicleta
- **Animal2** (interface) → Passaro, Pato, Peixe
- **RepositorioDados** (interface) → 3 implementações

---

## 💡 DICAS IMPORTANTES

### ✅ BOAS PRÁTICAS

1. **Use Encapsulamento**
   ```java
   private int idade;  // ✅ Bom
   public int idade;   // ❌ Ruim
   ```

2. **Prefira Composição a Herança Profunda**
   ```java
   // ✅ Melhor
   class Carro {
       private Motor motor;
   }
   
   // ❌ Evite
   class VeiculoTerrestre extends Veiculo ...
   class Carro extends VeiculoTerrestre ...
   ```

3. **Use Interfaces para Contrato**
   ```java
   // ✅ Melhor
   interface Pagavel { }
   
   // ❌ Evite
   abstract class Pagavel { }
   ```

4. **Nomeação Clara**
   ```java
   // ✅ Bom
   public void processarPagamento() { }
   
   // ❌ Ruim
   public void pp() { }
   ```

---

## 🎓 EXERCÍCIOS PROPOSTOS

### Exercício 1: ENCAPSULAMENTO
Crie uma classe `Livro` com:
- Atributos: titulo, autor, isbn, preço
- Getters e setters com validação
- Um método para aplicar desconto

### Exercício 2: HERANÇA
Crie uma hierarquia:
- Classe pai: `Funcionario`
- Subclasses: `Gerente`, `Vendedor`, `Operario`
- Cada uma com bônus diferente

### Exercício 3: POLIMORFISMO
Crie formas geométricas:
- Interface `Forma`
- Classes: `Quadrado`, `Losango`, `Hexagono`
- Calcule área e perímetro

### Exercício 4: ABSTRAÇÃO
Sistema de Notificação:
- Interface `NotificadorAbstrato`
- Implementações: Email, SMS, Push
- Envie mensagens de forma genérica

---

## 📊 COMPARAÇÃO DOS PILARES

| Pilar | Objetivo | Usa | Exemplo |
|-------|----------|-----|---------|
| **Encapsulamento** | Proteger dados | private/public | Banco com validação |
| **Herança** | Reutilizar código | extends | Animal → Cachorro |
| **Polimorfismo** | Múltiplas formas | Override/Overload | Som diferente por animal |
| **Abstração** | Esconder complexidade | abstract/interface | Veículo genérico |

---

## 🔗 RELACIONAMENTO ENTRE OS PILARES

```
ENCAPSULAMENTO (proteção)
        ↓
    used by
        ↓
HERANÇA (compartilha dados protegidos)
        ↓
    enables
        ↓
POLIMORFISMO (trata filhas como pai)
        ↓
    implemented via
        ↓
ABSTRAÇÃO (contrato claro)
```

---

## 📚 RECURSOS ADICIONAIS

### Palavras-chave em Java
- `private` - Acesso apenas na classe
- `protected` - Acesso na classe e subclasses
- `public` - Acesso de qualquer lugar
- `abstract` - Classe/método que deve ser implementado
- `interface` - Contrato que deve ser implementado
- `extends` - Herança de classe
- `implements` - Implementação de interface
- `@Override` - Sobrescrita de método
- `super` - Referência à classe pai

### Bons Livros
- "Head First Design Patterns"
- "Clean Code" - Robert C. Martin
- "Effective Java" - Joshua Bloch

---

## ❓ PERGUNTAS FREQUENTES

**P: Devo usar sempre encapsulamento?**
R: Sim! Use `private` por padrão, mude para `public` apenas quando necessário.

**P: Qual é a diferença entre `abstract` e `interface`?**
R: Classes abstratas para herança (é um), interfaces para contrato (faz).

**P: Posso ter herança múltipla?**
R: Não em Java (com classes). Use interfaces para isso.

**P: Quando devo sobrescrever um método?**
R: Quando a subclasse precisa fazer algo diferente.

---

## 🎉 CONCLUSÃO

Parabéns por aprender os pilares da OO! Agora você sabe:
- ✅ Proteger dados com encapsulamento
- ✅ Reutilizar código com herança
- ✅ Criar flexibilidade com polimorfismo
- ✅ Simplicidade com abstração

**Próximas etapas:**
1. Pratique com os exercícios
2. Estude padrões de design
3. Implemente em projetos reais

---

## 👨‍💻 Autor

Desenvolvido para a disciplina de Programação Orientada a Objetos

**Data:** Abril de 2026
**Versão:** 1.0

---

## 📞 SUPORTE

Dúvidas? Sugestões? Review o código e aprenda!

Lembre-se: **"Ler código é tão importante quanto escrevê-lo!"**

---

**Bom estudo! 🚀📚**


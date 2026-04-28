/**
 * CHEAT SHEET - PILARES DA OO
 * Quick Reference para os 4 pilares da Orientação a Objetos
 */

// ═══════════════════════════════════════════════════════════════════════════
// 1️⃣  ENCAPSULAMENTO - Proteção de Dados
// ═══════════════════════════════════════════════════════════════════════════

class EncapsulamentoExemplo {
    private String dado;              // Private - protegido

    public String getDado() {         // Getter - leitura
        return dado;
    }

    public void setDado(String valor) { // Setter - escrita com validação
        if (valor != null && !valor.isEmpty()) {
            this.dado = valor;
        }
    }
}

// Regras:
// ✅ Atributos devem ser PRIVATE
// ✅ Use getters/setters com validação
// ✅ Getters: public get[Nome]()
// ✅ Setters: public set[Nome](tipo valor)

// ═══════════════════════════════════════════════════════════════════════════
// 2️⃣  HERANÇA - Reutilização de Código
// ═══════════════════════════════════════════════════════════════════════════

class ClassePai {
    protected int atributo;           // Protected - visível para subclasses

    public void metodo() {
        System.out.println("Método da classe pai");
    }
}

class ClasseFilha extends ClassePai {  // EXTENDS = herança

    public ClasseFilha() {
        super();                        // Chama construtor da classe pai (opcional)
    }

    @Override                           // Sobrescreve método da classe pai
    public void metodo() {
        super.metodo();                // Chama método da classe pai
        System.out.println("Método da classe filha");
    }
}

// Regras:
// ✅ Use "extends" para herança
// ✅ Subclasses herdam atributos/métodos protected e public
// ✅ Use "super" para chamar classe pai
// ✅ Use "@Override" ao sobrescrever

// ═══════════════════════════════════════════════════════════════════════════
// 3️⃣  POLIMORFISMO - Muitas Formas
// ═══════════════════════════════════════════════════════════════════════════

// --- TIPO 1: SOBRESCRITA (OVERRIDE) ---
// Exemplo (veja em Aula2_Heranca.java):
/*
class Animal {
    public void fazer_som() {
        System.out.println("Som genérico");
    }
}

class Cachorro extends Animal {
    @Override
    public void fazer_som() {           // Mesmo nome, comportamento diferente
        System.out.println("Au au!");
    }
}
*/

// Uso:
// Animal animal = new Cachorro();
// animal.fazer_som();  // Chama versão do Cachorro (Au au!)

// --- TIPO 2: SOBRECARGA (OVERLOAD) ---
class Calculo {
    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) { // Mesmo nome!
        return a + b;
    }

    public int somar(int a, int b, int c) {   // Mesmo nome!
        return a + b + c;
    }
}

// Uso:
// Calculo calc = new Calculo();
// calc.somar(1, 2);         // Chama primeira
// calc.somar(1.5, 2.5);     // Chama segunda
// calc.somar(1, 2, 3);      // Chama terceira

// Regras OVERRIDE:
// ✅ Mesmo nome de método
// ✅ Mesmos parâmetros
// ✅ Classe filha sobrescreve

// Regras OVERLOAD:
// ✅ Mesmo nome de método
// ✅ Parâmetros DIFERENTES (tipo, quantidade ou ordem)
// ✅ Mesma classe

// ═══════════════════════════════════════════════════════════════════════════
// 4️⃣  ABSTRAÇÃO - Esconder Complexidade
// ═══════════════════════════════════════════════════════════════════════════

// --- CLASSE ABSTRATA ---
abstract class ClasseAbstrata {

    abstract void metodoAbstrato();  // Não tem implementação

    public void metodoConcreto() {   // Tem implementação
        System.out.println("Implementado");
    }
}

class ClasseConcreta extends ClasseAbstrata {

    @Override
    void metodoAbstrato() {           // Obrigado a implementar
        System.out.println("Implementação obrigatória");
    }
}

// Regras de Classes Abstratas:
// ✅ Use "abstract class" para a classe
// ✅ Use "abstract" para métodos sem implementação
// ✅ Não pode instanciar diretamente (new ClasseAbstrata())
// ✅ Subclasses DEVEM implementar métodos abstratos
// ❌ Não pode ter múltipla herança

// --- INTERFACE ---
interface Contrato {
    void metodo1();                  // Implicitamente abstract
    void metodo2();
}

class Implementacao implements Contrato {

    @Override
    public void metodo1() {
        System.out.println("Implementando metodo1");
    }

    @Override
    public void metodo2() {
        System.out.println("Implementando metodo2");
    }
}

// Regras de Interface:
// ✅ Use "interface" para contrato
// ✅ Use "implements" para implementar
// ✅ Uma classe pode implementar múltiplas interfaces
// ✅ Todos os métodos são abstratos (implicitamente)
// ✅ Métodos devem ser public

// ═══════════════════════════════════════════════════════════════════════════
// QUANDO USAR CADA PILAR
// ═══════════════════════════════════════════════════════════════════════════

/*
ENCAPSULAMENTO
- Sempre use em classes
- Proteja dados privados
- Use getters/setters
- Valide dados na entrada

HERANÇA
- Use quando há relação "É UM"
- Exemplo: Cachorro é um Animal
- Compartilhe código comum
- Máximo 2-3 níveis de profundidade

POLIMORFISMO
- Use com herança (override)
- Use com interfaces (múltiplas implementações)
- Permita código genérico
- Exemplo: Pagamento (cartão, PIX, boleto)

ABSTRAÇÃO
- Use classe abstrata para hierarquia
- Use interface para contrato
- Esconda implementação complexa
- Facilite testes e manutenção
*/

// ═══════════════════════════════════════════════════════════════════════════
// MODIFICADORES DE ACESSO
// ═══════════════════════════════════════════════════════════════════════════

class ModificadoresAcesso {

    private int privado;              // Apenas nesta classe
    // ↓ Não é possível acessar em nenhum outro lugar

    protected int protegido;          // Nesta classe + subclasses
    // ↓ Visível em subclasses

    public int publico;               // Visível em qualquer lugar
    // ↓ Não restringe

    // Padrão (sem modificador) = package-private
    int padrao;                       // Apenas neste pacote
}

// ═══════════════════════════════════════════════════════════════════════════
// ANNOTATIONS IMPORTANTES
// ═══════════════════════════════════════════════════════════════════════════

class Annotations {

    @Override                         // Indica sobrescrita
    public String toString() {
        return "Sobrescrita";
    }

    @Deprecated                       // Marca como obsoleto
    public void metodoAntigo() { }

    @SuppressWarnings("unchecked")   // Ignora warning específico
    public void metodoComAviso() { }
}

// ═══════════════════════════════════════════════════════════════════════════
// COMPARAÇÃO RÁPIDA
// ═══════════════════════════════════════════════════════════════════════════

/*
┌─────────────────┬──────────────────┬──────────────────┬─────────────────┐
│ Pilar           │ Usa              │ Objetivo         │ Exemplo         │
├─────────────────┼──────────────────┼──────────────────┼─────────────────┤
│ Encapsulamento  │ private/public   │ Proteger dados   │ Banco           │
│ Herança         │ extends          │ Reutilizar       │ Animal→Cachorro │
│ Polimorfismo    │ @Override        │ Múltiplas formas │ Som diferente   │
│ Abstração       │ abstract/interf. │ Esconder compl.  │ Veículo genér.  │
└─────────────────┴──────────────────┴──────────────────┴─────────────────┘
*/

// ═══════════════════════════════════════════════════════════════════════════
// ERROS COMUNS E COMO EVITAR
// ═══════════════════════════════════════════════════════════════════════════

// ❌ ERRADO: Atributo público
class Errado1 {
    public int idade;  // Qualquer um modifica
}

// ✅ CORRETO: Encapsulado
class Correto1 {
    private int idade;
    public void setIdade(int i) {
        if (i > 0) this.idade = i;
    }
}

// ❌ ERRADO: Herança profunda
// class A extends B extends C extends D extends E { }

// ✅ CORRETO: 2-3 níveis máximo
// class A extends B extends C { }

// ❌ ERRADO: Não usar @Override
// class Filha extends Pai {
//     public void metodo() { }  // Sem @Override
// }

// ✅ CORRETO: Usar @Override
// class Filha extends Pai {
//     @Override
//     public void metodo() { }
// }

// ═══════════════════════════════════════════════════════════════════════════
// DICAS FINAIS
// ═══════════════════════════════════════════════════════════════════════════

/*
💡 DICAS:

1. Sempre use ENCAPSULAMENTO
   - private atributos
   - public métodos

2. HERANÇA é para hierarquia
   - Um pai, vários filhos
   - Relação "É UM"

3. POLIMORFISMO dá flexibilidade
   - Override para herança
   - Overload para mesmo tipo

4. ABSTRAÇÃO simplifica código
   - Use abstract para base
   - Use interface para contrato

5. Prefira COMPOSIÇÃO a HERANÇA
   - Às vezes é melhor ter um objeto dentro de outro

6. Use INTERFACES sempre que possível
   - Melhor que herança para contratos

7. KISS - Keep It Simple, Stupid
   - Não complique demais

8. DRY - Don't Repeat Yourself
   - Use herança para evitar repetição

9. SOLID - Single Responsibility, ...
   - Estude depois!

10. Pratique muito!
    - Código é como música, aprende-se tocando
*/


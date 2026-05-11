package aulas;

/**
 * PILAR 1: ENCAPSULAMENTO
 *
 * O encapsulamento é o processo de esconder os detalhes internos de uma classe
 * e controlar o acesso aos seus atributos através de métodos (getters e setters).
 *
 * Benefícios:
 * - Proteção de dados
 * - Controle de acesso
 * - Flexibilidade para mudanças internas
 * - Validação de dados
 */

// ===== EXEMPLO 1: SEM ENCAPSULAMENTO (ERRADO) =====
class PessoaSemEncapsulamento {
    public String nome;
    public int idade;
    public double salario;

    // Sem encapsulamento, qualquer um pode modificar os dados diretamente
    // Exemplo ruim:
    // pessoa.idade = -5; // Isso é permitido (mas não faz sentido!)
}

// ===== EXEMPLO 2: COM ENCAPSULAMENTO (CORRETO) =====
class Pessoa {
    // Atributos privados (não podem ser acessados diretamente de fora)
    private String nome;
    private int idade;
    private double salario;

    // Construtor
    public Pessoa(String nome, int idade, double salario) {
        this.nome = nome;
        setIdade(idade); // Usa setter para validar
        setSalario(salario); // Usa setter para validar
    }

    // GETTERS - métodos de leitura
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    // SETTERS - métodos de escrita com validação
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Erro: Nome inválido!");
        }
    }

    public void setIdade(int idade) {
        if (idade > 0 && idade < 150) {
            this.idade = idade;
        } else {
            System.out.println("Erro: Idade deve estar entre 1 e 150!");
        }
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        } else {
            System.out.println("Erro: Salário deve ser positivo!");
        }
    }

    // Método de exibição
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", salario=" + salario +
                '}';
    }
}

// ===== EXEMPLO 3: CONTA BANCÁRIA =====
class ContaBancaria {
    private String titular;
    private double saldo;
    private String numeroConta;

    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("✓ Depósito de R$ " + valor + " realizado!");
        } else {
            System.out.println("✗ Valor inválido para depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("✓ Saque de R$ " + valor + " realizado!");
        } else {
            System.out.println("✗ Saque não permitido!");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}

package aulas;

/**
 * PILAR 2: HERANÇA
 *
 * Herança permite que uma classe (filha/subclasse) herde atributos e métodos
 * de outra classe (pai/superclasse). Promove reuso de código e organização hierárquica.
 *
 * Benefícios:
 * - Reutilização de código
 * - Organização hierárquica
 * - Facilita manutenção
 * - Reduz duplicação
 */

// ===== EXEMPLO 1: CLASSE PAI (SUPERCLASSE) =====
class Animal {
    protected String nome;
    protected int idade;
    protected String cor;

    public Animal(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    // Método comum a todos os animais
    public void fazer_som() {
        System.out.println("Som genérico de animal");
    }

    public void dormir() {
        System.out.println(nome + " está dormindo...");
    }

    public void comer(String comida) {
        System.out.println(nome + " está comendo " + comida);
    }

    @Override
    public String toString() {
        return nome + " (idade: " + idade + " anos, cor: " + cor + ")";
    }
}

// ===== EXEMPLO 2: CLASSES FILHAS (SUBCLASSES) =====
class Cachorro extends Animal {
    private boolean adestrado;

    public Cachorro(String nome, int idade, String cor, boolean adestrado) {
        super(nome, idade, cor); // Chama construtor da classe pai
        this.adestrado = adestrado;
    }

    // Sobrescrita (Override) do método fazer_som()
    @Override
    public void fazer_som() {
        System.out.println(nome + " late: Au au au!");
    }

    public void buscar() {
        System.out.println(nome + " foi buscar a bolinha!");
    }

    public void abanarRabo() {
        if (adestrado) {
            System.out.println(nome + " abana o rabo feliz!");
        }
    }
}

class Gato extends Animal {
    private boolean independente;

    public Gato(String nome, int idade, String cor, boolean independente) {
        super(nome, idade, cor);
        this.independente = independente;
    }

    @Override
    public void fazer_som() {
        System.out.println(nome + " mia: Miau miau!");
    }

    public void arranhar(String objeto) {
        System.out.println(nome + " está arranhando " + objeto);
    }
}

class Vaca extends Animal {
    private double litrosLeitePorDia;

    public Vaca(String nome, int idade, String cor, double litros) {
        super(nome, idade, cor);
        this.litrosLeitePorDia = litros;
    }

    @Override
    public void fazer_som() {
        System.out.println(nome + " mugiu: Muuuuu!");
    }

    public double produzirLeite() {
        System.out.println(nome + " produziu " + litrosLeitePorDia + " litros de leite");
        return litrosLeitePorDia;
    }
}

// ===== EXEMPLO 3: HERANÇA DE 2 NÍVEIS =====
class Pinguim extends Animal {
    private double profundidadeMaximaMerge;

    public Pinguim(String nome, int idade, String cor, double profundidade) {
        super(nome, idade, cor);
        this.profundidadeMaximaMerge = profundidade;
    }

    @Override
    public void fazer_som() {
        System.out.println(nome + " pinga: Piu piu piu!");
    }

    public void nadar() {
        System.out.println(nome + " está nadando a " + profundidadeMaximaMerge + " metros de profundidade");
    }
}

// ===== EXEMPLO 4: CLASSE PAI MAIS ESPECÍFICA =====
class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void acelerar() {
        System.out.println("Vruum! " + marca + " " + modelo + " acelerou!");
    }

    public void frear() {
        System.out.println("Pschiu! " + marca + " " + modelo + " freou!");
    }

    public void estacionar() {
        System.out.println(marca + " " + modelo + " estacionou");
    }
}

class Carro extends Veiculo {
    private int portas;

    public Carro(String marca, String modelo, int ano, int portas) {
        super(marca, modelo, ano);
        this.portas = portas;
    }

    public void abrirBau() {
        System.out.println("Baú aberto!");
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + ano + ") - " + portas + " portas";
    }
}

class Moto extends Veiculo {
    private boolean temSidecar;

    public Moto(String marca, String modelo, int ano, boolean temSidecar) {
        super(marca, modelo, ano);
        this.temSidecar = temSidecar;
    }

    public void empinar() {
        System.out.println("A moto " + marca + " empinou!");
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + ano + ")" + (temSidecar ? " COM sidecar" : " SEM sidecar");
    }
}

package aulas;

/**
 * PILAR 4: ABSTRAÇÃO
 *
 * Abstração é o processo de esconder a complexidade e mostrar apenas
 * os recursos essenciais. Define um modelo para o que uma classe ou interface deve fazer.
 *
 * Tipos:
 * 1. Classes Abstratas - Não podem ser instanciadas, servem como modelos
 * 2. Interfaces - Contrato que as classes devem implementar
 *
 * Benefícios:
 * - Simplifica complexidade
 * - Define contratos claros
 * - Facilita compreensão
 * - Promove modularidade
 */

// ===== EXEMPLO 1: CLASSES ABSTRATAS =====
abstract class Veiculo2 {
    protected String marca;
    protected String modelo;

    // Construtor (mesmo sendo abstrata)
    public Veiculo2(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método abstrato - deve ser implementado pelas subclasses
    abstract void iniciar();
    abstract void parar();
    abstract void acelerar();

    // Método concreto - já tem implementação
    public void exibirInfo() {
        System.out.println("Veículo: " + marca + " " + modelo);
    }
}

class Carro2 extends Veiculo2 {
    public Carro2(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    void iniciar() {
        System.out.println("🚗 Carro iniciando - Ligando o motor com chave");
    }

    @Override
    void parar() {
        System.out.println("🚗 Carro parando - Desligando o motor");
    }

    @Override
    void acelerar() {
        System.out.println("🚗 Carro acelerando - Vruum!");
    }
}

class Moto2 extends Veiculo2 {
    public Moto2(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    void iniciar() {
        System.out.println("🏍️  Moto iniciando - Ligando com o botão");
    }

    @Override
    void parar() {
        System.out.println("🏍️  Moto parando - Desligando");
    }

    @Override
    void acelerar() {
        System.out.println("🏍️  Moto acelerando - Brrrrr!");
    }
}

class Bicicleta extends Veiculo2 {
    public Bicicleta(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    void iniciar() {
        System.out.println("🚴 Bicicleta pronta - Sem motor");
    }

    @Override
    void parar() {
        System.out.println("🚴 Bicicleta parando - Acionando freios");
    }

    @Override
    void acelerar() {
        System.out.println("🚴 Bicicleta acelerando - Pedalando mais rápido!");
    }
}

// ===== EXEMPLO 2: INTERFACES =====
interface Animal2 {
    void emitirSom();
    void mover();
    String obterNome();
}

interface Terrestre extends Animal2 {
    void andar();
}

interface Aquatico extends Animal2 {
    void nadar();
}

interface Aereo extends Animal2 {
    void voar();
}

// Implementando uma interface
class Passaro implements Aereo {
    private String nome;

    public Passaro(String nome) {
        this.nome = nome;
    }

    @Override
    public void emitirSom() {
        System.out.println("🦜 " + nome + " canta: Piu piu!");
    }

    @Override
    public void mover() {
        System.out.println("🦜 " + nome + " está se movendo");
    }

    @Override
    public String obterNome() {
        return nome;
    }

    @Override
    public void voar() {
        System.out.println("🦜 " + nome + " está voando alto!");
    }
}

class Gato2 implements Terrestre {
    private String nome;

    public Gato2(String nome) {
        this.nome = nome;
    }

    @Override
    public void emitirSom() {
        System.out.println("🐱 " + nome + " mia: Miau!");
    }

    @Override
    public void mover() {
        System.out.println("🐱 " + nome + " está se movendo");
    }

    @Override
    public String obterNome() {
        return nome;
    }

    @Override
    public void andar() {
        System.out.println("🐱 " + nome + " está andando silenciosamente");
    }
}

class Peixe implements Aquatico {
    private String nome;

    public Peixe(String nome) {
        this.nome = nome;
    }

    @Override
    public void emitirSom() {
        System.out.println("🐠 " + nome + " borbulha: blub blub");
    }

    @Override
    public void mover() {
        System.out.println("🐠 " + nome + " está se movendo");
    }

    @Override
    public String obterNome() {
        return nome;
    }

    @Override
    public void nadar() {
        System.out.println("🐠 " + nome + " está nadando na água");
    }
}

// Implementando múltiplas interfaces
class Pato implements Aereo, Aquatico {
    private String nome;

    public Pato(String nome) {
        this.nome = nome;
    }

    @Override
    public void emitirSom() {
        System.out.println("🦆 " + nome + " quaclola: Quá quá!");
    }

    @Override
    public void mover() {
        System.out.println("🦆 " + nome + " está se movendo");
    }

    @Override
    public String obterNome() {
        return nome;
    }

    @Override
    public void voar() {
        System.out.println("🦆 " + nome + " está voando");
    }

    @Override
    public void nadar() {
        System.out.println("🦆 " + nome + " está nadando");
    }
}

// ===== EXEMPLO 3: SISTEMA DE BANCO DE DADOS =====
interface RepositorioDados {
    void salvar(Object objeto);
    Object buscar(int id);
    void deletar(int id);
    void atualizar(Object objeto);
}

class RepositorioEmMemoria implements RepositorioDados {
    private java.util.Map<Integer, Object> dados = new java.util.HashMap<>();

    @Override
    public void salvar(Object objeto) {
        int id = dados.size() + 1;
        dados.put(id, objeto);
        System.out.println("💾 Objeto salvo em memória com ID: " + id);
    }

    @Override
    public Object buscar(int id) {
        System.out.println("🔍 Buscando na memória ID: " + id);
        return dados.get(id);
    }

    @Override
    public void deletar(int id) {
        dados.remove(id);
        System.out.println("🗑️  Objeto deletado da memória");
    }

    @Override
    public void atualizar(Object objeto) {
        System.out.println("🔄 Objeto atualizado em memória");
    }
}

class RepositorioArquivo implements RepositorioDados {
    @Override
    public void salvar(Object objeto) {
        System.out.println("💾 Objeto salvo em arquivo");
    }

    @Override
    public Object buscar(int id) {
        System.out.println("🔍 Buscando em arquivo ID: " + id);
        return null;
    }

    @Override
    public void deletar(int id) {
        System.out.println("🗑️  Objeto deletado de arquivo");
    }

    @Override
    public void atualizar(Object objeto) {
        System.out.println("🔄 Objeto atualizado em arquivo");
    }
}

class RepositorioBancoDados implements RepositorioDados {
    @Override
    public void salvar(Object objeto) {
        System.out.println("💾 Objeto salvo no banco de dados");
    }

    @Override
    public Object buscar(int id) {
        System.out.println("🔍 Buscando no banco de dados ID: " + id);
        return null;
    }

    @Override
    public void deletar(int id) {
        System.out.println("🗑️  Objeto deletado do banco de dados");
    }

    @Override
    public void atualizar(Object objeto) {
        System.out.println("🔄 Objeto atualizado no banco de dados");
    }
}

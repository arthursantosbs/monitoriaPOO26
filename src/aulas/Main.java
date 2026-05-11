package aulas;

/**
 * AULAS PRÁTICAS - PILARES DA ORIENTAÇÃO A OBJETOS
 * ================================================
 *
 * Este programa demonstra os 4 pilares da OO com exemplos práticos:
 * 1. Encapsulamento - Proteção de dados
 * 2. Herança - Reutilização de código
 * 3. Polimorfismo - Muitas formas
 * 4. Abstração - Simplicidade
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("=" .repeat(60));
        System.out.println("PILARES DA ORIENTAÇÃO A OBJETOS - EXEMPLOS PRÁTICOS");
        System.out.println("=" .repeat(60));

        // ===== AULA 1: ENCAPSULAMENTO =====
        System.out.println("\n📚 AULA 1: ENCAPSULAMENTO\n");
        System.out.println("Escondendo dados internos e controlando acesso\n");

        Pessoa pessoa1 = new Pessoa("João Silva", 25, 3500.0);
        System.out.println("✓ Pessoa criada: " + pessoa1);

        // Tentando valores inválidos (serão validados)
        System.out.println("\n-- Tentando valores inválidos --");
        pessoa1.setIdade(-5);
        pessoa1.setIdade(200);
        pessoa1.setSalario(-1000);

        // Valores válidos
        System.out.println("\n-- Valores válidos --");
        pessoa1.setIdade(26);
        pessoa1.setSalario(4000.0);
        System.out.println("✓ Pessoa atualizada: " + pessoa1);

        // Exemplo com conta bancária
        System.out.println("\n-- Sistema Bancário --");
        ContaBancaria conta = new ContaBancaria("Maria Santos", "12345-67");
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Conta: " + conta.getNumeroConta());
        System.out.println("Saldo: R$ " + conta.getSaldo());

        conta.depositar(1000);
        conta.sacar(300);
        conta.sacar(5000); // Tentativa de saque inválida
        System.out.println("Saldo final: R$ " + conta.getSaldo());

        // ===== AULA 2: HERANÇA =====
        System.out.println("\n\n" + "=" .repeat(60));
        System.out.println("📚 AULA 2: HERANÇA\n");
        System.out.println("Reutilização de código através de hierarquia\n");

        // Criando diferentes tipos de animais
        System.out.println("-- Animais (Classe Pai: Animal) --");
        Cachorro dog = new Cachorro("Rex", 3, "Marrom", true);
        System.out.println("Animal: " + dog);
        dog.fazer_som();
        dog.buscar();
        dog.abanarRabo();
        dog.comer("ração");

        System.out.println();
        Gato gato = new Gato("Miau", 2, "Branco", true);
        System.out.println("Animal: " + gato);
        gato.fazer_som();
        gato.arranhar("sofá");
        gato.comer("ração");

        System.out.println();
        Vaca vaca = new Vaca("Margarida", 5, "Branca e Preta", 20.0);
        System.out.println("Animal: " + vaca);
        vaca.fazer_som();
        vaca.produzirLeite();
        vaca.dormir();

        // Veículos
        System.out.println("\n-- Veículos (Classe Pai: Veiculo) --");
        Carro carro = new Carro("Toyota", "Corolla", 2023, 4);
        System.out.println("Veículo: " + carro);
        carro.acelerar();
        carro.abrirBau();
        carro.frear();

        System.out.println();
        Moto moto = new Moto("Honda", "CB 500", 2022, false);
        System.out.println("Veículo: " + moto);
        moto.acelerar();
        moto.empinar();
        moto.frear();

        // ===== AULA 3: POLIMORFISMO =====
        System.out.println("\n\n" + "=" .repeat(60));
        System.out.println("📚 AULA 3: POLIMORFISMO\n");
        System.out.println("Uma interface, múltiplas implementações\n");

        // Polimorfismo 1: Override - Formas Geométricas
        System.out.println("-- Formas Geométricas (Polimorfismo de Sobrescrita) --");
        FormaGeometrica[] formas = {
            new Circulo(5),
            new Retangulo(4, 6),
            new Triangulo(3, 4, 5)
        };

        for (FormaGeometrica forma : formas) {
            forma.exibir();
            System.out.println("   Área: " + String.format("%.2f", forma.calcularArea()));
            System.out.println("   Perímetro: " + String.format("%.2f", forma.calcularPerimetro()));
            System.out.println();
        }

        // Polimorfismo 2: Overload - Calculadora
        System.out.println("-- Calculadora (Polimorfismo de Sobrecarga) --");
        Calculadora calc = new Calculadora();
        System.out.println("Soma de inteiros: " + calc.somar(10, 20));
        System.out.println("Soma de reais: " + calc.somar(10.5, 20.3));
        System.out.println("Soma de 3 números: " + calc.somar(10, 20, 30));
        System.out.println("Concatenação: " + calc.somar("Olá", " Mundo"));

        // Polimorfismo 3: Métodos de Pagamento
        System.out.println("\n-- Métodos de Pagamento (Polimorfismo) --");
        MetodoPagamento[] pagamentos = {
            new PagamentoCartao("1234-5678-9012-3456"),
            new PagamentoPix("joao@email.com"),
            new PagamentoBoleto("12345-67890")
        };

        double valor = 150.0;
        for (MetodoPagamento pag : pagamentos) {
            System.out.println("\nTipo: " + pag.obterTipo());
            pag.processar(valor);
        }

        // Polimorfismo 4: Folha de Pagamento
        System.out.println("\n-- Folha de Pagamento (Polimorfismo) --");
        Funcionario[] funcionarios = {
            new Desenvolvedor("Carlos"),
            new Designer("Ana"),
            new Gerente("Pedro")
        };

        double salario = 5000.0;
        for (Funcionario func : funcionarios) {
            System.out.println("\nCargo: " + func.obterCargo());
            func.trabalhar();
            func.receberSalario(salario);
        }

        // ===== AULA 4: ABSTRAÇÃO =====
        System.out.println("\n\n" + "=" .repeat(60));
        System.out.println("📚 AULA 4: ABSTRAÇÃO\n");
        System.out.println("Escondendo complexidade e mostrando essencial\n");

        // Abstração 1: Classes Abstratas - Veículos
        System.out.println("-- Ciclo de Vida dos Veículos (Classes Abstratas) --");
        Veiculo2[] veiculos = {
            new Carro2("Ford", "Focus"),
            new Moto2("Yamaha", "YZF-R1"),
            new Bicicleta("Caloi", "Mountain Bike")
        };

        for (Veiculo2 veiculo : veiculos) {
            veiculo.exibirInfo();
            veiculo.iniciar();
            veiculo.acelerar();
            veiculo.parar();
            System.out.println();
        }

        // Abstração 2: Interfaces - Animais
        System.out.println("-- Diferentes Tipos de Animais (Interfaces) --");
        Animal2[] animais = {
            new Passaro("Papagaio"),
            new Gato2("Felicidade"),
            new Peixe("Nemo"),
            new Pato("Donald")
        };

        for (Animal2 animal : animais) {
            System.out.println("Nome: " + animal.obterNome());
            animal.emitirSom();
            animal.mover();
            System.out.println();
        }

        // Chamando métodos específicos
        System.out.println("-- Ações Específicas --");
        Passaro passaro = new Passaro("Tucano");
        passaro.voar();

        Gato2 gato2 = new Gato2("Whiskers");
        gato2.andar();

        Pato pato = new Pato("Donald");
        pato.nadar();
        pato.voar();

        // Abstração 3: Repositório de Dados
        System.out.println("\n-- Repositórios de Dados (Abstração) --");
        System.out.println("\nUsando Repositório em Memória:");
        RepositorioDados repo1 = new RepositorioEmMemoria();
        repo1.salvar("Dados de teste");
        repo1.buscar(1);

        System.out.println("\nUsando Repositório em Arquivo:");
        RepositorioDados repo2 = new RepositorioArquivo();
        repo2.salvar("Dados de teste");
        repo2.buscar(1);

        System.out.println("\nUsando Repositório em Banco de Dados:");
        RepositorioDados repo3 = new RepositorioBancoDados();
        repo3.salvar("Dados de teste");
        repo3.buscar(1);

        // ===== RESUMO FINAL =====
        System.out.println("\n\n" + "=" .repeat(60));
        System.out.println("✅ RESUMO DOS 4 PILARES DA ORIENTAÇÃO A OBJETOS");
        System.out.println("=" .repeat(60));
        System.out.println("""
            
            1️⃣  ENCAPSULAMENTO
                ✓ Esconde dados internos
                ✓ Valida dados através de setters
                ✓ Protege a integridade dos objetos
            
            2️⃣  HERANÇA
                ✓ Reutiliza código em classe pai
                ✓ Cria hierarquias de classes
                ✓ Reduz duplicação de código
            
            3️⃣  POLIMORFISMO
                ✓ Múltiplas formas de um método (Override)
                ✓ Mesmo nome, parâmetros diferentes (Overload)
                ✓ Código genérico e flexível
            
            4️⃣  ABSTRAÇÃO
                ✓ Esconde complexidade
                ✓ Define contratos (interfaces)
                ✓ Facilita manutenção e extensão
            
            """);
        System.out.println("=" .repeat(60));
    }
}

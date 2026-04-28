/**
 * PILAR 3: POLIMORFISMO
 *
 * Polimorfismo significa "muitas formas". Permite que um objeto seja tratado
 * como um objeto de uma classe pai, mas execute métodos específicos da classe filha.
 *
 * Tipos:
 * 1. Polimorfismo de Sobrescrita (Override)
 * 2. Polimorfismo de Sobrecarga (Overload)
 *
 * Benefícios:
 * - Flexibilidade
 * - Código genérico e reutilizável
 * - Facilita extensão do código
 * - Reduz acoplamento
 */

// ===== EXEMPLO 1: POLIMORFISMO DE SOBRESCRITA (OVERRIDE) =====
abstract class FormaGeometrica {
    protected String nome;

    public FormaGeometrica(String nome) {
        this.nome = nome;
    }

    // Método abstrato - obriga subclasses a implementar
    abstract double calcularArea();
    abstract double calcularPerimetro();
    abstract void exibir();
}

class Circulo extends FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        super("Círculo");
        this.raio = raio;
    }

    @Override
    double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    void exibir() {
        System.out.println("🔴 Círculo - Raio: " + raio);
    }
}

class Retangulo extends FormaGeometrica {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        super("Retângulo");
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    double calcularArea() {
        return largura * altura;
    }

    @Override
    double calcularPerimetro() {
        return 2 * (largura + altura);
    }

    @Override
    void exibir() {
        System.out.println("▭ Retângulo - Largura: " + largura + ", Altura: " + altura);
    }
}

class Triangulo extends FormaGeometrica {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        super("Triângulo");
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    double calcularArea() {
        // Fórmula de Heron
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    void exibir() {
        System.out.println("△ Triângulo - Lados: " + lado1 + ", " + lado2 + ", " + lado3);
    }
}

// ===== EXEMPLO 2: POLIMORFISMO DE SOBRECARGA (OVERLOAD) =====
class Calculadora {
    // Mesmo nome de método, mas com parâmetros diferentes

    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }

    public String somar(String a, String b) {
        return a + b;
    }

    // Mesma ideia com outras operações
    public int subtrair(int a, int b) {
        return a - b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }
}

// ===== EXEMPLO 3: SISTEMA DE PAGAMENTO =====
interface MetodoPagamento {
    void processar(double valor);
    String obterTipo();
}

class PagamentoCartao implements MetodoPagamento {
    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processar(double valor) {
        System.out.println("💳 Pagamento com cartão: R$ " + valor);
        System.out.println("   Cartão: " + numeroCartao.substring(numeroCartao.length() - 4));
    }

    @Override
    public String obterTipo() {
        return "Cartão de Crédito";
    }
}

class PagamentoPix implements MetodoPagamento {
    private String chave;

    public PagamentoPix(String chave) {
        this.chave = chave;
    }

    @Override
    public void processar(double valor) {
        System.out.println("📱 Pagamento com PIX: R$ " + valor);
        System.out.println("   Chave: " + chave);
    }

    @Override
    public String obterTipo() {
        return "PIX";
    }
}

class PagamentoBoleto implements MetodoPagamento {
    private String codigoBoleto;

    public PagamentoBoleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public void processar(double valor) {
        System.out.println("📄 Pagamento com boleto: R$ " + valor);
        System.out.println("   Código: " + codigoBoleto);
    }

    @Override
    public String obterTipo() {
        return "Boleto";
    }
}

// ===== EXEMPLO 4: MAQUINA DE FUNCIONARIOS =====
interface Funcionario {
    void trabalhar();
    void receberSalario(double valor);
    String obterCargo();
}

class Desenvolvedor implements Funcionario {
    private String nome;

    public Desenvolvedor(String nome) {
        this.nome = nome;
    }

    @Override
    public void trabalhar() {
        System.out.println("👨‍💻 " + nome + " está desenvolvendo código...");
    }

    @Override
    public void receberSalario(double valor) {
        System.out.println("   Salário recebido: R$ " + valor);
    }

    @Override
    public String obterCargo() {
        return "Desenvolvedor";
    }
}

class Designer implements Funcionario {
    private String nome;

    public Designer(String nome) {
        this.nome = nome;
    }

    @Override
    public void trabalhar() {
        System.out.println("🎨 " + nome + " está criando designs...");
    }

    @Override
    public void receberSalario(double valor) {
        System.out.println("   Salário recebido: R$ " + valor);
    }

    @Override
    public String obterCargo() {
        return "Designer";
    }
}

class Gerente implements Funcionario {
    private String nome;

    public Gerente(String nome) {
        this.nome = nome;
    }

    @Override
    public void trabalhar() {
        System.out.println("👔 " + nome + " está gerenciando projetos...");
    }

    @Override
    public void receberSalario(double valor) {
        System.out.println("   Salário recebido: R$ " + valor);
    }

    @Override
    public String obterCargo() {
        return "Gerente";
    }
}


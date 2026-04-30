package LIsta07;

/**
 * QUESTÃO 03: MOTOR DE DESCONTOS PARA E-COMMERCE
 *
 * Problema: Sistema de descontos que precisa ser extensível
 * sem modificar o código existente.
 *
 * Solução: Strategy Pattern com interface para regras de desconto.
 */

// Classe para representar um item do carrinho
class ItemCarrinho {
    private String nome;
    private double preco;
    private int quantidade;

    public ItemCarrinho(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

// Classe para representar o carrinho de compras
class CarrinhoCompras {
    private java.util.List<ItemCarrinho> itens = new java.util.ArrayList<>();
    private double frete;

    public CarrinhoCompras(double frete) {
        this.frete = frete;
    }

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public double getSubtotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public int getItensDistintos() {
        return itens.size();
    }

    public int getQuantidadeTotal() {
        int total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getQuantidade();
        }
        return total;
    }
}

// Interface para regras de desconto
interface RegraDesconto {
    boolean aplicar(CarrinhoCompras carrinho);
    double calcularDesconto(CarrinhoCompras carrinho);
    String descricao();
}

// Implementações das regras de desconto
class DescontoValorMinimo implements RegraDesconto {
    public boolean aplicar(CarrinhoCompras carrinho) {
        return carrinho.getSubtotal() > 300;
    }

    public double calcularDesconto(CarrinhoCompras carrinho) {
        return carrinho.getSubtotal() * 0.10; // 10%
    }

    public String descricao() {
        return "10% do subtotal";
    }
}

class DescontoSegundaUnidade implements RegraDesconto {
    public boolean aplicar(CarrinhoCompras carrinho) {
        return carrinho.getItensDistintos() >= 2;
    }

    public double calcularDesconto(CarrinhoCompras carrinho) {
        return 50.0; // R$ 50 desconto
    }

    public String descricao() {
        return "R$ 50 desconto";
    }
}

class FreteGratis implements RegraDesconto {
    public boolean aplicar(CarrinhoCompras carrinho) {
        return carrinho.getQuantidadeTotal() > 5;
    }

    public double calcularDesconto(CarrinhoCompras carrinho) {
        return 15.0; // frete grátis
    }

    public String descricao() {
        return "Frete grátis";
    }
}

// Motor de descontos
class MotorDescontos {
    public RegraDesconto selecionarMelhorRegra(CarrinhoCompras carrinho, java.util.List<RegraDesconto> regras) {
        RegraDesconto melhor = null;
        double maiorDesconto = 0;

        for (RegraDesconto regra : regras) {
            if (regra.aplicar(carrinho)) {
                double desconto = regra.calcularDesconto(carrinho);
                if (desconto > maiorDesconto) {
                    maiorDesconto = desconto;
                    melhor = regra;
                }
            }
        }

        return melhor;
    }
}

// Classe de teste
public class Questao03 {
    public static void main(String[] args) {
        // Criando carrinho
        CarrinhoCompras carrinho = new CarrinhoCompras(15.0);
        carrinho.adicionarItem(new ItemCarrinho("Produto A", 200, 1));
        carrinho.adicionarItem(new ItemCarrinho("Produto B", 150, 1));

        // Criando regras
        java.util.List<RegraDesconto> regras = java.util.Arrays.asList(
            new DescontoValorMinimo(),
            new DescontoSegundaUnidade(),
            new FreteGratis()
        );

        // Executando motor
        MotorDescontos motor = new MotorDescontos();
        RegraDesconto melhorRegra = motor.selecionarMelhorRegra(carrinho, regras);

        if (melhorRegra != null) {
            System.out.println("Regra selecionada: " + melhorRegra.descricao());
            System.out.println("Valor do desconto: R$ " + melhorRegra.calcularDesconto(carrinho));
        } else {
            System.out.println("Nenhuma regra aplicável");
        }
    }
}

/**
 * LISTA 07 - EXERCÍCIOS SIMPLIFICADOS DE POO
 * ==========================================
 *
 * Site do Professor: https://antoniodias.me/docs/disciplinas/poo-ads/exercicios/lista07/
 *
 * Este arquivo contém apenas o essencial de cada exercício.
 * Foco: simplicidade para alunos de monitoria.
 */

package lista07;

// ========================================
// QUESTÃO 01: SISTEMA FISCAL SIMPLES
// ========================================

interface DocumentoFiscal {
    double calcularImposto(double valor);
    String gerarXML(String id);
}

class NFE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.18; // 18%
    }
    public String gerarXML(String id) {
        return "<nfe>" + id + "</nfe>";
    }
}

class CTE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.12; // 12%
    }
    public String gerarXML(String id) {
        return "<cte>" + id + "</cte>";
    }
}

class NFSE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.05; // 5%
    }
    public String gerarXML(String id) {
        return "<nfse>" + id + "</nfse>";
    }
}

class MDFE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.08; // 8%
    }
    public String gerarXML(String id) {
        return "<mdfe>" + id + "</mdfe>";
    }
}

class ProcessadorFiscal {
    public String processar(DocumentoFiscal doc, double valor, String id) {
        double imposto = doc.calcularImposto(valor);
        String xml = doc.gerarXML(id);
        return xml + "|imposto:" + imposto;
    }
}

// ========================================
// QUESTÃO 02: ARMAZENAMENTO SIMPLES
// ========================================

interface Armazenamento {
    void gravar(String caminho, byte[] dados);
    byte[] ler(String caminho);
}

class ArmazenamentoNuvem implements Armazenamento {
    private java.util.Map<String, byte[]> storage = new java.util.HashMap<>();

    public void gravar(String caminho, byte[] dados) {
        storage.put(caminho, dados);
    }

    public byte[] ler(String caminho) {
        return storage.get(caminho);
    }
}

class ArmazenamentoComCache implements Armazenamento {
    private Armazenamento real;
    private java.util.Map<String, byte[]> cache = new java.util.HashMap<>();

    public ArmazenamentoComCache(Armazenamento real) {
        this.real = real;
    }

    public void gravar(String caminho, byte[] dados) {
        cache.put(caminho, dados);
        real.gravar(caminho, dados); // SEMPRE grava na nuvem
    }

    public byte[] ler(String caminho) {
        byte[] dados = cache.get(caminho);
        if (dados != null) return dados;
        dados = real.ler(caminho);
        if (dados != null) cache.put(caminho, dados);
        return dados;
    }
}

// ========================================
// QUESTÃO 03: DESCONTOS SIMPLES
// ========================================

class ItemCarrinho {
    private String nome;
    private double preco;
    private int quantidade;

    public ItemCarrinho(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getSubtotal() { return preco * quantidade; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
}

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

    public int getItensDistintos() { return itens.size(); }

    public int getQuantidadeTotal() {
        int total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getQuantidade();
        }
        return total;
    }
}

interface RegraDesconto {
    boolean aplicar(CarrinhoCompras carrinho);
    double calcularDesconto(CarrinhoCompras carrinho);
    String descricao();
}

class DescontoValorMinimo implements RegraDesconto {
    public boolean aplicar(CarrinhoCompras carrinho) {
        return carrinho.getSubtotal() > 300;
    }
    public double calcularDesconto(CarrinhoCompras carrinho) {
        return carrinho.getSubtotal() * 0.10;
    }
    public String descricao() { return "10% do subtotal"; }
}

class DescontoSegundaUnidade implements RegraDesconto {
    public boolean aplicar(CarrinhoCompras carrinho) {
        return carrinho.getItensDistintos() >= 2;
    }
    public double calcularDesconto(CarrinhoCompras carrinho) {
        return 50.0; // desconto fixo
    }
    public String descricao() { return "R$ 50 desconto"; }
}

class FreteGratis implements RegraDesconto {
    public boolean aplicar(CarrinhoCompras carrinho) {
        return carrinho.getQuantidadeTotal() > 5;
    }
    public double calcularDesconto(CarrinhoCompras carrinho) {
        return 15.0; // frete fixo
    }
    public String descricao() { return "Frete grátis"; }
}

class MotorDescontos {
    public RegraDesconto melhorRegra(CarrinhoCompras carrinho, java.util.List<RegraDesconto> regras) {
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

// ========================================
// QUESTÃO 04: LOG SIMPLES
// ========================================

abstract class LogFormatter {
    protected String prefixo = "[INFO]";
    protected String extra = "";

    public String getPrefixo() { return prefixo; }
    public String getExtra() { return extra; }

    public String timestamp() {
        return java.time.LocalDateTime.now().format(
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
    }

    public String formatar(String msg) {
        return getPrefixo() + " " + timestamp() + " " + msg + getExtra();
    }
}

class LogFormatterSeguro extends LogFormatter {
    public LogFormatterSeguro() {
        this.prefixo = "[SEC]";
        this.extra = " [AUDITORIA]";
    }

    @Override
    public String timestamp() {
        return java.time.LocalDateTime.now(java.time.ZoneOffset.UTC)
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

class LogFormatterErro extends LogFormatter {
    public LogFormatterErro() {
        this.prefixo = "[ERROR]";
        this.extra = " [ERRO]";
    }
}

// ========================================
// DEMONSTRAÇÃO SIMPLES
// ========================================

public class LISTA07_EXERCICIOS {

    public static void main(String[] args) {
        System.out.println("LISTA 07 - SIMPLIFICADA\n");

        questao1();
        questao2();
        questao3();
        questao4();
    }

    static void questao1() {
        System.out.println("Q1: Sistema Fiscal");
        ProcessadorFiscal p = new ProcessadorFiscal();

        System.out.println("NFE: " + p.processar(new NFE(), 1000, "DOC1"));
        System.out.println("CTE: " + p.processar(new CTE(), 1000, "DOC2"));
        System.out.println("NFSE: " + p.processar(new NFSE(), 1000, "DOC3"));
        System.out.println("MDFE: " + p.processar(new MDFE(), 1000, "DOC4"));
        System.out.println();
    }

    static void questao2() {
        System.out.println("Q2: Armazenamento com Cache");
        Armazenamento nuvem = new ArmazenamentoNuvem();
        Armazenamento cache = new ArmazenamentoComCache(nuvem);

        nuvem.gravar("teste.txt", "dados originais".getBytes());
        System.out.println("Do cache: " + new String(cache.ler("teste.txt")));
        System.out.println();
    }

    static void questao3() {
        System.out.println("Q3: Descontos");
        CarrinhoCompras carrinho = new CarrinhoCompras(15.0);
        carrinho.adicionarItem(new ItemCarrinho("Produto A", 200, 1));
        carrinho.adicionarItem(new ItemCarrinho("Produto B", 150, 1));

        java.util.List<RegraDesconto> regras = java.util.Arrays.asList(
            new DescontoValorMinimo(),
            new DescontoSegundaUnidade(),
            new FreteGratis()
        );

        MotorDescontos motor = new MotorDescontos();
        RegraDesconto regra = motor.melhorRegra(carrinho, regras);

        if (regra != null) {
            System.out.println("Regra: " + regra.descricao());
            System.out.println("Desconto: R$ " + regra.calcularDesconto(carrinho));
        }
        System.out.println();
    }

    static void questao4() {
        System.out.println("Q4: Sistema de Log");
        LogFormatter padrao = new LogFormatter() {};
        LogFormatter seguro = new LogFormatterSeguro();
        LogFormatter erro = new LogFormatterErro();

        System.out.println("Padrao: " + padrao.formatar("Mensagem"));
        System.out.println("Seguro: " + seguro.formatar("Mensagem"));
        System.out.println("Erro: " + erro.formatar("Mensagem"));
        System.out.println();
    }
}

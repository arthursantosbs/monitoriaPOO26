/**
 * LISTA 07 - EXERCÍCIOS DE PROGRAMAÇÃO ORIENTADA A OBJETOS
 * ========================================================
 *
 * Site do Professor: https://antoniodias.me/docs/disciplinas/poo-ads/exercicios/lista07/
 * Disciplina: Programação Orientada a Objetos (POO)
 * Professor: Antonio Dias
 *
 * Este arquivo contém TODAS as questões da Lista 07 organizadas em um único arquivo.
 * Cada questão está separada por comentários e implementada seguindo as restrições.
 *
 * INSTRUÇÕES GERAIS DA LISTA:
 * - Cada questão deve ser implementada no pacote indicado (lista07.q1, lista07.q2, etc.)
 * - Todos os exercícios devem ser feitos em um único projeto do IntelliJ
 * - Os nomes de classes, métodos e pacotes devem ser EXATAMENTE os especificados
 * - Todos os exercícios serão corrigidos por execução de testes JUnit 4
 * - Não há casos de teste para esta lista (devem ser criados manualmente)
 */

package lista07;

// ============================================================================
// QUESTÃO 01: SISTEMA DE AUTOMAÇÃO FISCAL COM POLIMORFISMO
// ============================================================================

/**
 * QUESTÃO 01: Refatoração do Sistema Fiscal
 *
 * PROBLEMA ORIGINAL:
 * O método processar() centraliza cálculo de imposto e geração de XML para todos os tipos de documento.
 * Quando precisamos adicionar um novo tipo (MDF-e), temos que modificar o método existente que já está em produção.
 *
 * SOLUÇÃO:
 * Usar polimorfismo para que cada tipo de documento saiba calcular seu próprio imposto e gerar seu próprio XML.
 * O ProcessadorFiscal não conhece os tipos concretos - trabalha com uma interface comum.
 */

// Interface que define o contrato para todos os documentos fiscais
interface DocumentoFiscal {
    double calcularImposto(double valor);
    String gerarXML(String identificador);
    String getTipo();
}

// Implementação para NF-e (Nota Fiscal Eletrônica)
class NFE implements DocumentoFiscal {
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.18; // 18% de imposto
    }

    @Override
    public String gerarXML(String identificador) {
        return "<nfe>" + identificador + "</nfe>";
    }

    @Override
    public String getTipo() {
        return "NFE";
    }
}

// Implementação para CT-e (Conhecimento de Transporte Eletrônico)
class CTE implements DocumentoFiscal {
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.12; // 12% de imposto
    }

    @Override
    public String gerarXML(String identificador) {
        return "<cte>" + identificador + "</cte>";
    }

    @Override
    public String getTipo() {
        return "CTE";
    }
}

// Implementação para NFS-e (Nota Fiscal de Serviços Eletrônica)
class NFSE implements DocumentoFiscal {
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.05; // 5% de imposto
    }

    @Override
    public String gerarXML(String identificador) {
        return "<nfse>" + identificador + "</nfse>";
    }

    @Override
    public String getTipo() {
        return "NFSE";
    }
}

// Implementação para MDF-e (Manifesto de Documentos Fiscais Eletrônico) - NOVO TIPO
class MDFE implements DocumentoFiscal {
    @Override
    public double calcularImposto(double valor) {
        return valor * 0.08; // 8% de imposto
    }

    @Override
    public String gerarXML(String identificador) {
        return "<mdfe>" + identificador + "</mdfe>";
    }

    @Override
    public String getTipo() {
        return "MDFE";
    }
}

// Processador Fiscal refatorado - não conhece tipos concretos
class ProcessadorFiscal {
    /**
     * Método processar que funciona com qualquer tipo de documento fiscal.
     * Não usa switch, if-else ou instanceof - trabalha com polimorfismo.
     */
    public String processar(DocumentoFiscal documento, double valor, String identificador) {
        double imposto = documento.calcularImposto(valor);
        String xml = documento.gerarXML(identificador);
        return xml + "|imposto:" + String.format("%.2f", imposto);
    }
}

// ============================================================================
// QUESTÃO 02: SISTEMA DE ARMAZENAMENTO COM CACHE - VIOLAÇÃO DO LSP
// ============================================================================

/**
 * QUESTÃO 02: Problema do Princípio da Substituição de Liskov (LSP)
 *
 * PRINCÍPIO VIOLADO: Liskov Substitution Principle (LSP)
 * "Objetos de uma superclasse devem poder ser substituídos por objetos de suas subclasses
 * sem quebrar o funcionamento do sistema."
 *
 * PROBLEMA:
 * ArmazenamentoComCache extends ArmazenamentoNuvem, mas:
 * - Ao gravar, NÃO chama super.gravar() - dados ficam apenas no cache
 * - Ao ler, retorna apenas do cache, ignorando dados da nuvem
 *
 * ISSO QUEBRA O LSP porque:
 * - Quando usamos ArmazenamentoComCache como destino do backup, dados não vão para nuvem
 * - Quando usamos como origem, dados gravados por outros nós não são encontrados
 *
 * SOLUÇÃO:
 * - Remover herança entre ArmazenamentoComCache e ArmazenamentoNuvem
 * - Usar composição: ArmazenamentoComCache TEM UM ArmazenamentoNuvem
 * - Implementar interface comum para ambos
 */

// Interface comum para todos os tipos de armazenamento
interface Armazenamento {
    void gravar(String caminho, byte[] dados);
    byte[] ler(String caminho);
}

// Implementação do armazenamento em nuvem
class ArmazenamentoNuvem implements Armazenamento {
    private java.util.Map<String, byte[]> storage = new java.util.HashMap<>();

    @Override
    public void gravar(String caminho, byte[] dados) {
        storage.put(caminho, dados);
    }

    @Override
    public byte[] ler(String caminho) {
        return storage.get(caminho);
    }
}

// Implementação com cache - usa composição, não herança
class ArmazenamentoComCache implements Armazenamento {
    private Armazenamento armazenamentoReal; // Composição!
    private java.util.Map<String, byte[]> cache = new java.util.HashMap<>();

    public ArmazenamentoComCache(Armazenamento armazenamentoReal) {
        this.armazenamentoReal = armazenamentoReal;
    }

    @Override
    public void gravar(String caminho, byte[] dados) {
        cache.put(caminho, dados); // Cache local
        armazenamentoReal.gravar(caminho, dados); // SEMPRE grava na nuvem também!
    }

    @Override
    public byte[] ler(String caminho) {
        // Primeiro tenta no cache
        byte[] dados = cache.get(caminho);
        if (dados != null) {
            return dados;
        }
        // Se não está no cache, busca na nuvem e armazena no cache
        dados = armazenamentoReal.ler(caminho);
        if (dados != null) {
            cache.put(caminho, dados);
        }
        return dados;
    }
}

// Método de backup que funciona com qualquer implementação
class BackupService {
    public void realizarBackup(Armazenamento origem, Armazenamento destino, java.util.List<String> caminhos) {
        for (String caminho : caminhos) {
            byte[] dados = origem.ler(caminho);
            if (dados != null) {
                destino.gravar(caminho, dados);
            }
        }
    }
}

// ============================================================================
// QUESTÃO 03: MOTOR DE DESCONTOS PARA E-COMMERCE
// ============================================================================

/**
 * QUESTÃO 03: Sistema de Descontos Extensível
 *
 * PROBLEMA:
 * E-commerce precisa de motor de descontos que seja extensível.
 * Novas regras promocionais são frequentemente adicionadas.
 *
 * SOLUÇÃO:
 * - Interface RegraDesconto define contrato
 * - MotorDescontos trabalha com qualquer implementação
 * - Strategy Pattern para seleção da melhor regra
 */

// Representa um item do carrinho
class ItemCarrinho {
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public ItemCarrinho(String nome, double precoUnitario, int quantidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public double getPrecoUnitario() { return precoUnitario; }
    public int getQuantidade() { return quantidade; }
    public double getSubtotal() { return precoUnitario * quantidade; }
}

// Representa o carrinho de compras
class CarrinhoCompras {
    private java.util.List<ItemCarrinho> itens;
    private double frete;

    public CarrinhoCompras(double frete) {
        this.itens = new java.util.ArrayList<>();
        this.frete = frete;
    }

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public java.util.List<ItemCarrinho> getItens() { return itens; }
    public double getFrete() { return frete; }

    public double getSubtotal() {
        return itens.stream().mapToDouble(ItemCarrinho::getSubtotal).sum();
    }

    public int getTotalItensDistintos() {
        return itens.size();
    }

    public int getTotalQuantidade() {
        return itens.stream().mapToInt(ItemCarrinho::getQuantidade).sum();
    }

    public double getPrecoMaisBarato() {
        return itens.stream().mapToDouble(ItemCarrinho::getPrecoUnitario).min().orElse(0);
    }
}

// Interface para regras de desconto
interface RegraDesconto {
    boolean isAplicavel(CarrinhoCompras carrinho);
    double calcularDesconto(CarrinhoCompras carrinho);
    String getDescricao();
}

// Regra: Desconto por valor mínimo (subtotal > R$ 300 = 10% do subtotal)
class DescontoValorMinimo implements RegraDesconto {
    @Override
    public boolean isAplicavel(CarrinhoCompras carrinho) {
        return carrinho.getSubtotal() > 300;
    }

    @Override
    public double calcularDesconto(CarrinhoCompras carrinho) {
        return carrinho.getSubtotal() * 0.10;
    }

    @Override
    public String getDescricao() {
        return "Desconto por valor mínimo (10% do subtotal)";
    }
}

// Regra: Desconto segunda unidade (2+ itens distintos = 50% do item mais barato)
class DescontoSegundaUnidade implements RegraDesconto {
    @Override
    public boolean isAplicavel(CarrinhoCompras carrinho) {
        return carrinho.getTotalItensDistintos() >= 2;
    }

    @Override
    public double calcularDesconto(CarrinhoCompras carrinho) {
        return carrinho.getPrecoMaisBarato() * 0.50;
    }

    @Override
    public String getDescricao() {
        return "Desconto segunda unidade (50% do item mais barato)";
    }
}

// Regra: Frete grátis (soma quantidades > 5 = frete gratuito)
class FreteGratis implements RegraDesconto {
    @Override
    public boolean isAplicavel(CarrinhoCompras carrinho) {
        return carrinho.getTotalQuantidade() > 5;
    }

    @Override
    public double calcularDesconto(CarrinhoCompras carrinho) {
        return carrinho.getFrete();
    }

    @Override
    public String getDescricao() {
        return "Frete grátis";
    }
}

// Motor de descontos - Strategy Pattern
class MotorDescontos {
    public RegraDesconto selecionarMelhorRegra(CarrinhoCompras carrinho, java.util.List<RegraDesconto> regras) {
        RegraDesconto melhorRegra = null;
        double maiorDesconto = 0;

        for (RegraDesconto regra : regras) {
            if (regra.isAplicavel(carrinho)) {
                double desconto = regra.calcularDesconto(carrinho);
                if (desconto > maiorDesconto) {
                    maiorDesconto = desconto;
                    melhorRegra = regra;
                }
            }
        }

        return melhorRegra; // null se nenhuma regra aplicável
    }
}

// ============================================================================
// QUESTÃO 04: SISTEMA DE LOG COM POLIMORFISMO CORRETO
// ============================================================================

/**
 * QUESTÃO 04: Problemas com Polimorfismo em Atributos e Métodos Estáticos
 *
 * PROBLEMAS IDENTIFICADOS:
 *
 * 1) ATRIBUTOS: Resolução é ESTÁTICA (não dinâmica)
 *    - log.prefixo imprime "[INFO]" porque atributos são resolvidos em tempo de compilação
 *    - O tipo declarado da variável (LogFormatter) determina qual atributo é acessado
 *    - Isso se chama "resolução estática de campo"
 *
 * 2) MÉTODOS ESTÁTICOS: Não há polimorfismo
 *    - LogFormatter.timestamp() sempre chama a versão da classe LogFormatter
 *    - Métodos estáticos são resolvidos em tempo de compilação pela classe de declaração
 *    - Subclasses não podem sobrescrever métodos estáticos
 *
 * SOLUÇÃO:
 * - Tornar atributos protegidos e usar getters polimórficos
 * - Remover métodos estáticos e usar métodos de instância
 * - Permitir que subclasses sobrescrevam comportamentos
 */

// Classe base corrigida
abstract class LogFormatter {
    protected String prefixo = "[INFO]";
    protected String marcacao = "";

    // Método de instância (não estático) - permite polimorfismo
    public String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // Getter polimórfico para prefixo
    public String getPrefixo() {
        return prefixo;
    }

    // Getter polimórfico para marcação
    public String getMarcacao() {
        return marcacao;
    }

    public String formatar(String mensagem) {
        return getPrefixo() + " " + getTimestamp() + " " + mensagem + getMarcacao();
    }
}

// Subclasse para logs seguros
class LogFormatterSeguro extends LogFormatter {
    public LogFormatterSeguro() {
        this.prefixo = "[SEC]";
        this.marcacao = " [AUDITORIA]";
    }

    // Timestamp em UTC (sobrescrevendo método da superclasse)
    @Override
    public String getTimestamp() {
        return java.time.LocalDateTime.now(java.time.ZoneOffset.UTC)
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

// Nova subclasse para logs de erro
class LogFormatterErro extends LogFormatter {
    public LogFormatterErro() {
        this.prefixo = "[ERROR]";
        this.marcacao = " [ERRO CRÍTICO]";
    }
    // Timestamp padrão herdado (não sobrescreve)
}

// Sistema de log que demonstra polimorfismo
class SistemaLog {
    public java.util.List<String> formatarMensagem(java.util.List<LogFormatter> formatadores, String mensagem) {
        java.util.List<String> resultados = new java.util.ArrayList<>();
        for (LogFormatter formatter : formatadores) {
            resultados.add(formatter.formatar(mensagem));
        }
        return resultados;
    }
}

// ============================================================================
// DEMONSTRAÇÃO DE TODAS AS QUESTÕES
// ============================================================================

public class LISTA07_EXERCICIOS {

    public static void main(String[] args) {
        System.out.println("=== LISTA 07 - EXERCÍCIOS DE POO ===\n");

        // QUESTÃO 01: Sistema Fiscal
        demonstrarQuestao01();

        // QUESTÃO 02: Sistema de Armazenamento
        demonstrarQuestao02();

        // QUESTÃO 03: Motor de Descontos
        demonstrarQuestao03();

        // QUESTÃO 04: Sistema de Log
        demonstrarQuestao04();
    }

    private static void demonstrarQuestao01() {
        System.out.println("QUESTÃO 01: Sistema Fiscal com Polimorfismo");
        System.out.println("==========================================");

        ProcessadorFiscal processador = new ProcessadorFiscal();

        // Criando diferentes tipos de documento
        DocumentoFiscal nfe = new NFE();
        DocumentoFiscal cte = new CTE();
        DocumentoFiscal nfse = new NFSE();
        DocumentoFiscal mdfe = new MDFE(); // Novo tipo adicionado sem modificar código existente

        double valor = 1000.0;
        String identificador = "DOC123";

        // Processando cada tipo - polimorfismo em ação
        System.out.println("NF-e:  " + processador.processar(nfe, valor, identificador));
        System.out.println("CT-e:  " + processador.processar(cte, valor, identificador));
        System.out.println("NFS-e: " + processador.processar(nfse, valor, identificador));
        System.out.println("MDF-e: " + processador.processar(mdfe, valor, identificador));

        System.out.println();
    }

    private static void demonstrarQuestao02() {
        System.out.println("QUESTÃO 02: Violação do LSP e Correção");
        System.out.println("=====================================");

        // Cenário de falha original (comentado porque não compila mais)
        // ArmazenamentoNuvem origem = new ArmazenamentoComCache(); // LSP violado
        // ArmazenamentoNuvem destino = new ArmazenamentoComCache(); // Dados não vão para nuvem

        // Solução correta com interface comum
        Armazenamento nuvem = new ArmazenamentoNuvem();
        Armazenamento cache = new ArmazenamentoComCache(nuvem); // Composição

        BackupService backup = new BackupService();

        // Simulando backup
        java.util.List<String> caminhos = java.util.Arrays.asList("arquivo1.txt", "arquivo2.txt");

        // Gravando dados na nuvem
        nuvem.gravar("arquivo1.txt", "dados do arquivo 1".getBytes());
        nuvem.gravar("arquivo2.txt", "dados do arquivo 2".getBytes());

        // Backup nuvem -> cache (agora funciona!)
        backup.realizarBackup(nuvem, cache, caminhos);

        // Verificando se dados estão no cache
        System.out.println("Arquivo 1 no cache: " + new String(cache.ler("arquivo1.txt")));
        System.out.println("Arquivo 2 no cache: " + new String(cache.ler("arquivo2.txt")));

        System.out.println();
    }

    private static void demonstrarQuestao03() {
        System.out.println("QUESTÃO 03: Motor de Descontos");
        System.out.println("==============================");

        // Criando carrinho com 4 itens
        CarrinhoCompras carrinho = new CarrinhoCompras(15.0); // Frete de R$ 15

        carrinho.adicionarItem(new ItemCarrinho("Notebook", 2500.0, 1));
        carrinho.adicionarItem(new ItemCarrinho("Mouse", 50.0, 2));
        carrinho.adicionarItem(new ItemCarrinho("Teclado", 150.0, 1));
        carrinho.adicionarItem(new ItemCarrinho("Monitor", 800.0, 1));

        System.out.println("Carrinho:");
        System.out.println("- Subtotal: R$ " + carrinho.getSubtotal());
        System.out.println("- Frete: R$ " + carrinho.getFrete());
        System.out.println("- Total itens distintos: " + carrinho.getTotalItensDistintos());
        System.out.println("- Total quantidade: " + carrinho.getTotalQuantidade());

        // Criando regras de desconto
        java.util.List<RegraDesconto> regras = java.util.Arrays.asList(
            new DescontoValorMinimo(),
            new DescontoSegundaUnidade(),
            new FreteGratis()
        );

        // Executando motor de descontos
        MotorDescontos motor = new MotorDescontos();
        RegraDesconto melhorRegra = motor.selecionarMelhorRegra(carrinho, regras);

        if (melhorRegra != null) {
            System.out.println("\nRegra selecionada: " + melhorRegra.getDescricao());
            System.out.println("Valor do desconto: R$ " + melhorRegra.calcularDesconto(carrinho));
        } else {
            System.out.println("\nNenhuma regra aplicável.");
        }

        System.out.println();
    }

    private static void demonstrarQuestao04() {
        System.out.println("QUESTÃO 04: Sistema de Log com Polimorfismo Correto");
        System.out.println("==================================================");

        // Criando instâncias dos três formatadores
        LogFormatter formatterPadrao = new LogFormatter() {}; // Classe anônima para classe abstrata
        LogFormatter formatterSeguro = new LogFormatterSeguro();
        LogFormatter formatterErro = new LogFormatterErro();

        // Lista tipada pela superclasse
        java.util.List<LogFormatter> formatadores = java.util.Arrays.asList(
            formatterPadrao, formatterSeguro, formatterErro
        );

        // Sistema de log demonstrando polimorfismo
        SistemaLog sistema = new SistemaLog();
        java.util.List<String> mensagensFormatadas = sistema.formatarMensagem(formatadores, "Sistema iniciado");

        // Imprimindo resultados
        String[] nomes = {"Padrão", "Seguro", "Erro"};
        for (int i = 0; i < mensagensFormatadas.size(); i++) {
            System.out.println(nomes[i] + ": " + mensagensFormatadas.get(i));
        }

        System.out.println();
    }
}

/**
 * RESUMO DA LISTA 07:
 *
 * Q1 - POLIMORFISMO: Refatora sistema fiscal para usar Strategy Pattern,
 *     permitindo adicionar novos tipos sem modificar código existente.
 *
 * Q2 - LSP: Demonstra violação do princípio e corrige usando composição
 *     ao invés de herança problemática.
 *
 * Q3 - EXTENSIBILIDADE: Motor de descontos que trabalha com qualquer regra
 *     através de interface comum, seguindo Open/Closed Principle.
 *
 * Q4 - POLIMORFISMO CORRETO: Corrige problemas com atributos estáticos
 *     e métodos estáticos, permitindo verdadeiro polimorfismo.
 *
 * CONCEITOS PRINCIPAIS:
 * - Strategy Pattern
 * - Liskov Substitution Principle
 * - Open/Closed Principle
 * - Polimorfismo verdadeiro vs resolução estática
 * - Composição vs Herança
 */

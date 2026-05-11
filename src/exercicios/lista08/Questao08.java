package exercicios.lista08;

/**
 * QUESTÃO 08: SISTEMA DE PAGAMENTOS COM HIERARQUIA DE EXCEÇÕES
 *
 * Demonstra: hierarquia de exceções, encadeamento, polimorfismo em exceções
 */

import java.time.YearMonth;

// Hierarquia de exceções
class PagamentoException extends Exception {
    public PagamentoException(String mensagem) {
        super(mensagem);
    }

    public PagamentoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

class SaldoInsuficienteException extends PagamentoException {
    private double saldoDisponivel;
    private double valorSolicitado;

    public SaldoInsuficienteException(double saldoDisponivel, double valorSolicitado) {
        super("Saldo insuficiente. Disponível: R$ " + saldoDisponivel + ", solicitado: R$ " + valorSolicitado);
        this.saldoDisponivel = saldoDisponivel;
        this.valorSolicitado = valorSolicitado;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public double getValorSolicitado() {
        return valorSolicitado;
    }
}

class CartaoExpiradoException extends PagamentoException {
    private YearMonth validade;

    public CartaoExpiradoException(YearMonth validade) {
        super("Cartão expirado. Validade: " + validade);
        this.validade = validade;
    }

    public YearMonth getValidade() {
        return validade;
    }
}

// Classe processadora
class ProcessadorDePagamento {
    public void pagarComSaldo(double valor, double saldoDisponivel) throws SaldoInsuficienteException {
        if (valor > saldoDisponivel) {
            throw new SaldoInsuficienteException(saldoDisponivel, valor);
        }
        System.out.println("Pagamento com saldo realizado: R$ " + valor);
    }

    public void pagarComCartao(double valor, String validadeStr) throws CartaoExpiradoException {
        YearMonth validade = YearMonth.parse(validadeStr);
        YearMonth atual = YearMonth.now();

        if (validade.isBefore(atual)) {
            throw new CartaoExpiradoException(validade);
        }
        System.out.println("Pagamento com cartão realizado: R$ " + valor);
    }

    public void realizarPagamento(double valor, String meio, double saldo, String validade) throws PagamentoException {
        try {
            if ("saldo".equals(meio)) {
                pagarComSaldo(valor, saldo);
            } else if ("cartao".equals(meio)) {
                pagarComCartao(valor, validade);
            } else {
                throw new PagamentoException("Meio de pagamento inválido: " + meio);
            }
        } catch (SaldoInsuficienteException | CartaoExpiradoException e) {
            throw new PagamentoException("Falha no processamento do pagamento", e);
        }
    }
}

// Classe principal
public class Questao08 {
    public static void main(String[] args) {
        ProcessadorDePagamento processador = new ProcessadorDePagamento();

        // Cenário 1: Saldo insuficiente
        try {
            processador.realizarPagamento(100.0, "saldo", 50.0, null);
        } catch (PagamentoException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Tipo da causa: " + e.getCause().getClass().getSimpleName());
            if (e.getCause() instanceof SaldoInsuficienteException) {
                SaldoInsuficienteException causa = (SaldoInsuficienteException) e.getCause();
                System.out.println("Saldo disponível: R$ " + causa.getSaldoDisponivel());
                System.out.println("Valor solicitado: R$ " + causa.getValorSolicitado());
            }
        }

        System.out.println();

        // Cenário 2: Cartão expirado
        try {
            processador.realizarPagamento(200.0, "cartao", 0, "2023-12");
        } catch (PagamentoException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Tipo da causa: " + e.getCause().getClass().getSimpleName());
            if (e.getCause() instanceof CartaoExpiradoException) {
                CartaoExpiradoException causa = (CartaoExpiradoException) e.getCause();
                System.out.println("Validade do cartão: " + causa.getValidade());
            }
        }

        System.out.println();

        // Cenário 3: Sucesso
        try {
            processador.realizarPagamento(50.0, "saldo", 100.0, null);
        } catch (PagamentoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

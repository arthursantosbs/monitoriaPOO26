package exercicios.excecoes.exercicio04;

import java.time.YearMonth;
import java.util.Locale;

public class Exercicio04 {
    public static void main(String[] args) {
        ProcessadorDePagamento processador = new ProcessadorDePagamento();
        String validadeFutura = YearMonth.now()
                .plusMonths(6)
                .format(ProcessadorDePagamento.FORMATADOR_VALIDADE);
        String validadeExpirada = YearMonth.now()
                .minusMonths(1)
                .format(ProcessadorDePagamento.FORMATADOR_VALIDADE);

        testarPagamento(processador, 200.00, "saldo", 50.00, validadeFutura);
        testarPagamento(processador, 120.00, "cartao", 1000.00, validadeExpirada);
    }

    private static void testarPagamento(
            ProcessadorDePagamento processador,
            double valor,
            String meio,
            double saldo,
            String validade
    ) {
        System.out.println();
        System.out.println("Tentando pagamento por " + meio + "...");

        try {
            processador.realizarPagamento(valor, meio, saldo, validade);
        } catch (PagamentoException e) {
            exibirErroPagamento(e);
        }
    }

    private static void exibirErroPagamento(PagamentoException erro) {
        System.out.println("Mensagem da PagamentoException: " + erro.getMessage());

        Throwable causa = erro.getCause();

        if (causa == null) {
            System.out.println("Nao existe causa original encadeada.");
            return;
        }

        System.out.println("Tipo da causa original: " + causa.getClass().getSimpleName());

        if (causa instanceof SaldoInsuficienteException) {
            SaldoInsuficienteException saldo = (SaldoInsuficienteException) causa;
            System.out.println("Saldo disponivel: " + formatarValor(saldo.getSaldoDisponivel()));
            System.out.println("Valor solicitado: " + formatarValor(saldo.getValorSolicitado()));
        } else if (causa instanceof CartaoExpiradoException) {
            CartaoExpiradoException cartao = (CartaoExpiradoException) causa;
            System.out.println("Validade do cartao: " + cartao.getValidadeFormatada());
        }
    }

    private static String formatarValor(double valor) {
        return String.format(Locale.US, "%.2f", valor);
    }
}

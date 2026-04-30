package exercicios.excecoes.exercicio04;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ProcessadorDePagamento {
    public static final DateTimeFormatter FORMATADOR_VALIDADE = DateTimeFormatter.ofPattern("MM/uuuu");

    public void pagarComSaldo(double valor, double saldoDisponivel) throws SaldoInsuficienteException {
        if (valor > saldoDisponivel) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente para concluir o pagamento.",
                    saldoDisponivel,
                    valor
            );
        }

        System.out.println("Pagamento com saldo aprovado no valor de " + formatarValor(valor) + ".");
    }

    public void pagarComCartao(double valor, String validadeCartao) throws CartaoExpiradoException {
        YearMonth validade = YearMonth.parse(validadeCartao, FORMATADOR_VALIDADE);

        if (validade.isBefore(YearMonth.now())) {
            throw new CartaoExpiradoException(
                    "Cartao expirado. Nao foi possivel concluir o pagamento.",
                    validade
            );
        }

        System.out.println("Pagamento com cartao aprovado no valor de " + formatarValor(valor) + ".");
    }

    public void realizarPagamento(double valor, String meio, double saldo, String validade)
            throws PagamentoException {
        try {
            String meioNormalizado = meio == null ? "" : meio.toLowerCase(Locale.ROOT);

            switch (meioNormalizado) {
                case "saldo":
                    pagarComSaldo(valor, saldo);
                    break;
                case "cartao":
                    pagarComCartao(valor, validade);
                    break;
                default:
                    throw new PagamentoException("Meio de pagamento nao suportado: " + meio);
            }
        } catch (SaldoInsuficienteException | CartaoExpiradoException e) {
            throw new PagamentoException("Falha ao realizar pagamento por " + meio + ".", e);
        }
    }

    private String formatarValor(double valor) {
        return String.format(Locale.US, "%.2f", valor);
    }
}

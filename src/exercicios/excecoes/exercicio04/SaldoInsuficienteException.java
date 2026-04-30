package exercicios.excecoes.exercicio04;

public class SaldoInsuficienteException extends PagamentoException {
    private final double saldoDisponivel;
    private final double valorSolicitado;

    public SaldoInsuficienteException(String mensagem, double saldoDisponivel, double valorSolicitado) {
        super(mensagem);
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

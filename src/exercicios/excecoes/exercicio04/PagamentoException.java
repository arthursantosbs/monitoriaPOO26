package exercicios.excecoes.exercicio04;

public class PagamentoException extends Exception {
    public PagamentoException(String mensagem) {
        super(mensagem);
    }

    public PagamentoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

package exercicios.excecoes.exercicio04;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class CartaoExpiradoException extends PagamentoException {
    private static final DateTimeFormatter FORMATADOR_VALIDADE = DateTimeFormatter.ofPattern("MM/uuuu");

    private final YearMonth validadeCartao;

    public CartaoExpiradoException(String mensagem, YearMonth validadeCartao) {
        super(mensagem);
        this.validadeCartao = validadeCartao;
    }

    public YearMonth getValidadeCartao() {
        return validadeCartao;
    }

    public String getValidadeFormatada() {
        return validadeCartao.format(FORMATADOR_VALIDADE);
    }
}

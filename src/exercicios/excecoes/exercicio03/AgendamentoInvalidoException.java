package exercicios.excecoes.exercicio03;

public class AgendamentoInvalidoException extends Exception {
    private final String horarioInvalido;

    public AgendamentoInvalidoException(String mensagem, String horarioInvalido) {
        super(mensagem);
        this.horarioInvalido = horarioInvalido;
    }

    public String getHorarioInvalido() {
        return horarioInvalido;
    }
}

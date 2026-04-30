package exercicios.excecoes.exercicio03;

public class HorarioIndisponivelException extends Exception {
    private final String horario;

    public HorarioIndisponivelException(String mensagem, String horario) {
        super(mensagem);
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
}

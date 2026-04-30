package exercicios.excecoes.exercicio03;

public class Exercicio03 {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        try {
            agenda.agendar("08:00", "Ana");
            System.out.println("Agendamento realizado para Ana as 08:00.");
        } catch (HorarioIndisponivelException | AgendamentoInvalidoException e) {
            System.out.println("Erro ao agendar: " + e.getMessage());
        }

        try {
            agenda.agendar("08:00", "Bruno");
        } catch (HorarioIndisponivelException e) {
            System.out.println("Horario indisponivel: " + e.getMessage());
            System.out.println("Horario solicitado: " + e.getHorario());
        } catch (AgendamentoInvalidoException e) {
            System.out.println("Agendamento invalido: " + e.getMessage());
        }

        try {
            agenda.agendar("12:00", "Carla");
        } catch (HorarioIndisponivelException e) {
            System.out.println("Horario indisponivel: " + e.getMessage());
        } catch (AgendamentoInvalidoException e) {
            System.out.println("Agendamento invalido: " + e.getMessage());
            System.out.println("Horario invalido informado: " + e.getHorarioInvalido());
        }

        try {
            agenda.agendarOuSugerir("10:00", "Daniel");
            System.out.println("Agendamento realizado para Daniel as 10:00.");
        } catch (HorarioIndisponivelException | AgendamentoInvalidoException e) {
            System.out.println("Erro tratado pelo chamador: " + e.getMessage());
        }

        System.out.println();
        agenda.listarAgendamentos();
    }
}

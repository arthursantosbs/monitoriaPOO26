package exercicios.excecoes.exercicio03;

import java.util.LinkedHashMap;
import java.util.Map;

public class Agenda {
    private final Map<String, String> agendamentos = new LinkedHashMap<>();

    public Agenda() {
        agendamentos.put("08:00", null);
        agendamentos.put("10:00", null);
        agendamentos.put("14:00", null);
        agendamentos.put("16:00", null);
    }

    public void agendar(String horario, String cliente)
            throws HorarioIndisponivelException, AgendamentoInvalidoException {
        if (!agendamentos.containsKey(horario)) {
            throw new AgendamentoInvalidoException(
                    "O horario " + horario + " nao existe na agenda da oficina.",
                    horario
            );
        }

        String clienteAgendado = agendamentos.get(horario);

        if (clienteAgendado != null) {
            throw new HorarioIndisponivelException(
                    "O horario " + horario + " ja esta ocupado por " + clienteAgendado + ".",
                    horario
            );
        }

        agendamentos.put(horario, cliente);
    }

    public void agendarOuSugerir(String horario, String cliente)
            throws HorarioIndisponivelException, AgendamentoInvalidoException {
        agendar(horario, cliente);
    }

    public void listarAgendamentos() {
        System.out.println("Agendamentos da oficina:");

        for (Map.Entry<String, String> entrada : agendamentos.entrySet()) {
            String horario = entrada.getKey();
            String cliente = entrada.getValue();
            String status = cliente == null ? "Livre" : cliente;

            System.out.println(horario + " - " + status);
        }
    }
}

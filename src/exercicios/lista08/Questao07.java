package lista08;

/**
 * QUESTÃO 07: SISTEMA DE AGENDAMENTO DE OFICINA
 *
 * Demonstra: múltiplas checked exceptions, delegação de tratamento
 */

import java.util.HashMap;
import java.util.Map;

// Exceções checked
class HorarioIndisponivelException extends Exception {
    private String horario;

    public HorarioIndisponivelException(String mensagem, String horario) {
        super(mensagem);
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
}

class AgendamentoInvalidoException extends Exception {
    private String horario;

    public AgendamentoInvalidoException(String mensagem, String horario) {
        super(mensagem);
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
}

// Classe Agenda
class Agenda {
    private Map<String, String> agendamentos;
    private String[] horariosDisponiveis = {"08:00", "10:00", "14:00", "16:00"};

    public Agenda() {
        agendamentos = new HashMap<>();
        for (String horario : horariosDisponiveis) {
            agendamentos.put(horario, null); // null = livre
        }
    }

    public void agendar(String horario, String cliente) throws HorarioIndisponivelException, AgendamentoInvalidoException {
        if (!agendamentos.containsKey(horario)) {
            throw new AgendamentoInvalidoException("Horário inválido: " + horario + " não existe", horario);
        }

        if (agendamentos.get(horario) != null) {
            throw new HorarioIndisponivelException("Horário " + horario + " já ocupado por " + agendamentos.get(horario), horario);
        }

        agendamentos.put(horario, cliente);
        System.out.println("Agendamento realizado: " + cliente + " às " + horario);
    }

    public void agendarOuSugerir(String horario, String cliente) throws HorarioIndisponivelException, AgendamentoInvalidoException {
        agendar(horario, cliente); // Delega tratamento
    }

    public void listarAgendamentos() {
        System.out.println("Agendamentos:");
        for (Map.Entry<String, String> entry : agendamentos.entrySet()) {
            String cliente = entry.getValue() != null ? entry.getValue() : "LIVRE";
            System.out.println(entry.getKey() + " - " + cliente);
        }
    }
}

// Classe principal
public class Questao07 {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Situação 1: Agendamento válido
        try {
            agenda.agendar("08:00", "João");
        } catch (HorarioIndisponivelException | AgendamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Situação 2: Horário ocupado
        try {
            agenda.agendar("08:00", "Maria");
        } catch (HorarioIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (AgendamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Situação 3: Horário inválido
        try {
            agenda.agendar("12:00", "Pedro");
        } catch (HorarioIndisponivelException | AgendamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Usando agendarOuSugerir (delegação)
        try {
            agenda.agendarOuSugerir("10:00", "Ana");
        } catch (HorarioIndisponivelException | AgendamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
        agenda.listarAgendamentos();
    }
}

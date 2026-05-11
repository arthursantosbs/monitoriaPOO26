package exercicios.lista08;

/**
 * QUESTÃO 04: GERENCIADOR DE TAREFAS COM PRAZOS
 *
 * Demonstra: checked vs unchecked exceptions, validação de dados
 */

import java.time.LocalDate;

// Exceção unchecked
class TarefaInvalidaException extends RuntimeException {
    public TarefaInvalidaException(String mensagem) {
        super(mensagem);
    }
}

// Exceção checked
class PrazoExpiradoException extends Exception {
    private LocalDate prazo;

    public PrazoExpiradoException(String mensagem, LocalDate prazo) {
        super(mensagem);
        this.prazo = prazo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }
}

// Classe Tarefa
class Tarefa {
    private String titulo;
    private LocalDate prazo;
    private boolean concluida;

    public Tarefa(String titulo, LocalDate prazo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new TarefaInvalidaException("O título da tarefa não pode ser nulo ou vazio");
        }
        if (prazo == null) {
            throw new TarefaInvalidaException("O prazo da tarefa não pode ser nulo");
        }
        this.titulo = titulo;
        this.prazo = prazo;
        this.concluida = false;
    }

    public void concluir() throws PrazoExpiradoException {
        this.concluida = true;
        if (LocalDate.now().isAfter(prazo)) {
            throw new PrazoExpiradoException("A tarefa '" + titulo + "' foi concluída após o prazo", prazo);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }
}

// Classe principal
public class Questao04 {
    public static void main(String[] args) {
        // Criar tarefas
        Tarefa tarefa1 = null;
        Tarefa tarefa2 = null;
        Tarefa tarefa3 = null;

        try {
            System.out.println("Criando tarefa: Estudar exceções...");
            tarefa1 = new Tarefa("Estudar exceções", LocalDate.now().plusDays(7));
            System.out.println("OK");
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("Criando tarefa com título vazio...");
            tarefa2 = new Tarefa("", LocalDate.now().plusDays(1));
            System.out.println("OK");
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("Criando tarefa: Entregar relatório...");
            tarefa3 = new Tarefa("Entregar relatório", LocalDate.of(2025, 1, 15));
            System.out.println("OK");
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();

        // Concluir tarefas
        if (tarefa1 != null) {
            try {
                System.out.println("Concluindo tarefa: " + tarefa1.getTitulo());
                tarefa1.concluir();
                System.out.println("Tarefa concluída com sucesso.");
            } catch (PrazoExpiradoException e) {
                System.out.println("Erro: " + e.getMessage() + " (prazo: " + e.getPrazo() + ")");
            } finally {
                System.out.println("Tarefa '" + tarefa1.getTitulo() + "' - Concluída: " + tarefa1.isConcluida());
            }
            System.out.println();
        }

        if (tarefa3 != null) {
            try {
                System.out.println("Concluindo tarefa: " + tarefa3.getTitulo());
                tarefa3.concluir();
                System.out.println("Tarefa concluída com sucesso.");
            } catch (PrazoExpiradoException e) {
                System.out.println("Erro: " + e.getMessage() + " (prazo: " + e.getPrazo() + ")");
            } finally {
                System.out.println("Tarefa '" + tarefa3.getTitulo() + "' - Concluída: " + tarefa3.isConcluida());
            }
        }
    }
}

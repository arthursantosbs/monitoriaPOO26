package exercicios.lista08;

/**
 * QUESTÃO 01: VALIDAÇÃO DE ALUNOS COM EXCEÇÕES
 *
 * Demonstra: checked exceptions, try-with-resources, encadeamento de exceções
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Exceção checked personalizada
class RegistroInvalidoException extends Exception {
    private int numeroLinha;

    public RegistroInvalidoException(String mensagem, int numeroLinha) {
        super(mensagem);
        this.numeroLinha = numeroLinha;
    }

    public RegistroInvalidoException(String mensagem, int numeroLinha, Throwable causa) {
        super(mensagem, causa);
        this.numeroLinha = numeroLinha;
    }

    public int getNumeroLinha() {
        return numeroLinha;
    }
}

// Classe processadora
class ProcessadorDeAlunos {
    public void processar(String caminhoArquivo) throws RegistroInvalidoException {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinha = 1;

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");

                // Validar nome
                if (campos[0].trim().isEmpty()) {
                    throw new RegistroInvalidoException("Nome vazio na linha " + numeroLinha, numeroLinha);
                }

                // Validar idade
                int idade;
                try {
                    idade = Integer.parseInt(campos[1].trim());
                } catch (NumberFormatException e) {
                    throw new RegistroInvalidoException("Idade inválida na linha " + numeroLinha, numeroLinha, e);
                }

                // Validar nota
                double nota;
                try {
                    nota = Double.parseDouble(campos[2].trim());
                    if (nota < 0 || nota > 10) {
                        throw new RegistroInvalidoException("Nota fora do intervalo na linha " + numeroLinha, numeroLinha);
                    }
                } catch (NumberFormatException e) {
                    throw new RegistroInvalidoException("Nota inválida na linha " + numeroLinha, numeroLinha, e);
                }

                // Registro válido
                System.out.println("Aluno registrado: " + campos[0] + ", idade " + idade + ", nota " + nota);
                numeroLinha++;
            }
        } catch (IOException e) {
            throw new RegistroInvalidoException("Erro ao ler arquivo", 0, e);
        }
    }
}

// Classe principal
public class Questao01 {
    public static void main(String[] args) {
        ProcessadorDeAlunos processador = new ProcessadorDeAlunos();

        try {
            processador.processar("alunos.csv");
        } catch (RegistroInvalidoException e) {
            System.out.println("Erro no registro — " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("  Causa: " + e.getCause().toString());
            }
        } finally {
            System.out.println("Processamento encerrado.");
        }
    }
}

package exercicios.lista08;

/**
 * QUESTÃO 06: GERADOR DE RELATÓRIO COM DUAS ABORDAGENS
 *
 * Demonstra: try-with-resources vs finally para fechar recursos
 */

import java.io.*;

// Classe com duas versões do método
class GeradorRelatorio {
    // Versão A - com finally
    public void gerarRelatorioComFinally(String entrada, String saida) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(entrada));
            writer = new BufferedWriter(new FileWriter(saida));

            String linha = reader.readLine(); // Pula cabeçalho

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                String nome = campos[0];
                double nota1 = Double.parseDouble(campos[1]);
                double nota2 = Double.parseDouble(campos[2]);
                double nota3 = Double.parseDouble(campos[3]);
                double media = (nota1 + nota2 + nota3) / 3;

                writer.write(String.format("%s - Média: %.2f%n", nome, media));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada não encontrado: " + entrada);
        } catch (IOException e) {
            System.out.println("Erro durante leitura/escrita: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    // Versão B - com try-with-resources
    public void gerarRelatorioComTryWithResources(String entrada, String saida) {
        try (BufferedReader reader = new BufferedReader(new FileReader(entrada));
             BufferedWriter writer = new BufferedWriter(new FileWriter(saida))) {

            String linha = reader.readLine(); // Pula cabeçalho

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                String nome = campos[0];
                double nota1 = Double.parseDouble(campos[1]);
                double nota2 = Double.parseDouble(campos[2]);
                double nota3 = Double.parseDouble(campos[3]);
                double media = (nota1 + nota2 + nota3) / 3;

                writer.write(String.format("%s - Média: %.2f%n", nome, media));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada não encontrado: " + entrada);
        } catch (IOException e) {
            System.out.println("Erro durante leitura/escrita: " + e.getMessage());
        }
        // Recursos fechados automaticamente
    }
}

// Classe principal
public class Questao06 {
    public static void main(String[] args) {
        GeradorRelatorio gerador = new GeradorRelatorio();

        System.out.println("Versão A (com finally):");
        gerador.gerarRelatorioComFinally("alunos_q6.csv", "relatorio_a.txt");

        System.out.println("\nVersão B (try-with-resources):");
        gerador.gerarRelatorioComTryWithResources("alunos_q6.csv", "relatorio_b.txt");

        System.out.println("\nTestando com arquivo inexistente:");
        gerador.gerarRelatorioComTryWithResources("arquivo_inexistente.csv", "relatorio_c.txt");
    }
}

package exercicios.excecoes.exercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RelatorioAlunosTryWithResources {
    public static void gerarRelatorio(String caminhoEntrada, String caminhoSaida) {
        try (
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoSaida))
        ) {
            RelatorioAlunosUtil.processarArquivo(leitor, escritor);
            System.out.println("Relatorio gerado com try-with-resources: " + caminhoSaida);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada nao encontrado: " + caminhoEntrada);
        } catch (IOException e) {
            System.out.println("Erro durante leitura ou escrita: " + e.getMessage());
        }
    }
}

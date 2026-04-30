package exercicios.excecoes.exercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RelatorioAlunosComFinally {
    public static void gerarRelatorio(String caminhoEntrada, String caminhoSaida) {
        FileReader arquivoEntrada = null;
        BufferedReader leitor = null;
        FileWriter arquivoSaida = null;
        BufferedWriter escritor = null;

        try {
            arquivoEntrada = new FileReader(caminhoEntrada);
            leitor = new BufferedReader(arquivoEntrada);
            arquivoSaida = new FileWriter(caminhoSaida);
            escritor = new BufferedWriter(arquivoSaida);

            RelatorioAlunosUtil.processarArquivo(leitor, escritor);
            System.out.println("Relatorio gerado com finally: " + caminhoSaida);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada nao encontrado: " + caminhoEntrada);
        } catch (IOException e) {
            System.out.println("Erro durante leitura ou escrita: " + e.getMessage());
        } finally {
            fecharRecurso(escritor, "arquivo de saida");
            fecharRecurso(arquivoSaida, "FileWriter");
            fecharRecurso(leitor, "arquivo de entrada");
            fecharRecurso(arquivoEntrada, "FileReader");
        }
    }

    private static void fecharRecurso(Closeable recurso, String descricao) {
        if (recurso == null) {
            return;
        }

        try {
            recurso.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar " + descricao + ": " + e.getMessage());
        }
    }
}

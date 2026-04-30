package exercicios.excecoes.exercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Locale;

final class RelatorioAlunosUtil {
    private RelatorioAlunosUtil() {
    }

    static void processarArquivo(BufferedReader leitor, BufferedWriter escritor) throws IOException {
        String linha;
        int numeroLinha = 0;

        while ((linha = leitor.readLine()) != null) {
            numeroLinha++;

            if (linha.isBlank()) {
                continue;
            }

            if (numeroLinha == 1 && linha.toLowerCase(Locale.ROOT).startsWith("nome;")) {
                continue;
            }

            escritor.write(formatarLinhaRelatorio(linha, numeroLinha));
            escritor.newLine();
        }
    }

    private static String formatarLinhaRelatorio(String linha, int numeroLinha) throws IOException {
        String[] campos = linha.split(";");

        if (campos.length != 4) {
            throw new IOException("Linha " + numeroLinha + " esta fora do formato nome;nota1;nota2;nota3.");
        }

        String nome = campos[0].trim();
        double nota1 = lerNota(campos[1], numeroLinha);
        double nota2 = lerNota(campos[2], numeroLinha);
        double nota3 = lerNota(campos[3], numeroLinha);
        double media = (nota1 + nota2 + nota3) / 3.0;

        return String.format(Locale.US, "%s - Média: %.2f", nome, media);
    }

    private static double lerNota(String valor, int numeroLinha) throws IOException {
        try {
            return Double.parseDouble(valor.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IOException("Linha " + numeroLinha + " possui nota invalida: " + valor + ".", e);
        }
    }
}

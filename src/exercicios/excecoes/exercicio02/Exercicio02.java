package exercicios.excecoes.exercicio02;

import java.io.File;

public class Exercicio02 {
    private static final String PASTA_ENTRADA = "resources/exercicios/excecoes/exercicio02/";
    private static final String PASTA_SAIDA = "out/relatorios/exercicio02/";

    public static void main(String[] args) {
        new File(PASTA_SAIDA).mkdirs();

        String entrada = PASTA_ENTRADA + "alunos.csv";
        String saidaComFinally = PASTA_SAIDA + "relatorio-finally.txt";
        String saidaTryWithResources = PASTA_SAIDA + "relatorio-try-with-resources.txt";

        RelatorioAlunosComFinally.gerarRelatorio(entrada, saidaComFinally);
        RelatorioAlunosTryWithResources.gerarRelatorio(entrada, saidaTryWithResources);

        System.out.println();
        System.out.println("Testando comportamento com arquivo inexistente:");

        String entradaInexistente = PASTA_ENTRADA + "alunos-inexistente.csv";
        RelatorioAlunosComFinally.gerarRelatorio(entradaInexistente, saidaComFinally);
        RelatorioAlunosTryWithResources.gerarRelatorio(entradaInexistente, saidaTryWithResources);
    }
}

package exercicios.excecoes.exercicio02;

public class Exercicio02 {
    private static final String PASTA_EXERCICIO = "src/exercicios/excecoes/exercicio02/";

    public static void main(String[] args) {
        String entrada = PASTA_EXERCICIO + "alunos.csv";
        String saidaComFinally = PASTA_EXERCICIO + "relatorio-finally.txt";
        String saidaTryWithResources = PASTA_EXERCICIO + "relatorio-try-with-resources.txt";

        RelatorioAlunosComFinally.gerarRelatorio(entrada, saidaComFinally);
        RelatorioAlunosTryWithResources.gerarRelatorio(entrada, saidaTryWithResources);

        System.out.println();
        System.out.println("Testando comportamento com arquivo inexistente:");

        String entradaInexistente = PASTA_EXERCICIO + "alunos-inexistente.csv";
        RelatorioAlunosComFinally.gerarRelatorio(entradaInexistente, saidaComFinally);
        RelatorioAlunosTryWithResources.gerarRelatorio(entradaInexistente, saidaTryWithResources);
    }
}

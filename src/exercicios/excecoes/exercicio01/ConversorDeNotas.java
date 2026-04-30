package exercicios.excecoes.exercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorDeNotas {
    public static String obterConceito(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }

        if (nota >= 9) {
            return "A";
        }

        if (nota >= 7) {
            return "B";
        }

        if (nota >= 5) {
            return "C";
        }

        return "D";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite a nota do aluno: ");
                double nota = scanner.nextDouble();
                String conceito = obterConceito(nota);

                System.out.println("Conceito: " + conceito);
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um numero valido. Tente novamente.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}

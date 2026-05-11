package lista08;

/**
 * QUESTÃO 05: CONVERSOR DE NOTAS PARA CONCEITOS
 *
 * Demonstra: unchecked exceptions, loop de entrada válida
 */

import java.util.InputMismatchException;
import java.util.Scanner;

// Classe conversora
class ConversorDeConceitos {
    public String obterConceito(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10");
        }

        if (nota >= 9.0) return "A";
        if (nota >= 7.0) return "B";
        if (nota >= 5.0) return "C";
        return "D";
    }
}

// Classe principal
public class Questao05 {
    public static void main(String[] args) {
        ConversorDeConceitos conversor = new ConversorDeConceitos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Digite a nota: ");
                double nota = scanner.nextDouble();
                String conceito = conversor.obterConceito(nota);
                System.out.println("Conceito: " + conceito);
                break; // Sai do loop se sucesso
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número.");
                scanner.nextLine(); // Limpa buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + ". Tente novamente.");
            }
        }

        scanner.close();
    }
}

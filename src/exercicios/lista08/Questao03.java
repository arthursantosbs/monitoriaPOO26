package exercicios.lista08;

/**
 * QUESTÃO 03: CONVERSOR DE NOTAS COM VALIDAÇÃO
 *
 * Demonstra: checked exceptions, unchecked exceptions propagando
 */

import java.util.Scanner;

// Exceção checked personalizada
class NotaForaDeIntervaloException extends Exception {
    private double nota;

    public NotaForaDeIntervaloException(String mensagem, double nota) {
        super(mensagem);
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }
}

// Classe conversora
class ConversorDeNotas {
    public double converter(String entrada) throws NotaForaDeIntervaloException {
        double valor = Double.parseDouble(entrada); // Pode lançar NumberFormatException

        if (valor < 0 || valor > 10) {
            throw new NotaForaDeIntervaloException("Nota fora do intervalo permitido (0 a 10)", valor);
        }

        return valor;
    }
}

// Classe principal
public class Questao03 {
    public static void main(String[] args) {
        ConversorDeNotas conversor = new ConversorDeNotas();
        Scanner scanner = new Scanner(System.in);

        double soma = 0;
        int contador = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite a nota " + i + ": ");
            String entrada = scanner.nextLine();

            try {
                double nota = conversor.converter(entrada);
                System.out.println("Nota registrada: " + nota);
                soma += nota;
                contador++;
            } catch (NotaForaDeIntervaloException e) {
                System.out.println(e.getMessage() + ". Valor informado: " + e.getNota());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: '" + entrada + "' não é um número.");
            }
        }

        scanner.close();

        if (contador > 0) {
            double media = soma / contador;
            System.out.println("Média das notas válidas: " + media);
        } else {
            System.out.println("Nenhuma nota válida foi informada.");
        }
    }
}

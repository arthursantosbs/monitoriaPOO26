package exercicios.lista08;

/**
 * QUESTÃO 02: SISTEMA DE AUTENTICAÇÃO
 *
 * Demonstra: checked exceptions, tratamento de entrada do usuário
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Exceção checked personalizada
class AutenticacaoException extends Exception {
    public AutenticacaoException(String mensagem) {
        super(mensagem);
    }
}

// Classe de serviço
class ServicoDeLogin {
    private Map<String, String> usuarios;

    public ServicoDeLogin() {
        usuarios = new HashMap<>();
        usuarios.put("admin", "1234");
        usuarios.put("maria", "abcd");
        usuarios.put("joao", "xyz9");
    }

    public String autenticar(String login, String senha) throws AutenticacaoException {
        if (!usuarios.containsKey(login)) {
            throw new AutenticacaoException("Usuário não encontrado");
        }

        if (!usuarios.get(login).equals(senha)) {
            throw new AutenticacaoException("Senha incorreta");
        }

        return "Bem-vindo, " + login + "!";
    }
}

// Classe principal
public class Questao02 {
    public static void main(String[] args) {
        ServicoDeLogin servico = new ServicoDeLogin();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Login: ");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            String resultado = servico.autenticar(login, senha);
            System.out.println(resultado);

        } catch (AutenticacaoException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Conexão encerrada.");
        }
    }
}

package lista07.q4;

/**
 * QUESTÃO 04: SISTEMA DE LOG COM POLIMORFISMO
 *
 * Problema: Sistema de log que precisa formatar mensagens de diferentes tipos.
 * Demonstrar polimorfismo em atributos e métodos.
 *
 * Solução: Classe abstrata com métodos polimórficos.
 */

// Classe abstrata base para formatadores de log
abstract class LogFormatter {
    protected String prefixo = "[INFO]";
    protected String extra = "";

    public String getPrefixo() {
        return prefixo;
    }

    public String getExtra() {
        return extra;
    }

    public String timestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String formatar(String mensagem) {
        return getPrefixo() + " " + timestamp() + " " + mensagem + getExtra();
    }
}

// Formatador padrão
class LogFormatterPadrao extends LogFormatter {
    // Usa valores padrão da classe pai
}

// Formatador para logs seguros
class LogFormatterSeguro extends LogFormatter {
    public LogFormatterSeguro() {
        this.prefixo = "[SEC]";
        this.extra = " [AUDITORIA]";
    }

    @Override
    public String timestamp() {
        // Timestamp em UTC
        return java.time.LocalDateTime.now(java.time.ZoneOffset.UTC)
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

// Formatador para logs de erro
class LogFormatterErro extends LogFormatter {
    public LogFormatterErro() {
        this.prefixo = "[ERROR]";
        this.extra = " [ERRO]";
    }
}

// Classe de teste
public class Questao04 {
    public static void main(String[] args) {
        // Criando diferentes formatadores
        LogFormatter padrao = new LogFormatterPadrao();
        LogFormatter seguro = new LogFormatterSeguro();
        LogFormatter erro = new LogFormatterErro();

        String mensagem = "Sistema iniciado";

        // Demonstrando polimorfismo
        System.out.println("Padrao: " + padrao.formatar(mensagem));
        System.out.println("Seguro: " + seguro.formatar(mensagem));
        System.out.println("Erro:   " + erro.formatar(mensagem));
    }
}

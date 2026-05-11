package exercicios.lista07;

/**
 * QUESTÃO 02: SISTEMA DE ARMAZENAMENTO COM CACHE
 *
 * Problema: Sistema de armazenamento que precisa de cache para performance,
 * mas não pode perder dados da nuvem.
 *
 * Princípio violado: Liskov Substitution Principle (LSP)
 * Solução: Usar composição ao invés de herança.
 */

// Interface comum para armazenamento
interface Armazenamento {
    void gravar(String caminho, byte[] dados);
    byte[] ler(String caminho);
}

// Implementação da nuvem
class ArmazenamentoNuvem implements Armazenamento {
    private java.util.Map<String, byte[]> storage = new java.util.HashMap<>();

    public void gravar(String caminho, byte[] dados) {
        storage.put(caminho, dados);
    }

    public byte[] ler(String caminho) {
        return storage.get(caminho);
    }
}

// Implementação com cache - usa composição
class ArmazenamentoComCache implements Armazenamento {
    private Armazenamento armazenamentoReal;
    private java.util.Map<String, byte[]> cache = new java.util.HashMap<>();

    public ArmazenamentoComCache(Armazenamento armazenamentoReal) {
        this.armazenamentoReal = armazenamentoReal;
    }

    public void gravar(String caminho, byte[] dados) {
        cache.put(caminho, dados);
        armazenamentoReal.gravar(caminho, dados); // SEMPRE grava na nuvem
    }

    public byte[] ler(String caminho) {
        // Primeiro tenta no cache
        byte[] dados = cache.get(caminho);
        if (dados != null) {
            return dados;
        }
        // Se não está no cache, busca na nuvem e armazena no cache
        dados = armazenamentoReal.ler(caminho);
        if (dados != null) {
            cache.put(caminho, dados);
        }
        return dados;
    }
}

// Classe de teste
public class Questao02 {
    public static void main(String[] args) {
        // Criando armazenamento com cache
        Armazenamento nuvem = new ArmazenamentoNuvem();
        Armazenamento cache = new ArmazenamentoComCache(nuvem);

        // Gravando dados na nuvem
        nuvem.gravar("arquivo.txt", "dados originais".getBytes());

        // Lendo através do cache
        byte[] dadosLidos = cache.ler("arquivo.txt");
        System.out.println("Dados lidos: " + new String(dadosLidos));

        // Verificando que os dados estão na nuvem
        byte[] dadosNuvem = nuvem.ler("arquivo.txt");
        System.out.println("Dados na nuvem: " + new String(dadosNuvem));
    }
}

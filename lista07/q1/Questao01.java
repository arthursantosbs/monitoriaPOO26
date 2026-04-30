package lista07.q1;

/**
 * QUESTÃO 01: SISTEMA DE AUTOMAÇÃO FISCAL
 *
 * Problema: Sistema fiscal que precisa calcular impostos e gerar XML
 * para diferentes tipos de documentos fiscais.
 *
 * Solução: Usar polimorfismo com Strategy Pattern.
 */

// Interface comum para todos os documentos fiscais
interface DocumentoFiscal {
    double calcularImposto(double valor);
    String gerarXML(String identificador);
}

// Implementações para cada tipo de documento
class NFE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.18; // 18%
    }

    public String gerarXML(String identificador) {
        return "<nfe>" + identificador + "</nfe>";
    }
}

class CTE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.12; // 12%
    }

    public String gerarXML(String identificador) {
        return "<cte>" + identificador + "</cte>";
    }
}

class NFSE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.05; // 5%
    }

    public String gerarXML(String identificador) {
        return "<nfse>" + identificador + "</nfse>";
    }
}

class MDFE implements DocumentoFiscal {
    public double calcularImposto(double valor) {
        return valor * 0.08; // 8%
    }

    public String gerarXML(String identificador) {
        return "<mdfe>" + identificador + "</mdfe>";
    }
}

// Processador que trabalha com qualquer documento fiscal
class ProcessadorFiscal {
    public String processar(DocumentoFiscal documento, double valor, String identificador) {
        double imposto = documento.calcularImposto(valor);
        String xml = documento.gerarXML(identificador);
        return xml + "|imposto:" + String.format("%.2f", imposto);
    }
}

// Classe de teste
public class Questao01 {
    public static void main(String[] args) {
        ProcessadorFiscal processador = new ProcessadorFiscal();

        // Testando todos os tipos de documento
        System.out.println("NFE:  " + processador.processar(new NFE(), 1000, "DOC1"));
        System.out.println("CTE:  " + processador.processar(new CTE(), 1000, "DOC2"));
        System.out.println("NFSE: " + processador.processar(new NFSE(), 1000, "DOC3"));
        System.out.println("MDFE: " + processador.processar(new MDFE(), 1000, "DOC4"));
    }
}

package targetsistemas;

import java.io.File;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.*;

public class TargetSistemas {

    public static void main(String[] args) {
        TargetSistemas ts = new TargetSistemas();
        int resposta2 = 34;
        double[] resposta3 = ts.Resposta3();
        double[] resposta4 = ts.Resposta4();
        String resposta5 = "abcde";

        System.out.println("Resposta para Questão 1: " + ts.Resposta1());
        System.out.println();
        System.out.println("Resposta para Questão 2 com o numero " + resposta2 + ": " + ts.Resposta2(resposta2));
        System.out.println();
        System.out.println("Resposta para Questão 3:");
        System.out.println("  Menor valor de faturamento ocorrido em um dia do mês: " + resposta3[0]);
        System.out.println("  Maior valor de faturamento ocorrido em um dia do mês: " + resposta3[1]);
        System.out.println("  Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + (int) resposta3[2]);
        System.out.println();
        System.out.println("Resposta para Questão 4:");
        System.out.println("  Percentual SP: " + String.format("%.2f", resposta4[0]) + "%");
        System.out.println("  Percentual RJ: " + String.format("%.2f", resposta4[1]) + "%");
        System.out.println("  Percentual MG: " + String.format("%.2f", resposta4[2]) + "%");
        System.out.println("  Percentual ES: " + String.format("%.2f", resposta4[3]) + "%");
        System.out.println("  Percentual OUTROS: " + String.format("%.2f", resposta4[4]) + "%");
        System.out.println();
        System.out.println("Resposta para Questão 5 com a palavra " + resposta5 + ": " + ts.Resposta5(resposta5));
    }

    public int Resposta1() {
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;
        
        while (K < INDICE) {
            K++;
            SOMA = SOMA + K;
        }

        return SOMA;
    }

    public String Resposta2(int numero) {
        int atual = 1;
        int copiaAtual = atual;
        int antigo = 0;
        
        if (numero == 1 || numero == 0) {
            return "Sim";
        }
        
        while (atual <= numero) {
            if (atual == numero) {
                return "Sim";
            }
            copiaAtual = atual;
            atual = atual + antigo;
            antigo = copiaAtual;
        }
        
        return "Não";
    }

    public double[] Resposta3() {
        JSONParser jParser = new JSONParser();
        JSONArray jArray;
        String path = new File("/TargetSistemas").toURI().relativize(new File("/TargetSistemas/src/targetsistemas/dados.json").toURI()).getPath();
        double[] resposta = {Integer.MAX_VALUE, 0, 0};
        double media = 0, total = 0;
        int nDias = 0, diasSuperior = 0;

        try {
            Object object = jParser.parse(new FileReader(path));
            jArray = (JSONArray) object;
            
            for (Object i : jArray) {
                JSONObject j = (JSONObject) i;

                if ((double) j.get("valor") < resposta[0] && (double) j.get("valor") > 0) {
                    resposta[0] = (double) j.get("valor");
                }

                if ((double) j.get("valor") > resposta[1]) {
                    resposta[1] = (double) j.get("valor");
                }

                if ((double) j.get("valor") > 0) {
                    total += (double) j.get("valor");
                    nDias++;
                }
            }

            media = total / nDias;
            
            for (Object i : jArray) {
                JSONObject j = (JSONObject) i;
                if ((double) j.get("valor") > media) {
                    diasSuperior++;
                }
            }
            
            resposta[2] = diasSuperior;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resposta;
    }

    public double[] Resposta4() {
        double[] resposta = new double[5];
        double SP = 67836.43;
        double RJ = 36678.66;
        double MG = 29229.88;
        double ES = 27165.48;
        double OUTROS = 19849.53;
        double total = SP + RJ + MG + ES + OUTROS;

        resposta[0] = (SP * 100) / total;
        resposta[1] = (RJ * 100) / total;
        resposta[2] = (MG * 100) / total;
        resposta[3] = (ES * 100) / total;
        resposta[4] = (OUTROS * 100) / total;

        return resposta;
    }

    public StringBuffer Resposta5(String str) {
        StringBuffer resposta = new StringBuffer("");
        
        for (char ch : str.toCharArray()) {
            resposta.insert(0, ch);
        }
        
        return resposta;
    }

}

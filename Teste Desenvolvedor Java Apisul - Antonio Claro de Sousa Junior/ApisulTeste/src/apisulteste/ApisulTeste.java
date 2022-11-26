package apisulteste;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import outerfiles.IElevadorService;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ApisulTeste implements IElevadorService {

    static JSONArray jArray;
    static List elevadoresMaisUtilizados = new ArrayList<Character>();
    static List fluxoMaisUtilizados = new ArrayList<Character>();
    static List elevadoresMenosUtilizados = new ArrayList<Character>();
    static List fluxoMenosUtilizados = new ArrayList<Character>();
    static List periodoMaiorFluxo = new ArrayList<Character>();
    static List elevadores = new ArrayList();

    public static void main(String[] args) {
        ApisulTeste ap = new ApisulTeste();
        JSONParser parser = new JSONParser();
        String pathJson = new File("ApisulTeste/").toURI().relativize(new File("ApisulTeste/src/outerfiles/input.json").toURI()).getPath();
        try {
            Object object = parser.parse(new FileReader(pathJson));
            jArray = (JSONArray) object;
            elevadoresMaisUtilizados = ap.elevadorMaisFrequentado();
            fluxoMaisUtilizados = ap.periodoMaiorFluxoElevadorMaisFrequentado();
            elevadoresMenosUtilizados = ap.elevadorMenosFrequentado();
            fluxoMenosUtilizados = ap.periodoMenorFluxoElevadorMenosFrequentado();
            periodoMaiorFluxo = ap.periodoMaiorUtilizacaoConjuntoElevadores();

            for (Object i : jArray) {
                JSONObject j = (JSONObject) i;
                elevadores.add(j.get("elevador"));
            }

            System.out.println("O(s) andar(es) menos utilizado(s): " + ap.andarMenosUtilizado());
            System.out.println("\n");
            System.out.println("O(s) elevador(es) mais utilizado(s) e seu(s) periodo(s) de maior fluxo: ");
            for (int i = 0; i < elevadoresMaisUtilizados.size(); i++) {
                System.out.println(elevadoresMaisUtilizados.get(i) + " - " + ap.nomePeriodo((Character) fluxoMaisUtilizados.get(i)));
            }
            System.out.println("\n");
            System.out.println("O(s) elevador(es) menos utilizado(s) e seu(s) periodo(s) de menor fluxo: ");
            for (int i = 0; i < elevadoresMenosUtilizados.size(); i++) {
                System.out.println(elevadoresMenosUtilizados.get(i) + " - " + ap.nomePeriodo((Character) fluxoMenosUtilizados.get(i)));
            }
            System.out.println("\n");
            System.out.println("O periodo de maior utilização do conjunto de elevadores é: ");
            for (int i = 0; i < periodoMaiorFluxo.size(); i++) {
                System.out.println(ap.nomePeriodo((Character) periodoMaiorFluxo.get(i)));
            }
            System.out.println("\n");
            System.out.println("A porcentagem de uso de cada elevador é: \n");
            System.out.println("A: " + String.format("%.2f", ap.percentualDeUsoElevadorA()) + "%");
            System.out.println("B: " + String.format("%.2f", ap.percentualDeUsoElevadorB()) + "%");
            System.out.println("C: " + String.format("%.2f", ap.percentualDeUsoElevadorC()) + "%");
            System.out.println("D: " + String.format("%.2f", ap.percentualDeUsoElevadorD()) + "%");
            System.out.println("E: " + String.format("%.2f", ap.percentualDeUsoElevadorE()) + "%");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String nomePeriodo(Character periodo) {
        switch (periodo) {
            case 'M':
                return "Matutino";
            case 'V':
                return "Vespertino";
            case 'N':
                return "Noturno";
        }
        return "";
    }

    @Override
    public List<Integer> andarMenosUtilizado() {

        ArrayList listaAndares = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        List andaresMenosUsados = new ArrayList<Integer>();
        for (Object i : jArray) {
            JSONObject j = (JSONObject) i;
            listaAndares.add(j.get("andar"));
        }

        for (int i = 0; i < listaAndares.size(); i++) {
            int times = 0;
            for (int j = 0; j < listaAndares.size(); j++) {
                if (listaAndares.get(i) == listaAndares.get(j)) {
                    times++;
                }
            }
            if (times < min) {
                min = times;
            }
        }

        for (Object k : listaAndares) {
            if (Collections.frequency(listaAndares, k) == min && !andaresMenosUsados.contains(k)) {
                andaresMenosUsados.add(k);
            }
        }

        return andaresMenosUsados;
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {

        List listaElevadores = new ArrayList();
        Map<String, Integer> mapElevadores = new HashMap<String, Integer>();
        int max = 0;

        mapElevadores.put("A", 0);
        mapElevadores.put("B", 0);
        mapElevadores.put("C", 0);
        mapElevadores.put("D", 0);
        mapElevadores.put("E", 0);

        for (Object i : jArray) {
            JSONObject jObj = (JSONObject) i;
            mapElevadores.put((String) jObj.get("elevador"), mapElevadores.get((String) jObj.get("elevador")) + 1);
        }

        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jObj1 = (JSONObject) jArray.get(i);
            int times = 0;
            for (int j = 0; j < jArray.size(); j++) {
                JSONObject jObj2 = (JSONObject) jArray.get(j);
                if ((jObj1.get("elevador").toString()).equals(jObj2.get("elevador").toString())) {
                    times++;
                }
            }
            if (times > max) {
                max = times;
            }
        }

        for (Entry<String, Integer> entry : mapElevadores.entrySet()) {
            if (entry.getValue() == max) {
                switch (entry.getKey()) {
                    case "A":
                        listaElevadores.add("A");
                        break;
                    case "B":
                        listaElevadores.add("B");
                        break;
                    case "C":
                        listaElevadores.add("C");
                        break;
                    case "D":
                        listaElevadores.add("D");
                        break;
                    case "E":
                        listaElevadores.add("E");
                        break;
                }

            }
        }
        return listaElevadores;
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        ArrayList fluxo = new ArrayList<Character>();
        Map<String, Integer> mapFluxo = new HashMap<String, Integer>();
        mapFluxo.put("M", 0);
        mapFluxo.put("V", 0);
        mapFluxo.put("N", 0);

        for (int j = 0; j < elevadoresMaisUtilizados.size(); j++) {
            int getMaxValue = 0;
            for (int i = 0; i < jArray.size(); i++) {
                JSONObject jObj = (JSONObject) jArray.get(i);
                if (elevadoresMaisUtilizados.contains(jObj.get("elevador")) && (elevadoresMaisUtilizados.get(j)).equals(jObj.get("elevador"))) {
                    mapFluxo.put((String) jObj.get("turno"), mapFluxo.get((String) jObj.get("turno")) + 1);
                }
            }
            getMaxValue = Collections.max(mapFluxo.values());
            for (Entry<String, Integer> entry : mapFluxo.entrySet()) {
                if (entry.getValue() == getMaxValue) {
                    switch (entry.getKey()) {
                        case "M":
                            fluxo.add('M');
                            break;
                        case "V":
                            fluxo.add('V');
                            break;
                        case "N":
                            fluxo.add('N');
                            break;
                    }
                }
            }
            mapFluxo.put("M", 0);
            mapFluxo.put("V", 0);
            mapFluxo.put("N", 0);
        }

        return fluxo;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        List listaElevadores = new ArrayList();
        Map<String, Integer> mapElevadores = new HashMap<String, Integer>();
        int min = Integer.MAX_VALUE;

        mapElevadores.put("A", 0);
        mapElevadores.put("B", 0);
        mapElevadores.put("C", 0);
        mapElevadores.put("D", 0);
        mapElevadores.put("E", 0);

        for (Object i : jArray) {
            JSONObject jObj = (JSONObject) i;
            mapElevadores.put((String) jObj.get("elevador"), mapElevadores.get((String) jObj.get("elevador")) + 1);
        }

        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jObj1 = (JSONObject) jArray.get(i);
            int times = 0;
            for (int j = 0; j < jArray.size(); j++) {
                JSONObject jObj2 = (JSONObject) jArray.get(j);
                if ((jObj1.get("elevador").toString()).equals(jObj2.get("elevador").toString())) {
                    times++;
                }
            }
            if (times < min) {
                min = times;
            }
        }

        for (Entry<String, Integer> entry : mapElevadores.entrySet()) {
            if (entry.getValue() == min) {
                switch (entry.getKey()) {
                    case "A":
                        listaElevadores.add("A");
                        break;
                    case "B":
                        listaElevadores.add("B");
                        break;
                    case "C":
                        listaElevadores.add("C");
                        break;
                    case "D":
                        listaElevadores.add("D");
                        break;
                    case "E":
                        listaElevadores.add("E");
                        break;
                }

            }
        }
        return listaElevadores;
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {

        List fluxo = new ArrayList<Character>();
        Map<String, Integer> mapFluxo = new HashMap<String, Integer>();
        mapFluxo.put("M", 0);
        mapFluxo.put("V", 0);
        mapFluxo.put("N", 0);

        for (int j = 0; j < elevadoresMenosUtilizados.size(); j++) {
            int getMinValue = Integer.MAX_VALUE;
            for (int i = 0; i < jArray.size(); i++) {
                JSONObject jObj = (JSONObject) jArray.get(i);
                if (elevadoresMenosUtilizados.contains(jObj.get("elevador")) && (elevadoresMenosUtilizados.get(j)).equals(jObj.get("elevador"))) {
                    mapFluxo.put((String) jObj.get("turno"), mapFluxo.get((String) jObj.get("turno")) + 1);
                }
            }
            getMinValue = Collections.min(mapFluxo.values());
            if (getMinValue == 0) {
                getMinValue = 1;
            }
            for (Entry<String, Integer> entry : mapFluxo.entrySet()) {
                if (entry.getValue() == getMinValue) {
                    switch (entry.getKey()) {
                        case "M":
                            fluxo.add('M');
                            break;
                        case "V":
                            fluxo.add('V');
                            break;
                        case "N":
                            fluxo.add('N');
                            break;
                    }
                }
            }
            mapFluxo.put("M", 0);
            mapFluxo.put("V", 0);
            mapFluxo.put("N", 0);
        }
        return fluxo;

    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {

        ArrayList periodo = new ArrayList<Character>();
        int max = 0;
        Map<String, Integer> mapPeriodo = new HashMap<String, Integer>();
        mapPeriodo.put("M", 0);
        mapPeriodo.put("V", 0);
        mapPeriodo.put("N", 0);

        for (int j = 0; j < jArray.size(); j++) {
            for (int i = 0; i < jArray.size(); i++) {
                JSONObject jObj = (JSONObject) jArray.get(i);
                mapPeriodo.put((String) jObj.get("turno"), mapPeriodo.get((String) jObj.get("turno")) + 1);
            }
        }

        max = Collections.max(mapPeriodo.values());
        for (Entry<String, Integer> entry : mapPeriodo.entrySet()) {
            if (entry.getValue() == max) {
                switch (entry.getKey()) {
                    case "M":
                        periodo.add('M');
                        break;
                    case "V":
                        periodo.add('V');
                        break;
                    case "N":
                        periodo.add('N');
                        break;
                }
            }
        }

        return periodo;
    }

    @Override
    public float percentualDeUsoElevadorA() {

        float porcentoA = 0;
        float total = 0;

        for (Object obj : elevadores) {
            if (obj.equals("A")) {
                total++;
            }
        }
        porcentoA = total * 100 / elevadores.size();

        return porcentoA;
    }

    @Override
    public float percentualDeUsoElevadorB() {

        float porcentoB = 0;
        float total = 0;

        for (Object obj : elevadores) {
            if (obj.equals("B")) {
                total++;
            }
        }
        porcentoB = total * 100 / elevadores.size();
        return porcentoB;
    }

    @Override
    public float percentualDeUsoElevadorC() {

        float porcentoC = 0;
        float total = 0;

        for (Object obj : elevadores) {
            if (obj.equals("C")) {
                total++;
            }
        }
        porcentoC = total * 100 / elevadores.size();
        return porcentoC;
    }

    @Override
    public float percentualDeUsoElevadorD() {

        float porcentoD = 0;
        float total = 0;

        for (Object obj : elevadores) {
            if (obj.equals("D")) {
                total++;
            }
        }
        porcentoD = total * 100 / elevadores.size();
        return porcentoD;
    }

    @Override
    public float percentualDeUsoElevadorE() {

        float porcentoE = 0;
        float total = 0;

        for (Object obj : elevadores) {
            if (obj.equals("E")) {
                total++;
            }
        }
        porcentoE = total * 100 / elevadores.size();
        return porcentoE;
    }

}

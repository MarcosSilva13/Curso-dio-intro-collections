package com.dio.collection.map;
/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

import java.util.*;

public class ExercicioProposto01 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> estadosNor = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estadosNor);

        System.out.println("\nSubstitua a população do estado RN por : 3.534.165");
        estadosNor.put("RN", 3534165);
        System.out.println(estadosNor);

        System.out.println("\nConfira se o estado da Paraíba (PB) está no dicionário, caso não, adicione " +
                "PB - 4.039.277: ");
        if(!estadosNor.containsKey("PB")){
            estadosNor.put("PB", 4039277);
        }
        System.out.println(estadosNor);

        System.out.println("\nExiba a população do estado PE: ");
        System.out.println(estadosNor.get("PE"));

        System.out.println("\nExiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String, Integer> estadosNor1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};
        System.out.println(estadosNor1);

        System.out.println("\nExiba todos os estados e suas populações na ordem alfabética: ");
        Map<String, Integer> estadosNor2 = new TreeMap<>(estadosNor1);
        System.out.println(estadosNor2);

        System.out.println("\nExiba o estado com menor população e sua quantidade: ");
        String estadoMenorPopulacao = "", estadoMaiorPopulacao = "";
        Integer menor = Collections.min(estadosNor2.values()), maior = Collections.max(estadosNor2.values());
        for (Map.Entry<String, Integer> estados: estadosNor2.entrySet()) {
            if(estados.getValue().equals(menor))
                estadoMenorPopulacao = estados.getKey();
            if(estados.getValue().equals(maior))
                estadoMaiorPopulacao = estados.getKey();
        }
        System.out.printf("Menor Populaçao: %s Quantidade: %d\n" , estadoMenorPopulacao, menor);
        System.out.printf("Maior Populaçao: %s Quantidade: %d\n", estadoMaiorPopulacao, maior);

        System.out.println("\nExiba a soma da população desses estados: ");
        Iterator<Integer> iterator = estadosNor2.values().iterator();
        int soma = 0;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("\nExiba a média da população desses estados: " + (soma/estadosNor2.size()));

        System.out.println("\nRemova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator1 = estadosNor2.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next() < 4000000) iterator1.remove();
        }
        System.out.println(estadosNor2);

        System.out.println("\nApague o dicionario de estados com suas respectivas populações estimadas: ");
        estadosNor2.clear();
        System.out.println(estadosNor2);

        System.out.println("\nConfira se a lista está vazia: " + estadosNor2.isEmpty());

    }
}

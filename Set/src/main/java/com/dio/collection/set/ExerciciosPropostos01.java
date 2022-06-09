package com.dio.collection.set;

import java.util.*;
/*
Crie um conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
vermelha, laranja, amarela, verde, azul, azul-escuro e violeta
 */
public class ExerciciosPropostos01 {
    public static void main(String[] args) {
        Set<String> arcoIris = new HashSet<>();
            arcoIris.add("Vermelho");
            arcoIris.add("Laranja");
            arcoIris.add("Amarelo");
            arcoIris.add("Verde");
            arcoIris.add("Azul");
            arcoIris.add("Azul-escuro");
            arcoIris.add("Violeta");

        System.out.println("Exiba todas as cores o arco-íris uma abaixo da outra: ");
        for (String arco: arcoIris) {
            System.out.println(arco);
        }

        System.out.println("\nA quantidade de cores que o arco-íris tem: " + arcoIris.size());

        System.out.println("\nExiba as cores em ordem alfabética: ");
        Set<String> arcoIris2 = new TreeSet<>(arcoIris);
        System.out.println(arcoIris2);

        System.out.println("\nExiba as cores na ordem inversa da que foi informada: ");
        Set<String> arcoIris3 = new LinkedHashSet<>(
                Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Azul-escuro", "Violeta"));
        System.out.println(arcoIris3);
        List<String> arcoIrisList = new ArrayList<>(arcoIris3);
        Collections.reverse(arcoIrisList);
        System.out.println(arcoIrisList);

        System.out.println("\nExiba todas as cores que começam com a letra ”v”: ");
        Iterator<String> iterator = arcoIris.iterator();
        while(iterator.hasNext()){
            String arco = iterator.next();
            if(arco.startsWith("V")) System.out.println(arco);
        }

        System.out.println("\nRemova todas as cores que não começam com a letra “v”: ");
        Iterator<String> iterator1 = arcoIris.iterator();
        while(iterator1.hasNext()){
            String arco = iterator1.next();
            if(!arco.startsWith("V")) iterator1.remove();
        }
        System.out.println(arcoIris);

        System.out.println("\nLimpe o conjunto: ");
        arcoIris.clear();
        System.out.println(arcoIris);

        System.out.println("\nConfira se o conjunto está vazio: " + arcoIris.isEmpty());
    }
}

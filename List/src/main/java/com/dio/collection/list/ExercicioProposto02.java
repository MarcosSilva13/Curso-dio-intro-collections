package com.dio.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/
public class ExercicioProposto02 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<String> resp = new ArrayList<String>();
        String nome;

        //Pedindo nome da pessoa
        System.out.println("Informe seu nome: ");
        nome = ler.nextLine();

        //Informando o que responder e armazenando as respostas na lista
        System.out.println("\nDigite (s) para Sim e (n) para Não:");
        System.out.println("\n1 - Telefonou para a vítima ?");
        resp.add(ler.next());
        System.out.println("\n2 - Esteve no local ?");
        resp.add(ler.next());
        System.out.println("\n3 - Mora perto da vítima ?");
        resp.add(ler.next());
        System.out.println("\n4 - Devia para a vítima?");
        resp.add(ler.next());
        System.out.println("\n5 - Já trabalhou com a vítima ?");
        resp.add(ler.next());

        //Exibindo as respostas
        System.out.println("\nRespostas: " + resp);

        //Verificando e exibindo o resultado
        System.out.println("\nResultado");
        int cont = 0;
        Iterator<String> iterator = resp.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(next.equalsIgnoreCase("S")){
                cont++;
            }
        }

        switch (cont){
            case 2:
                System.out.println(nome + " você é Suspeito(a)!");
                break;
            case 3:
            case 4:
                System.out.println(nome + " você é Cumplice!");
                break;
            case 5:
                System.out.println(nome + " você é Assassino(a)!");
                break;
            default:
                System.out.println(nome + " você é Inocente!");
                break;
        }
    }
}

package com.dio.collection.list;

/*Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto01 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<Double> temps = new ArrayList<Double>();

        //Adicionando as temperaturas na lista
        int count = 6;
        while(count > 0){
            System.out.println("Digite uma temperatura: ");
            temps.add(ler.nextDouble());
            count--;
        }

        //Exibindo todas as temperaturas
        System.out.println("Temperaturas:");
        System.out.println(temps);

        //Calculando e exibindo a média das temperaturas
        double media = 0d, soma = 0d;
        for (Double temp : temps) {
            soma += temp;
        }
        media = (soma/temps.size());
        System.out.printf("\nMédia das temperaturas: %.1f\n", media);

        //Exibindo temperaturas acima da média
        System.out.println("\nTemperaturas acima da média: ");
        for (Double temp: temps) {
            if(temp > media){
                System.out.println(temp + " ");
            }
        }

        //Exibindo os meses das temperaturas acima da média
        System.out.println("\nMeses das temperaturas acima da média:");
        Iterator<Double> iterator = temps.iterator();

        int i = 0;
        while(iterator.hasNext()){
            Double temp = iterator.next();
            if(temp > media){
                switch (i){
                    case 0:
                        System.out.printf("1 - Janeiro: %.1f\n", temp);
                        break;
                    case 1:
                        System.out.printf("2 - Fevereiro: %.1f\n", temp);
                        break;
                    case 2:
                        System.out.printf("3 - Março: %.1f\n", temp);
                        break;
                    case 3:
                        System.out.printf("4 - Abril: %.1f\n", temp);
                        break;
                    case 4:
                        System.out.printf("5 - Maio: %.1f\n", temp);
                        break;
                    case 5:
                        System.out.printf("6 - Junho: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("Nenhuma temperatura acima da média!");
                }
            }
            i++;
        }
    }
}

package com.dio.collection.set;

import java.util.*;
import java.util.stream.Collectors;

/*Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:

(nome - genero - tempoEpisodio de episódio);
Série 1 = Nome: got, genero: fantasia, tempoEpisodioEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodioEpisodio: 60
Série 3 = nome: that '70s show, genero: comédia, tempoEpisodioEpisodio: 25
*/
public class ExemploOrdenacaoSet {
    public static void main(String[] args) {


        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie: minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--\tOrdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie: minhasSeries1) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--\tOrdem natural (TempoEpisodioEpisodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--\tOrdem Nome/Gênero/TempoEpisodioEpisodio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--\tOrdem Nome\t--");
        Set<Serie> minhasSeriesOrdemNome = minhasSeries;
        minhasSeriesOrdemNome
                .stream()
                .sorted(Comparator.comparing(Serie::getNome))
                .collect(Collectors.toList())
                .forEach(serie -> System.out.println(serie));

        System.out.println("\n--\tOrdem gênero\t--");
        Set<Serie> minhasSeriesOrdemGenero = minhasSeries;
        minhasSeriesOrdemGenero
                .stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .collect(Collectors.toList())
                .forEach(serie -> System.out.println(serie));
    }
}

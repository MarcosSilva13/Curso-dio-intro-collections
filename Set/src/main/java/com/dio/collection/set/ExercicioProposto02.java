package com.dio.collection.set;

import java.util.*;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class ExercicioProposto02 {
    public static void main(String[] args) {
        Set<LinguagemFavorita> minhasLinguagens = new HashSet<>() {{
            add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
            add(new LinguagemFavorita("C", 1972, "Visual Studio Code"));
            add(new LinguagemFavorita("Csharp", 1999, "Visual Studio"));
        }};

        System.out.println("\nOrdem de Inserção");
        Set<LinguagemFavorita> minhasLinguagens1 = new LinkedHashSet<>(
                Arrays.asList(
                        new LinguagemFavorita("Java", 1991, "IntelliJ"),
                        new LinguagemFavorita("C", 1972, "Visual studio code"),
                        new LinguagemFavorita("Csharp", 1999, "Visual studio")
                )
        );
        for (LinguagemFavorita linguagens : minhasLinguagens1) System.out.println(linguagens);

        System.out.println("\nOrdem natural(nome): ");
        Set<LinguagemFavorita> minhasLinguagens2 = new TreeSet<>(minhasLinguagens);
        for (LinguagemFavorita linguagens : minhasLinguagens2) System.out.println(linguagens);

        System.out.println("\nOrdem IDE: ");
        Set<LinguagemFavorita> minhasLinguagens3 = new TreeSet<LinguagemFavorita>(new ComparatorIDE());
        minhasLinguagens3.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagens : minhasLinguagens3) System.out.println(linguagens);

        System.out.println("\nOrdem Ano de criação e nome: ");
        Set<LinguagemFavorita> minhasLinguagens4 = new TreeSet<LinguagemFavorita>(new ComparatorAnoCriacaoENome());
        minhasLinguagens4.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagens : minhasLinguagens4) System.out.println(linguagens);

        System.out.println("\nOrdem Nome, ano de criação e IDE");
        Set<LinguagemFavorita> minhasLinguagens5 = new TreeSet<LinguagemFavorita>(new ComparatorNomeAnoCriacaoIde());
        minhasLinguagens5.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagens : minhasLinguagens5) System.out.println(linguagens);

        System.out.println("\nExiba todas as linguagens uma abaixo da outra: ");
        for (LinguagemFavorita linguagens: minhasLinguagens5) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoDeCriacao() + " - " + linguagens.getIde());
        }

    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String Ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        Ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return Ide;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", Ide='" + Ide + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(Ide, that.Ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, Ide);
    }

    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        return this.nome.compareToIgnoreCase(linguagem.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}

class ComparatorAnoCriacaoENome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(anoCriacao != 0) return anoCriacao;

        return l1.getNome().compareToIgnoreCase(l2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        if(nome != 0) return nome;

        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if(anoCriacao != 0) return anoCriacao;

        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}
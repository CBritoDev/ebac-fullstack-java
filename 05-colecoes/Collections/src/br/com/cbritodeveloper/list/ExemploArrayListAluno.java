package br.com.cbritodeveloper.list;

import br.com.cbritodeveloper.domain.Aluno;
import br.com.cbritodeveloper.domain.ComparaNotaAluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploArrayListAluno {

    public static void main(String args[]){
        exemploListaSimplesOrdenadaComparatorAluno();
        exemploListaSimplesOrdenadaClasseExterna();
    }

    public static void exemploListaSimplesOrdenadaClasseExterna(){
        System.out.println("******exemploListaSimplesOrdenadaClasseExterna******");
        List<Aluno> lista = new ArrayList<Aluno>();

        Aluno a = new Aluno("João da Silva","Linux básico",0);
        Aluno b = new Aluno("Santino Vieira", "Ciências Humanas",0);
        Aluno c = new Aluno("Iago Vieira", "TI", 0);
        lista.add(a);
        lista.add(b);
        lista.add(c);
        System.out.println(lista);
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println(" ");
    }

    public static void exemploListaSimplesOrdenadaComparatorAluno(){
        System.out.println("******exemploListaSimplesOrdenadaComparatorAluno******");
        List<Aluno> lista = new ArrayList<Aluno>();
        Aluno a = new Aluno("João da Silva","Linux básico",20);
        Aluno b = new Aluno("Santino Vieira", "Ciências Humanas",34);
        Aluno c = new Aluno("Iago Vieira", "TI", 4);
        lista.add(a);
        lista.add(b);
        lista.add(c);
        System.out.println("Lista sem ordenação: " +lista);
        //Collections.sort(lista);
        System.out.println("Lista com ordenação: " + lista);

        ComparaNotaAluno comparaNotaAluno = new ComparaNotaAluno();
        Collections.sort(lista, comparaNotaAluno);
        System.out.println("Lista com ordenação por nota" + lista);

        System.out.println(" ");
    }
}

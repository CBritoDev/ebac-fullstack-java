package br.com.cbritodeveloper.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * É como um array cujo tamanho pode crescer.
 * A busca de um elemento é rápida, mas inserçoes e exclusões não são
 */

public class ExemploArrayList {

    public static void main(String args[]){
        exemploListaSimples();
        exemploListaSimplesOrdemAscendente();
        exemploNumeros();
    }


    private static void exemploNumeros() {
        System.out.println("***** exemploNumeros *****");
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(3);
        System.out.println(numeros);

    }

    private static void exemploListaSimples(){
        System.out.println("***** exemploListaSimples *****");
        List<String> lista = new ArrayList<String>();
        lista.add("João da Pedro");
        lista.add("Tarcisio Freitas");
        lista.add("Gabriela Gourin");
        System.out.println(lista);
        System.out.println(" ");
    }

    private static void exemploListaSimplesOrdemAscendente(){
        System.out.println("***** exemploListaSimplesAscendente *****");
        List<String> lista = new ArrayList<>();
        lista.add("João da Pedro");
        lista.add("Tarcisio Freitas");
        lista.add("Gabriela Gourin");
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println(" ");
    }
}

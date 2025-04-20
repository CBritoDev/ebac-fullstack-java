package br.com.cbritodeveloper.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Ao contrario do ArrayList, as buscas são lentas e inserções e exclusões são rápidas
 */
public class ExemploLinkedList {

    public static void main(String args[]){
        exemploListaSimples();
        exemploListaSimplesOrdemAscendente();
    }

    private static void exemploListaSimples(){
        System.out.println("***** exemploListaSimples *****");
        List<String> lista = new LinkedList<String>();
        lista.add("Carlos Brito");
        lista.add("Pedro Almeida");
        lista.add("Lucrécia Bispo");
        System.out.println(lista);
        System.out.println(" ");

        lista.remove(0);
        System.out.println(lista);
        boolean contem = lista.contains("Lucrécia Bispo");
        System.out.println(contem);
        System.out.println(" ");

        for(String nome : lista){
            System.out.println(nome);
        }

        System.out.println(lista.get(0));
    }

    public static void exemploListaSimplesOrdemAscendente(){
        System.out.println("***** exemploListaSimplesOrdemAscendente *****");
        List<String> lista = new LinkedList<String>();
        lista.add("Carlos Brito");
        lista.add("Pedro Almeida");
        lista.add("Lucrécia Bispo");
        Collections.sort(lista);
        System.out.println(lista);
        System.out.println(" ");
    }
}

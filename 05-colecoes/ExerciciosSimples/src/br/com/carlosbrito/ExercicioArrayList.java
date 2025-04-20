package br.com.carlosbrito;

import java.util.ArrayList;
import java.util.List;

public class ExercicioArrayList {

    public static void main(String args[]){
        List<String> listaCompras = new ArrayList<>();
        listaCompras.add("Banana");
        listaCompras.add("Maça");
        listaCompras.add("Maça");
        listaCompras.add("Alho");
        listaCompras.add("Uva");
        for(String item : listaCompras){
            System.out.println(item);
        }
        System.out.println("Quantidade de itens na lista: "+ listaCompras.size());
    }
}

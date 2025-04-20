package br.com.carlosbrito;

import java.util.LinkedList;
import java.util.List;

public class ExercicioLinkedList {
    public static void main(String args[]){
        listaDeTarefas();
    }

    private static void listaDeTarefas(){
        System.out.println("---->  Lista de Tarefas  <----");
        List<String> tarefas = new LinkedList<>();

        tarefas.add("Escovar os dentes");
        tarefas.add("Fazer um café");
        tarefas.add("Ver noticias do dia");
        tarefas.add("Ir para Yoga");

        tarefas.add(1,"Olhar pela janela");
        System.out.println(tarefas);

        tarefas.remove(4);
        System.out.println(tarefas);
    }
}

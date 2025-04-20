package br.com.carlosbrito;

import java.util.HashSet;
import java.util.Set;

public class ExercicioHashSet {
    public static void main(String args[]){
        listaAlunos();
    }

    private static void listaAlunos(){
        System.out.println("--->  Lista de alunos  <---");
        Set<String> alunos = new HashSet<>();
        alunos.add("Pedro");
        alunos.add("Vitor");
        alunos.add("Carlos");
        alunos.add("Bruna");
        alunos.add("Brenda");
        alunos.add("Vitor");

        System.out.println("Alunos: -->" + alunos);
        System.out.println("Quantidade de alunos ativos: " + alunos.size());
    }
}

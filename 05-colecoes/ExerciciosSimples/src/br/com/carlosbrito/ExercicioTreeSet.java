package br.com.carlosbrito;

import java.util.TreeSet;
import java.util.Set;

public class ExercicioTreeSet {

    public static void main(String args[]){
        bibliotecaLivros();
    }

    private static void bibliotecaLivros(){
        System.out.println("____ BIBLIOTECA ____");
        Set<String> livros = new TreeSet<>();
        livros.add("Senhor da Chuva");
        livros.add("O Bispo");
        livros.add("Os Sete");
        livros.add("Sétimo");
        livros.add("A criança amaldiçoada");
        livros.add("Os Sete");

        for(String livro : livros){
            System.out.println("--> " + livro);
        }

        System.out.println("Quantidade de obras armazenadas: " + livros.size() );
    }
}

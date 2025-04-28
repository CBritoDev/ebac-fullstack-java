package br.com.carlosbrito;

import java.util.Arrays;
import java.util.Scanner;

public class GerenciadorDeNomes {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Olá, seja bem vindo(a).\n ");
        System.out.println("Digite os nomes separados por vírgula (,)");
        String nomes = s.nextLine();

        String[] nomesSeparados = separaNomes(nomes);
        Arrays.sort(nomesSeparados);

        for(String nome : nomesSeparados) {
            System.out.println(nome);
        }
    }

    private static String[] separaNomes(String nomes) {
        return nomes.split( ",");
    }
}

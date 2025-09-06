package br.com.carlosbrito.model;

import java.util.Scanner;

/**
 * @author carlos.brito
 * Criado em: 06/09/2025
 */
public class NomeGeneroLeitor {
    Scanner scanner = new Scanner(System.in);

    public String[] listaPessoas(){
        System.out.println("Digite o nome e seu respectivo gênero separados por vírgula, sem acentuações" +
                "conforme exemplo a seguir:");
        System.out.println("nome,genero,nome,genero,nome,genero");

        String[] nomesGeneros = scanner.nextLine().split(",");
        scanner.close();
        return nomesGeneros;
    }

}

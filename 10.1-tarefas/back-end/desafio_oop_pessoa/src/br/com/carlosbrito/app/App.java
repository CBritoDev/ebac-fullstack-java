package br.com.carlosbrito.app;

import br.com.carlosbrito.model.Pessoa;
import br.com.carlosbrito.model.PessoaFisica;
import br.com.carlosbrito.model.PessoaJuridica;

import java.util.Scanner;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pessoa pessoa = null;

        System.out.println("Deseja cadastrar pessoa fisica ou jurídica?");
        System.out.println("Digite 1 - Pessoa Física\nDigite 2 - Pessoa Juridica: ");
        System.out.print("--->");
        int escolha = input.nextInt();

        if(escolha == 1){
            pessoa = new PessoaFisica();
        }else if(escolha == 2){
            pessoa = new PessoaJuridica();
        }

        processaPessoa(pessoa);
    }

    public static void processaPessoa(Pessoa pessoa){
        pessoa.capturaDados();
        pessoa.imprimeDados();
    }

}
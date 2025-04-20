package br.com.cbritodev;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class CadastroDePessoas{

    Scanner sc = new Scanner(System.in);
    String nome = "";
    String sexo = "";Integer sair = 0;
    Set<String> feminino = new HashSet<>();
    Set<String> masculino = new HashSet<>();
    CadastroPessoa pessoa = new CadastroPessoa("","");


    public static void main(String[] args) {
        System.out.println("_____ BEM VINDO(A) _____");

        CadastroDePessoas dados = new CadastroDePessoas();
        dados.leituraDados();

        System.out.println("___Mulheres___");
        for(String mulher : dados.feminino){
            System.out.println(mulher);
        }
        System.out.println("");

        System.out.println("___Homens___");
        for(String homem : dados.masculino){
            System.out.println(homem);
        }
    }


    private void testaSexo(){
        if(pessoa.getSexo().equalsIgnoreCase("feminino")){
            feminino.add(pessoa.getNome());
        }else if(pessoa.getSexo().equalsIgnoreCase("masculino")) {
            masculino.add(pessoa.getNome());
        }
    }

    private void leituraDados(){
        while (true){
            System.out.print("Digite seu nome:\n---> ");
            pessoa.setNome(sc.next());
            System.out.print("Digite seu sexo:\n---> ");
            pessoa.setSexo(sc.next());

            testaSexo();

            System.out.println("Digite 1 para continuar e 2 para sair");
            sair = sc.nextInt();

            if(sair.equals(2)){
                System.out.println("...Saindo...");
                break;
            }
        }
    }

}
package br.com.carlosbrito.exercicio02.model;

/**
 * @author carlos.brito
 * Criado em: 11/08/2025
 */
public class Demo {
    public static void main(String[] args) throws IllegalAccessException {
        Pessoa pessoa01 = new Pessoa("Pedro", 22, "123.123.123-54");
        Pessoa pessoa02 = new Pessoa("Joao", 24, "123.123.123-54");

        System.out.println("----------Teste 01----------");
        InspetorDeObjeto.inspecionar(pessoa01);
        System.out.println("----------Teste 02----------");
        InspetorDeObjeto.inspecionar(pessoa02);

    }
}

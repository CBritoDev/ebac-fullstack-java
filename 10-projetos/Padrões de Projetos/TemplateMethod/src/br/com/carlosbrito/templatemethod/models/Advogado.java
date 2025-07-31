package br.com.carlosbrito.templatemethod.models;

/**
 * @author carlos.brito
 * Criado em: 21/07/2025
 */
public class Advogado extends Trabalhador{

    @Override
    protected void trabalhar() {

    }

    @Override
    protected void voltarParaCasa() {
        System.out.println("Voltando para casa de carro");
    }

    @Override
    protected void irAoTrabalho() {
        System.out.println("Indo para o trabalho de carro");
    }

    @Override
    protected void iniciarRotina() {
        System.out.println("Iniciando a rotina às 06:30h");;
    }

}

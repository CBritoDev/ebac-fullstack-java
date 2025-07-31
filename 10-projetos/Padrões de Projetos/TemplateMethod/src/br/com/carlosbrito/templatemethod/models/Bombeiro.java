package br.com.carlosbrito.templatemethod.models;

/**
 * @author carlos.brito
 * Criado em: 21/07/2025
 */
public class Bombeiro extends Trabalhador {

    @Override
    protected void trabalhar() {
        System.out.println("Trabalhando como bombeiro");
    }
}

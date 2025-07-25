package br.com.carlosbrito.templatemethod;

/**
 * @author carlos.brito
 * Criado em: 21/07/2025
 */
public abstract class Trabalhador {

    public void executarRotina(){
        iniciarRotina();
        levantar();
    }

    public void iniciarRotina(){
        System.out.println("Iniciando rotina");
    }

    public void levantar(){
        System.out.println("Levantando da cama");
    }

}

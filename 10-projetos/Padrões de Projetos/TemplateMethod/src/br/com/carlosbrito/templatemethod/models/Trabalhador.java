package br.com.carlosbrito.templatemethod.models;

/**
 * @author carlos.brito
 * Criado em: 21/07/2025
 */
public abstract class Trabalhador {

    public void executarRotina(){
        iniciarRotina();
        levantar();
        irAoTrabalho();
        trabalhar();
        voltarParaCasa();
    }

    protected abstract void trabalhar();

    protected void voltarParaCasa() {
        System.out.println("Voltando para casa");
    }

    protected void irAoTrabalho() {
        System.out.println("Indo para o trabalho");
    }


    protected void iniciarRotina(){
        System.out.println("Iniciando rotina");
    }

    protected void levantar(){
        System.out.println("Levantando da cama");
    }

}

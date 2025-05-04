package br.com.cbritodev.interfaces;

public interface ICaneta {

    public void escrever(String texto);

    public String getCor();

    default void escreverComumATodas(){
        System.out.println("Escrita igual a todas");
    }

}

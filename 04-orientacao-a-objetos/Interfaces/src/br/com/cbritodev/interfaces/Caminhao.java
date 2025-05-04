package br.com.cbritodev.interfaces;

public class Caminhao implements ICarro{

    @Override
    public void andar() {
        System.out.println(getClass().getSimpleName()+ " está andando");
    }

    @Override
    public void parar() {
        System.out.println("Caminhao está parando");
    }
}

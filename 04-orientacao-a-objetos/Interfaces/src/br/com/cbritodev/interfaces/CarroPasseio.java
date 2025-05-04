package br.com.cbritodev.interfaces;

public class CarroPasseio implements ICarro {

    @Override
    public void andar() {
        System.out.println(getClass().getSimpleName() + " está andando");
    }
}

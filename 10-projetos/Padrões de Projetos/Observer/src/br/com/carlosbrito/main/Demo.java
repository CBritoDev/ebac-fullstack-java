package br.com.carlosbrito.main;

import br.com.carlosbrito.models.Jornalista;
import br.com.carlosbrito.models.TV;

/**
 * @author carlos.brito
 * Criado em: 22/07/2025
 */
public class Demo {
    public static void main(String[] args){
        Jornalista jornalista = new Jornalista();
        jornalista.add(new TV());
        jornalista.notifyAll("Teste");
    }
}

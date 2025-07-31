package br.com.carlosbrito.models;

import br.com.carlosbrito.interfaces.Observer;
import br.com.carlosbrito.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 22/07/2025
 */
public class Jornalista implements Subject {

    public List<Observer> observers = new ArrayList<>();

    private String titulo;



    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAll(String titulo) {
        this.titulo = titulo;
        for(Observer ob : this.observers){
            ob.update(this);
        }
    }
}

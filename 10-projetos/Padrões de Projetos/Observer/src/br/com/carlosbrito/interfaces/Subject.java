package br.com.carlosbrito.interfaces;

/**
 * @author carlos.brito
 * Criado em: 22/07/2025
 */
public interface Subject {
    public void add(Observer observer);

    public void remove(Observer observer);

    public void notifyAll(String titulo);


}

package br.com.carlosbrito.models;

import br.com.carlosbrito.interfaces.Observer;
import br.com.carlosbrito.interfaces.Subject;

/**
 * @author carlos.brito
 * Criado em: 22/07/2025
 */
public class TV implements Observer {
    @Override
    public void update(Subject subject) {
        System.out.println("Recebendo a notificia: TV" + subject.toString());
    }
}

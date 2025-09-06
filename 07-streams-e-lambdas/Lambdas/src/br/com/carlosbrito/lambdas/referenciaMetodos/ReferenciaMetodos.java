package br.com.carlosbrito.referenciaMetodos;

import br.com.carlosbrito.lambdas.anonimas.MyEventConsumer;

/**
 * @author carlos.brito
 * Criado em: 04/09/2025
 */
public class ReferenciaMetodos {
    public static void main(String[] args) {
        MyEventConsumer myEvent = s -> System.out.println(s);
        MyEventConsumer myEvent2 = System.out::println;

        myEvent2.consumer("Oie");
    }
}

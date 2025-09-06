package br.com.carlosbrito.lambdas;

import br.com.carlosbrito.lambdas.anonimas.MyEventConsumer;

/**
 * @author carlos.brito
 * Criado em: 04/09/2025
 */
public class quandoUtilizarParenteses {
    public static void main(String[] args) {
        MyEventConsumer myEvent = (Object s) -> {
            System.out.println(s);
        };

        MyEventConsumer myEvent1 = ( s) -> {
            System.out.println(s);
        };

        MyEventConsumer myEvent2 =s -> System.out.println(s);

    }

}

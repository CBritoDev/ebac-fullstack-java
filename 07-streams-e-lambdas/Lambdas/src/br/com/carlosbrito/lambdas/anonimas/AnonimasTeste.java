package br.com.carlosbrito.lambdas.anonimas;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author carlos.brito
 * Criado em: 14/08/2025
 */
public class AnonimasTeste {
    public static void main(String[] args) {
        MyEventConsumer anonima = new MyEventConsumer() {
            @Override
            public void consumer(Object value) {
                System.out.println(value);
            }
        };

        anonima.consumer("Teste anonimous");

        MyEventConsumer anonimaLambda = (Object value) -> System.out.println(value);
        anonimaLambda.consumer("Teste lambda");

        IShowInfo info = new IShowInfo() {
            @Override
            public void print(Object value) {
                System.out.println(value);
            }
        };
        String teste = "Carlos";
        Integer idade = 22;
        info.print("O programador %s tem %d anos.".formatted(teste,idade));

        receberInterface("Teste com função",(Object value) -> System.out.println(value));

        receberInterface(Boolean.TRUE,(Object value) -> System.out.println(value));

        List<Integer> listaInteiros = Arrays.asList(1,2,3,4,5,5,6,7,7,8);
        realizaOperacao(listaInteiros,(n) -> n * 5 , 5);
    }

    private static void receberInterface(Object o,MyEventConsumer anonimaLambda){
        anonimaLambda.consumer(o);
    }

    private static void realizaOperacao(List<Integer> list, IntFunction<Integer> function, Integer num){
        list.forEach(n -> {
            Integer r = function.apply(n);
            System.out.println(n + " x %d = ".formatted(num) + r);
        });
    }


}

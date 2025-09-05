package br.com.carlosbrito.lambdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

/**
 * @author carlos.brito
 * Criado em: 12/08/2025
 */
public class TesteLambdas {
    public static void main(String[] args) {



        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };
        System.out.println(intBinaryOperator.applyAsInt(2,4));

        IntBinaryOperator intBinaryOperator1 =  new IntBinaryOperatorClass();
        System.out.println(intBinaryOperator1.applyAsInt(2,6));


        IProdutoInteiro produtoInteiro = (int a, int b) -> {
            return a*b;
        };

        System.out.println(produtoInteiro.produto(2,6));

        BiFunction<Integer,Integer,Integer> biFunction = Integer::sum;

        System.out.println(biFunction.apply(2,4));

        BiFunction<Double, Double, String> biFunction1 = (Double a, Double b) -> {
            Double result = a + b;
            return String.valueOf(result);
        };

        System.out.println(biFunction1.apply(4.2,6.9));

        Long result = calcular(1l,5l,(Long v1,Long v2) -> v1 + v2);
        System.out.println(result);


        Runnable helloWorld = () -> System.out.println("Hello World");

        Consumer<String>  stringConsumer = (String s) -> {
            System.out.println(s);
        };
        String amigo = "Carlos";
        stringConsumer.accept("Olá querido amigo %s".formatted(amigo));

        Supplier<Double> doubleCallable = () -> 3.1415;
        Supplier<Integer> integerCallable = () -> 22;

    }

    private static Long calcular(Long t,Long u, BiFunction<Long,Long,Long> function){
     return function.apply(t,u);
    }



}

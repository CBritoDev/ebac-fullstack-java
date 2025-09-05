package br.com.carlosbrito.lambdas;

/**
 * @author carlos.brito
 * Criado em: 14/08/2025
 */
public class TesteLambdaThreads {
    public static void main(String[] args) {

        //anonima porque implementa uma interface que dura apenas em seu uso
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando comum");
            }
        };

        new Thread(r).start();


        Runnable rLambda = () -> System.out.println("Executando lambda");
        new Thread(rLambda).start();

        new Thread(() -> System.out.println("Executando lambda1")).start();
    }
}

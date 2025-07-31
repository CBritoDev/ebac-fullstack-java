package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 26/06/2025
 */
public class DemoSingletonPropriedadeThreadSincronized {
    public static void main(String[] args){
        Thread thread1 = new Thread(new ThreadFoo());
        Thread thread2 = new Thread(new ThreadBar());

        thread1.start();
        thread2.start();
    }

    static class ThreadFoo implements Runnable{
        @Override
        public void run(){
            SingletonPropriedadeSincronized singleton = SingletonPropriedadeSincronized.getInstance("Teste");
            System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable{
        @Override
        public void run() {
            SingletonPropriedadeSincronized singleton = SingletonPropriedadeSincronized.getInstance("Teste1");
            System.out.println(singleton.getValue());
        }
    }
}

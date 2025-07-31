package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 26/06/2025
 */
public class DemoSingletonPropriedade {
    public static void main(String[] args){

        SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste");
        SingletonPropriedade singleton1 = SingletonPropriedade.getInstance("Teste 1");

        System.out.println(singleton.getValue());
        System.out.println(singleton1.getValue());

    }
}

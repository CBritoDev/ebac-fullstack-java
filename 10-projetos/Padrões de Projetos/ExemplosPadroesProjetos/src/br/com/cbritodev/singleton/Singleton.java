package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 26/06/2025
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

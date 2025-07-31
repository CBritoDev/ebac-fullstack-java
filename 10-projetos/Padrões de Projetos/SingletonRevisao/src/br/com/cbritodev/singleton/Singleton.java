package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 27/06/2025
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void log(String mensagem){
        System.out.printf("[LOG]: %s",mensagem);
    }

}

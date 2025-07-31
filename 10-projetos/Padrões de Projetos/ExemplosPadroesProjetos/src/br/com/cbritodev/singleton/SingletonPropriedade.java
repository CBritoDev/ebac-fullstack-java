package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 26/06/2025
 */
public class SingletonPropriedade {

    private static SingletonPropriedade singleton;
    private String value;

    private SingletonPropriedade(String value){
        this.value = value;
    }

    public static SingletonPropriedade getInstance(String value){
        if(singleton == null){
            singleton = new SingletonPropriedade(value);
        }
        return singleton;
    }

    public String getValue() {
        return value;
    }
}

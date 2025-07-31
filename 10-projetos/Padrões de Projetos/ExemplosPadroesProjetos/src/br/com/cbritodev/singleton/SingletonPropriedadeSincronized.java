package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 26/06/2025
 */
public class SingletonPropriedadeSincronized {
    private static SingletonPropriedadeSincronized singleton;
    private String value;

    private SingletonPropriedadeSincronized(String value){
        this.value = value;
    }

    public static synchronized SingletonPropriedadeSincronized getInstance(String value){
        if(singleton == null){
            singleton = new SingletonPropriedadeSincronized(value);
        }
        return singleton;
    }

    public String getValue() {
        return value;
    }
}

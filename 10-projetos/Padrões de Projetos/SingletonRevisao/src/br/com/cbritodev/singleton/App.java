package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 27/06/2025
 */
public class App {

    public static void main(String[] args){

        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        instance.log("Sucesso");

        System.out.println(instance); //apenas testando se realmente apenas um objeto é criado
        System.out.println(instance2);




    }

}

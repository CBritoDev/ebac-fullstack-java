package br.com.cbritodev.builder;

/**
 * @author carlos.brito
 * Criado em: 30/06/2025
 */
public class Demo {
    public static void main(String[] args){

        //Gerente gerente = new Gerente(new CheeseBurgerBuilder());
        Gerente gerente =  new Gerente();
        gerente.setBuilder(new CheeseBurgerBuilder());
        Burger burger = gerente.buildBurger();
        burger.print();
        System.out.println("\n");

        //Gerente gerente1 = new Gerente(new VeganBurger());
        gerente.setBuilder(new VeganBurger());
        Burger burger2 = gerente.buildBurger();
        burger2.print();

    }

}

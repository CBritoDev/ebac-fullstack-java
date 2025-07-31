package br.com.cbritodev.builder;

/**
 * @author carlos.brito
 * Criado em: 29/06/2025
 */
public class Gerente {

    BurgerBuilder builder;

//    public Gerente(BurgerBuilder builder) {
//        this.builder = builder;
//    }


    public void setBuilder(BurgerBuilder builder) {
        this.builder = builder;
    }

    public Burger buildBurger(){
        builder.buildBun();
        builder.buildMeat();
        builder.buildSalad();
        builder.buildCheese();
        builder.buildSauce();
        return builder.build();
    }

}

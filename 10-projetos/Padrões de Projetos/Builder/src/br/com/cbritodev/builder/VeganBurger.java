package br.com.cbritodev.builder;

/**
 * @author carlos.brito
 * Criado em: 30/06/2025
 */
public class VeganBurger extends BurgerBuilder {
    @Override
    void buildBun() {
        burger.setBun("Vegan white bun");
    }

    @Override
    void buildMeat() {
        burger.setMeat("Vegan meat");
    }

    @Override
    void buildSalad() {
        burger.setSalad("Vegan tropical salad");
    }

    @Override
    void buildCheese() {
        burger.setCheese("Vegan brazilian cheese");
    }

    @Override
    void buildSauce() {
        burger.setSauce("Secret sauce");
    }
}

package br.com.cbritodev.builder;

/**
 * @author carlos.brito
 * Criado em: 29/06/2025
 */
public  abstract class BurgerBuilder {

   Burger burger = new Burger();

   abstract void buildBun();
   abstract void buildMeat();
   abstract void buildSalad();
   abstract void buildCheese();
   abstract void buildSauce();

   Burger build(){
      return burger;
   }


}

package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 27/06/2025
 */
public class ControleRemoto {

    private static ControleRemoto controleRemoto;

    private ControleRemoto(){}

    public static ControleRemoto getInstance(){
        if(controleRemoto == null){
            controleRemoto = new ControleRemoto();
        }
        return controleRemoto;
    }

    public void mudarCanal(int x){
        System.out.println("Canal alterado para: " + x);
    }

}

package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 27/06/2025
 */
public class AppControleRemoto {
    public static void main(String[] args){

        ControleRemoto controleRemoto = ControleRemoto.getInstance();
        ControleRemoto controleRemoto2 = ControleRemoto.getInstance();

        controleRemoto.mudarCanal(5);
        controleRemoto2.mudarCanal(6);

        System.out.println(controleRemoto + "\n" + controleRemoto2);

    }
}

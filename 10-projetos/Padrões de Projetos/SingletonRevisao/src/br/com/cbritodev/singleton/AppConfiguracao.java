package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 27/06/2025
 */
public class AppConfiguracao {
    public static void main(String[] args){

        Configuracao config1 = Configuracao.getInstance();
        Configuracao config2 = Configuracao.getInstance();

        config1.setIdioma("Português");

        System.out.println(config2.getIdioma());

    }
}

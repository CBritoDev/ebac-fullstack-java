package br.com.cbritodev.singleton;

/**
 * @author carlos.brito
 * Criado em: 27/06/2025
 */
public class Configuracao {

    private static Configuracao configuracao;

    private String idioma;

    private Configuracao(){}

    public static Configuracao getInstance(){
        if(configuracao == null){
            configuracao = new Configuracao();
        }
        return configuracao;
    }

    public void setIdioma(String idioma){
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }
}

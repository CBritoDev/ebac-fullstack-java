package br.com.carlosbrito.templatemethod;

import br.com.carlosbrito.templatemethod.models.Advogado;
import br.com.carlosbrito.templatemethod.models.Bombeiro;
import br.com.carlosbrito.templatemethod.models.Policial;
import br.com.carlosbrito.templatemethod.models.Trabalhador;

/**
 * @author carlos.brito
 * Criado em: 21/07/2025
 */
public class Demo {
    public static void main(String[] args){
        Trabalhador ricardo = new Advogado();

        ricardo.executarRotina();

    }
}

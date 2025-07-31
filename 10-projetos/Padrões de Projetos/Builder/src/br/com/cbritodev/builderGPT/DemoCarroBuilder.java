package br.com.cbritodev.builderGPT;

/**
 * @author carlos.brito
 * Criado em: 30/06/2025
 */
public class DemoCarroBuilder {
    public static void main(String[] args){
        Carro carro = new CarroBuilder("Civic")
                .cor("Preto")
                .ano(2005)
                .build();

        System.out.println(carro);
    }
}

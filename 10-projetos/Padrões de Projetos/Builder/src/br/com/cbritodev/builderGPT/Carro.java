package br.com.cbritodev.builderGPT;

/**
 * @author carlos.brito
 * Criado em: 30/06/2025
 */
public class Carro {
    private String modelo;
    private String cor;
    private String motor;
    private int ano;

    Carro(String modelo, String cor, String motor, int ano){
        this.modelo = modelo;
        this.cor = cor;
        this.motor = motor;
        this.ano = ano;
    }

    @Override
    public String toString(){
        return String.format(
                """
                        -- Carro --
                        --> Modelo : %s
                        --> Cor : %s
                        --> Motor : %s
                        --> Ano : %d
                        """,
                modelo, cor, motor, ano
        );
    }

}

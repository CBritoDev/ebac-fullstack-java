package br.com.cbritodev.builderGPT;

/**
 * @author carlos.brito
 * Criado em: 30/06/2025
 */
public class CarroBuilder {

    private String modelo;
    private String cor = "Não inforamda";
    private String motor =  "Não informado";
    private int ano = 0;

    public CarroBuilder(String modelo){
        this.modelo = modelo;
    }

    public CarroBuilder cor(String cor){
        this.cor = cor;
        return this;
    }

    public CarroBuilder motor(String motor){
        this.motor = motor;
        return this;
    }

    public CarroBuilder ano(int ano){
        this.ano = ano;
        return this;
    }

    public Carro build(){
        return new Carro(modelo, cor, motor,ano);
    }
}

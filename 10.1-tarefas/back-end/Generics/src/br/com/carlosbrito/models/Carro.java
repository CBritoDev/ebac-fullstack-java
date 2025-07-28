package br.com.carlosbrito.models;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */

public abstract class Carro {
    protected String marca;
    protected String ano;


    public Carro(String marca, String ano) {
        this.marca = marca;
        this.ano = ano;
    }

    public abstract void exibirDetalhes();

    public String getMarca() {
        return marca;
    }


    public String getAno() {
        return ano;
    }

}

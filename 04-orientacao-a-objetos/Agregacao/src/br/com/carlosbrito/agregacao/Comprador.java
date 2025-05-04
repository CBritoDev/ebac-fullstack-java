package br.com.carlosbrito.agregacao;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class Comprador {

    private String nome;

    private Double verba;

    public Comprador(String nome, Double verba){
        this.nome = nome;
        this.verba = verba;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Double getVerba() {
        return verba;
    }

    public void setVerba(Double verba) {
        this.verba = verba;
    }

    public void comprar(){
        System.out.println("Comprar");
    }
}

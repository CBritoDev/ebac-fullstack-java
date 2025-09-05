package br.com.carlosbrito.exerciciosLambda;

/**
 * @author carlos.brito
 * Criado em: 13/08/2025
 */
public class Produto {
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Nome ='" + nome + '\'' +
                ", Preço =" + preco +
                '}';
    }
}

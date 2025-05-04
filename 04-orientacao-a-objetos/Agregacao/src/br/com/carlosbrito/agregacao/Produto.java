package br.com.carlosbrito.agregacao;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class Produto {

    private String nome;

    private Long codigo;

    private Double preco;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void vendido() {
        System.out.println("Vendido");
    }
}

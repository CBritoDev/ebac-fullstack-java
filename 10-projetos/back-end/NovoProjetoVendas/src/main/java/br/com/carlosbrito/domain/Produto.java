package br.com.carlosbrito.domain;

import br.com.carlosbrito.anotation.TipoChave;

import java.math.BigDecimal;

/**
 * @author carlos.brito
 * Criado em: 11/09/2025
 */
public class Produto implements Persistente{
    @TipoChave("getId")
    private Long id;
    private String nome;
    private BigDecimal valor;

    public Produto(long id, String nome, BigDecimal valorProduto) {
        this.id = id;
        this.nome = nome;
        this.valor = valorProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}

package br.com.carlosbrito.domain;

import java.math.BigDecimal;

/**
 * @author carlos.brito
 * Criado em: 18/09/2025
 */
public class Produto {

    private Long id;

    private String nome;

    private String codigo;

    private BigDecimal valor;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

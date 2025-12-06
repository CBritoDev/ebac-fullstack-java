package br.com.carlosbrito.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto_sq")
    @SequenceGenerator(name = "produto_sq",sequenceName = "sq_produto", initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false,length = 55)
    private String nome;

    @Column(name = "CODIGO", nullable = false,length = 10, unique = true)
    private String codigo;

    @Column(name = "CATEGORIA",length = 55)
    private String categoria;

    @Column(name = "VALOR", nullable = false)
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

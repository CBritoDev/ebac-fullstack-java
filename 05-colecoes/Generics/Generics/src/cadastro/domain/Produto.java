package cadastro.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */
public class Produto implements IPersistente{
    private Long codigo;
    private String nome;
    private BigDecimal valor;

    public Produto(String nome, Long codigo, BigDecimal valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}

package br.com.carlosbrito.reflections;

/**
 * @author carlos.brito
 * Criado em: 05/08/2025
 */
public class Produto {

    private Long codigo;
    private String descricaoProduto;
    private Double valorProduto;

    public Produto(){

    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }
}

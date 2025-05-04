package br.com.carlosbrito.agregacao;
import java.util.ArrayList;
import java.util.List;
/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class Venda {

    private Comprador comprador;

    private Vendedor vendedor;

    private List<Produto> produtos;

    public Venda(){
        this.produtos = new ArrayList<Produto>();
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void add(Produto produto) {
        this.produtos.add(produto);
    }

    public void concretizarVenda(){
        System.out.println("Comprador: "+ this.comprador.getNome());
        System.out.println("Itens comprados: ");
        for (Produto prod: this.produtos){
            System.out.println("Produto: " + prod.getNome() + "  Valor: " + prod.getPreco());
        }
        System.out.println("Vendedor: " + this.vendedor.getNome());
    }

    public void cancelarVenda(){
        System.out.println("Venda cancelada");
    }
}

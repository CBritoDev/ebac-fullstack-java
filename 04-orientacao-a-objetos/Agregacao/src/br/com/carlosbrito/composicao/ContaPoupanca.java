package br.com.carlosbrito.composicao;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class ContaPoupanca {

    private Banco banco;

    private Double saldo;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public ContaPoupanca(Banco banco, Double saldo){
        this.banco = banco;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "banco=" + banco.getNome() +
                ", saldo=" + saldo +
                '}';
    }
}

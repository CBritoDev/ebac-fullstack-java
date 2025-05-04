package br.com.carlosbrito.composicao;

/**
 * @author carlos.brito
 * Criado em: 04/05/2025
 */
public class ContaCorrente {
    private Banco banco;

    private Double saldo;

    private Double chequeEspecial;

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

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Banco banco, Double saldo, Double chequeEspecial){
        this.banco = banco;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "banco=" + banco.getNome() +
                ", saldo=" + saldo +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }
}

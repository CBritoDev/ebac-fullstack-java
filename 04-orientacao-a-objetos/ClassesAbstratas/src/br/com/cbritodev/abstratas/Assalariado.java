package br.com.cbritodev.abstratas;

public class Assalariado extends Empregado{

    private Double salario;

    @Override
    public Double vencimento() {
        return salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
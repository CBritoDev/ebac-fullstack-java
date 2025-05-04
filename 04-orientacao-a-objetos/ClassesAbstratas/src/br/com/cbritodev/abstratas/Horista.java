package br.com.cbritodev.abstratas;

public class Horista extends Empregado{

    private Double precoHora;

    private Double totaHoraTrabalhada;

    @Override
    public Double vencimento() {
        return precoHora * totaHoraTrabalhada;
    }

    public Double getTotaHoraTrabalhada() {
        return totaHoraTrabalhada;
    }

    public void setTotaHoraTrabalhada(Double totaHoraTrabalhada) {
        this.totaHoraTrabalhada = totaHoraTrabalhada;
    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }
}

package br.com.carlosbrito.models;

/**
 * @author carlos.brito
 * Criado em: 28/07/2025
 */
public class CarroSUV extends Carro{
    private String modelo;

    public CarroSUV(String modelo){
        super("GMW", "2007");
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "CarroSUV{" +
                "modelo='" + modelo + '\'' +
                ", marca='" +  + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Modelo:%s\nFabricante:%s\nAno: %s".formatted(modelo, getMarca(), getAno()));

    }
}



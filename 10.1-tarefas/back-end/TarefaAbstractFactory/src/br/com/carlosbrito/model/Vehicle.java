package br.com.carlosbrito.model;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public abstract class Vehicle {
    private String model;
    private String color;
    private String year;
    private String producer;

    public Vehicle(String model, String color, String year, String producer) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.producer = producer;
    }

    public abstract void turnON();

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getProducer() {
        return producer;
    }

    public String getYear() {
        return year;
    }
}

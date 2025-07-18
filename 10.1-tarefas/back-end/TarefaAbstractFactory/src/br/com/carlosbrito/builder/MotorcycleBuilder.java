package br.com.carlosbrito.builder;

import br.com.carlosbrito.model.Car;
import br.com.carlosbrito.model.Motorcycle;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class MotorcycleBuilder {
    private String model;
    private String color;
    private String year;
    private String producer;
    private Boolean hasLuggageRack;

    public MotorcycleBuilder hasLuggareRack(boolean hasLuggageRackthis){
        this.hasLuggageRack = hasLuggageRackthis;
        return this;
    }

    public MotorcycleBuilder withModel(String model){
        this.model = model;
        return this;
    }

    public MotorcycleBuilder withColor(String color){
        this.color =  color;
        return this;
    }

    public MotorcycleBuilder withYear(String year){
        this.year = year;
        return this;
    }

    public MotorcycleBuilder withProducer(String producer){
        this.producer = producer;
        return this;
    }

    public Motorcycle build(){
        return new Motorcycle(this);
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getYear() {
        return year;
    }

    public String getProducer() {
        return producer;
    }

    public Boolean getLuggageRack(){
        return hasLuggageRack;
    }
}

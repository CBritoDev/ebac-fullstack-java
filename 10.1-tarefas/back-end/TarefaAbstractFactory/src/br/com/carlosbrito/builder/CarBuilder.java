package br.com.carlosbrito.builder;

import br.com.carlosbrito.model.Car;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class CarBuilder {
    private String model;
    private String color;
    private String year;
    private String producer;
    private int numOfPassanger;

    public CarBuilder withPassenger(int numOfPassanger){
        this.numOfPassanger = numOfPassanger;
        return this;
    }

    public CarBuilder withModel(String model){
        this.model = model;
        return this;
    }

    public CarBuilder withColor(String color){
        this.color =  color;
        return this;
    }

    public CarBuilder withYear(String year){
        this.year = year;
        return this;
    }

    public CarBuilder withProducer(String producer){
        this.producer = producer;
        return this;
    }

    public Car build(){
        return new Car(this);
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

    public int getNumOfPassanger(){
        return numOfPassanger;
    }
}

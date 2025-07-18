package br.com.carlosbrito.model;

import br.com.carlosbrito.builder.CarBuilder;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class Car extends Vehicle{

    private int numOfPassenger;

    public Car(CarBuilder builder){
        super(builder.getModel(), builder.getColor(), builder.getYear(), builder.getProducer());
        numOfPassenger = builder.getNumOfPassanger();
    }

    @Override
    public void turnON() {
        System.out.println("Your car is ready to run");
    }

    public int getNumOfPassenger() {
        return numOfPassenger;
    }


    @Override
    public String toString(){
        return String.format(
                "Model: %s\n" +
                        "Color: %s\n" +
                        "Year: %s\n" +
                        "Producer: %s\n" +
                        "Passanger: %d",
                this.getModel(), this.getColor(), this.getYear(), this.getProducer(), this.getNumOfPassenger()
        );
    }
}

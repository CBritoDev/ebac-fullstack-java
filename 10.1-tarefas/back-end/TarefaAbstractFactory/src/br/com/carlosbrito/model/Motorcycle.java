package br.com.carlosbrito.model;

import br.com.carlosbrito.builder.MotorcycleBuilder;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class Motorcycle extends Vehicle{

    private Boolean hasLuggageRack;

    public Motorcycle(MotorcycleBuilder builder) {
        super(builder.getModel(),builder.getColor(),builder.getYear(),builder.getProducer());
        this.hasLuggageRack = builder.getLuggageRack();
    }


    @Override
    public void turnON() {
        System.out.println("Your motorcycle is ready to run");
    }

    public Boolean getHasLuggageRack() {
        return hasLuggageRack;
    }

    @Override
    public String toString(){
        return String.format(
                "Model: %s\n" +
                        "Color: %s\n" +
                        "Year: %s\n" +
                        "Producer: \n" +
                        "Luggage Rack: %s",
                getModel(), getColor(), getYear(), getProducer(), getHasLuggageRack() ? "Yes" : "No"
        );
    }
}

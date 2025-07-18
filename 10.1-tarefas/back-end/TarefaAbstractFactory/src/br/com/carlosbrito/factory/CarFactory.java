package br.com.carlosbrito.factory;

import br.com.carlosbrito.builder.CarBuilder;
import br.com.carlosbrito.builder.MotorcycleBuilder;
import br.com.carlosbrito.interfaces.ICreateVehicle;
import br.com.carlosbrito.model.Motorcycle;
import br.com.carlosbrito.model.Vehicle;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class CarFactory extends Factory implements ICreateVehicle {
    @Override
    public Vehicle createVehicle(String producer) {
        if(producer.equalsIgnoreCase("Fiat")){
            return new CarBuilder()
                    .withColor("Blue")
                    .withModel("Siena")
                    .withPassenger(5)
                    .withYear("2022")
                    .withProducer("FIAT")
                    .build();
        }else if(producer.equalsIgnoreCase("honda")){
            return new CarBuilder()
                    .withColor("Deep Black")
                    .withModel("Civc")
                    .withYear("2023")
                    .withPassenger(5)
                    .withProducer("Honda")
                    .build();
        }
        throw new IllegalArgumentException("This type of car doesn't exist in our system yet.");
    }
}

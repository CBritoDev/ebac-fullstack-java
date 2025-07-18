package br.com.carlosbrito.factory;

import br.com.carlosbrito.builder.MotorcycleBuilder;
import br.com.carlosbrito.interfaces.ICreateVehicle;
import br.com.carlosbrito.model.Motorcycle;
import br.com.carlosbrito.model.Vehicle;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class MotorcycleFactory extends Factory implements ICreateVehicle {

    @Override
    public Vehicle createVehicle(String type) {
        if(type.equalsIgnoreCase("yamaha")){
            return new MotorcycleBuilder()
                    .withModel("Fazer")
                    .withColor("Deep green")
                    .withProducer("Yamaha")
                    .withYear("2025")
                    .hasLuggareRack(false)
                    .build();
        }else if(type.equalsIgnoreCase("honda")){
            return new MotorcycleBuilder()
                    .withModel("CBR")
                    .withYear("2024")
                    .withProducer("Honda")
                    .withColor("Black")
                    .hasLuggareRack(false)
                    .build();
        }
        throw new IllegalArgumentException("This type of motorcycle doesn't exist in our system yet.");
    }
}

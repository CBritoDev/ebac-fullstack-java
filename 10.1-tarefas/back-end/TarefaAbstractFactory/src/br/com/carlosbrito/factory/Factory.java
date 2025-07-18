package br.com.carlosbrito.factory;

import br.com.carlosbrito.interfaces.ICreateFactory;
import br.com.carlosbrito.interfaces.ICreateVehicle;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class Factory implements ICreateFactory {

    private static Factory instance;

    public Factory(){};

    public synchronized static Factory getIntance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }

    @Override
    public ICreateVehicle createFactory(String model) {
        if(model.equalsIgnoreCase("Car")){
            return new CarFactory();
        }else if(model.equalsIgnoreCase("Motorcycle")){
            return new MotorcycleFactory();
        }

        throw new IllegalArgumentException("This type of vehicle doesn't exist in our system yet.");
    }
}

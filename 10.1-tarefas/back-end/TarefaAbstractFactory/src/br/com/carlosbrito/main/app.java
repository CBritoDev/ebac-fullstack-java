package br.com.carlosbrito.main;

import br.com.carlosbrito.factory.CarFactory;
import br.com.carlosbrito.factory.Factory;
import br.com.carlosbrito.interfaces.ICreateFactory;
import br.com.carlosbrito.interfaces.ICreateVehicle;
import br.com.carlosbrito.model.Car;
import br.com.carlosbrito.model.Vehicle;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public class app {
    public static void main(String[] agrs){
        ICreateFactory mainFactory = Factory.getIntance();

        ICreateVehicle carFactory = mainFactory.createFactory("Car");
        Vehicle fiat = carFactory.createVehicle("fiat");

        System.out.println(fiat);


    }

}

package br.com.carlosbrito.interfaces;

import br.com.carlosbrito.factory.Factory;
import br.com.carlosbrito.model.Vehicle;

/**
 * @author carlos.brito
 * Criado em: 18/07/2025
 */
public interface ICreateFactory {
    ICreateVehicle createFactory(String model);
}

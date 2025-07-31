package br.com.cbritodeveloper;

/**
 * @author carlos.brito
 * Criado em: 08/07/2025
 */
public class ContractFactory extends Factory{
    @Override
    Car retrieveCar(String requestedGrade) {
        if("A".equalsIgnoreCase(requestedGrade)){
            return new HavalCar(100, "gasoline", "deep blue");
        }else if("B".equalsIgnoreCase(requestedGrade)){
            return new BMWCar(120,"diesel","black");
        }
        return null;
    }
}

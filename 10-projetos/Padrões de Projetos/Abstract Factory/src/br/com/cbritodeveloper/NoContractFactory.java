package br.com.cbritodeveloper;

/**
 * @author carlos.brito
 * Criado em: 08/07/2025
 */
public class NoContractFactory extends Factory {
    @Override
    Car retrieveCar(String requestedGrade) {
        if("A".equalsIgnoreCase(requestedGrade)){
            return new SienaCar(100, "gasoline", "gray");
        }else if("B".equalsIgnoreCase(requestedGrade)){
            return new CorolaCar(120,"gasoline","light gray");
        }
        return null;
    }
}

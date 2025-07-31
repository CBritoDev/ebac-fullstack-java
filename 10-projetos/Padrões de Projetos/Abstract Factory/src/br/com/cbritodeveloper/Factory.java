package br.com.cbritodeveloper;

/**
 * @author carlos.brito
 * Criado em: 08/07/2025
 */
public abstract class Factory {

    public Car create(String requestedGrade){
        Car car = retrieveCar(requestedGrade);
        car = prepareCar(car);
        return car;
    }

    private Car prepareCar(Car car){
        car.choosedOne();
        car.clean();
        car.mechanCheck();
        car.fuelCar();
        return car;
    }

    abstract Car retrieveCar(String requestedGrade);

}

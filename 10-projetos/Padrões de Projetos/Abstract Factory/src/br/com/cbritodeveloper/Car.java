package br.com.cbritodeveloper;

/**
 * @author carlos.brito
 * Criado em: 08/07/2025
 */
public abstract class Car {

    private final int horsePower;
    private final String fuelSource;
    private final String color;

    public Car(int horsePower, String fuelSource, String color){
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.color = color;
    }

    public void choosedOne(){
        System.out.println("Choosed veihicle: " + getClass().getSimpleName());
    }

    public void startEngine(){
        System.out.println("The " + fuelSource + "engine has been started, and is ready to utilize " + horsePower);
    }

    public void clean(){
        System.out.println("Car has been cleaned, and the " + color.toLowerCase() + "color shines.");
    }

    public void mechanCheck(){
        System.out.println("Car has been checked by the mechanic. Everything looks good!");
    }

    public void fuelCar(){
        System.out.println("Car is being filled with " + fuelSource.toLowerCase() + ".");
    }

}

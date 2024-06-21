package org.example.TDAPassengerCar;

public class PassengerCar {
    private int id;
    private int passengerCapacity;
    private String model;
    private String trainMaker;
    private CarType cartype;

    public PassengerCar(int id, int passengerCapacity, String model, String trainMaker, CarType traintype) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
        this.cartype = traintype;
    }


    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public CarType getCartype() {
        return cartype;
    }

    @Override
    public String toString() {
        return "[" + id + "," + passengerCapacity +
                "," + model  +
                "," + trainMaker +
                "," + cartype +
                ']';
    }
}

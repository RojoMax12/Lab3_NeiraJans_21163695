package org.example;

public class PassengerCar {
    private int id;
    private int passengerCapacity;
    private String model;
    private String trainMaker;
    private CarType cartype;

    /**
     * Nombre PassengerCar
     * Descripcion  Método que construye un PassengerCar
     * @param id
     * @param passengerCapacity
     * @param model
     * @param trainMaker
     * @param traintype
     */
    public PassengerCar(int id, int passengerCapacity, String model, String trainMaker, CarType traintype) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.model = model;
        this.trainMaker = trainMaker;
        this.cartype = traintype;
    }

    /**
     * Nombre getPassengerCapacity
     * Descripcion  Método que obtiene la capacidad de un PassengerCar
     * @return passengerCapacity
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    /**
     * Nombre getCartype
     * Descripcion  Método que obtiene la cartype de un PassengerCar
     * @return cartype
     */
    public CarType getCartype() {
        return cartype;
    }


    /**
     * Nombre toString
     * Descripcion  Metodo que muestra el PassengerCar
     */
    @Override
    public String toString() {
        return "[" + id + "," + passengerCapacity +
                "," + model  +
                "," + trainMaker +
                "," + cartype +
                ']';
    }
}

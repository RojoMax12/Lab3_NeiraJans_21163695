package org.example;

import java.util.List;

public interface UseTrain {

    /**
     * Nombre addCar
     * Descripcion Método que añade un carro en una posicion dada de un tren
     * @param passengerCar
     * @param position
     * @return Train
     */
    public void addCar(PassengerCar passengerCar, int position);

    /**
     * Nombre removeCar
     * Descripcion Método que remueva un carro en la posicion dada de un tren
     * @param train
     * @param position
     * @return Train
     */
    public void removeCar(Train train, int position);

    /**
     * Nombre isTrain
     * Descripcion Método que verifica si realmente cumple los requisitos de un tren
     * @param train
     * @return boolean
     */
    public boolean isTrain(Train train);

    /**
     * Nombre fetchCapacity
     * Descripcion Método que calcula la capacidad total de un tren
     * @return fetchCapacity
     */
    public int  fetchCapacity();

    /**
     * Nombre trainconsistence
     * Descripcion Método que compprueba la consistencia de un tren
     * @param passengerCarList
     * @return boolean
     */
    public boolean trainconsistence(List<PassengerCar> passengerCarList);
}

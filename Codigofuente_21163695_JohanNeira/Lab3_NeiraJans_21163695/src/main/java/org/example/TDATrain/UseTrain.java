package org.example.TDATrain;

import org.example.TDAPassengerCar.PassengerCar;

import java.util.List;

public interface UseTrain {

    public Train addCar(PassengerCar passengerCar, int position);

    public Train removeCar(Train train, int position);

    public boolean isTrain(Train train);

    public int  fetchCapacity();

    public boolean trainconsistence(List<PassengerCar> passengerCarList);
}

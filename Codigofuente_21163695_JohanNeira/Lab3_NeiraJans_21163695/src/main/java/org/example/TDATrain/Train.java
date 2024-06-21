package org.example.TDATrain;
import org.example.TDADriver.Driver;
import org.example.TDAPassengerCar.CarType;
import org.example.TDAPassengerCar.PassengerCar;
import org.example.TDAStation.Station;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Train implements UseTrain{
    private int id;
    private String trainMaker;
    private int speed;
    private List<PassengerCar> carList;
    private List<Driver> driverList = new ArrayList<>();
    private Date departureDate = new Date();
    private List<Station> departureStation = new ArrayList<>();
    private List<Station> arrivalStation = new ArrayList<>();

    public Train(int id, String trainMaker, int speed, List<PassengerCar> carList) {
        this.id = id;
        this.trainMaker = trainMaker;
        this.speed = speed;
        this.carList = carList;
    }


    public int getId() {
        return id;
    }

    public String getTrainMaker() {
        return trainMaker;
    }


    public int getSpeed() {
        return speed;
    }

    public List<PassengerCar> getCarList() {
        return carList;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setCarList(List<PassengerCar> carList) {
        this.carList = carList;
    }

    public List<Station> getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(List<Station> departureStation) {
        this.departureStation = departureStation;
    }

    public List<Station> getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(List<Station> arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    @Override
    public String toString() {
        return "Train" + id +"["+ id + "," + trainMaker + "," + speed + "," + "PassengerCar"+ carList.toString() + "," + "DriverAssing" + driverList.toString() +
                ","  + departureDate + "," + departureStation + ","  + arrivalStation + "]";
    }

    @Override
    public Train addCar(PassengerCar passengerCar, int position) {

        List<PassengerCar> newCarList = new ArrayList<>(getCarList());

        if (position < 0 || position > newCarList.size()) {
            throw new IndexOutOfBoundsException("La posición está fuera del rango válido.");
        }

        newCarList.add(position, passengerCar);

        return new Train(getId(), getTrainMaker(), getSpeed(), newCarList);
    }

    @Override
    public Train removeCar(Train train, int position) {

        List<PassengerCar> currentCarList = train.getCarList();

        if (position < 0 || position >= currentCarList.size()) {
            throw new IndexOutOfBoundsException("La posición está fuera del rango válido.");
        }

        // Crear una nueva lista de PassengerCars
        List<PassengerCar> newCarList = new ArrayList<>(currentCarList);

        newCarList.remove(position);

        return new Train(train.getId(), train.getTrainMaker(), train.getSpeed(), newCarList);
    }

    @Override
    public boolean isTrain(Train train) {
        if(train.getCarList().get(0).getCartype().equals(CarType.TR) && train.getCarList().get(train.getCarList().size() - 1).getCartype().equals(CarType.TR)){
            if(trainconsistence(train.getCarList()) == true){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int fetchCapacity() {
        int fetchCapacity = 0;
        for (PassengerCar passengerCar : getCarList()){
            fetchCapacity += passengerCar.getPassengerCapacity();

        }
        return fetchCapacity;
    }

    @Override
    public boolean trainconsistence(List <PassengerCar> passengerCarList){
        for (int i = 1; i <= passengerCarList.size() - 2; i++){
            if(passengerCarList.get(i).getCartype().equals(CarType.TR)){
                return false;
            }
        }
        return true;
    }

}

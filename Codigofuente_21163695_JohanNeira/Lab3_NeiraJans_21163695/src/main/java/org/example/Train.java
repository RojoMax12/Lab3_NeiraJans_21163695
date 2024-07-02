package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Train implements UseTrain {
    private int id;
    private String trainMaker;
    private int speed;
    private List<PassengerCar> carList;
    private List<Driver> driverList = new ArrayList<>();
    private Date departureDate = new Date();
    private List<Station> departureStation = new ArrayList<>();
    private List<Station> arrivalStation = new ArrayList<>();

    /**
     * Nombre Train
     * Descripcion Método que construye un tren
     * @param id
     * @param trainMaker
     * @param speed
     * @param carList
     */
    public Train(int id, String trainMaker, int speed, List<PassengerCar> carList) {
        this.id = id;
        this.trainMaker = trainMaker;
        this.speed = speed;
        this.carList = carList;
    }

    /**
     * Nombre getId
     * Descripcion Método que obtiene el id de un tren
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Nombre getTrainMaker
     * Descripcion Método que obtiene el trainmaker de un tren
     * @return trainMaker
     */
    public String getTrainMaker() {
        return trainMaker;
    }

    /**
     * Nombre getSpeed
     * Descripcion Método que obtiene la velocidad de un tren
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Nombre getCarList
     * Descripcion Método que obtiene la lista de PassagerCar de un tren
     * @return carList
     */
    public List<PassengerCar> getCarList() {
        return carList;
    }

    /**
     * Nombre getDriverList
     * Descripcion Método que obtiene la lista de conductores de un tren
     * @return driverList
     */
    public List<Driver> getDriverList() {
        return driverList;
    }

    /**
     * Nombre getDepartureDate
     * Descripcion Método que obtiene el tiempo de salida de un tren
     * @return departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * Nombre setDepartureDate
     * Descripcion Método que cambia el tiempo de salida de un tren
     * @param departureDate
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Nombre setCarList
     * Descripcion Método que cambia la lista de PassagerCar de un tren
     * @param carList
     */
    public void setCarList(List<PassengerCar> carList) {
        this.carList = carList;
    }

    /**
     * Nombre getDepartureStation
     * Descripcion Método que obtiene la estacion de salida de un tren
     * @return departureStation
     */
    public List<Station> getDepartureStation() {
        return departureStation;
    }

    /**
     * Nombre setDepartureStation
     * Descripcion Método que cambia la estacion de salida de un tren
     * @param departureStation
     */
    public void setDepartureStation(List<Station> departureStation) {
        this.departureStation = departureStation;
    }

    /**
     * Nombre setArrivalStation
     * Descripcion Método que cambia la estacion de llegada de un tren
     * @param arrivalStation
     */
    public void setArrivalStation(List<Station> arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    /**
     * Nombre toString
     * Descripcion Método que muestra todo lo que contiene un tren
     */
    @Override
    public String toString() {
        return "Train" + id +"["+ id + "," + trainMaker + "," + speed + "," + "PassengerCar"+ carList.toString() + "," + "DriverAssing" + driverList.toString() +
                ","  + departureDate + "," + departureStation + ","  + arrivalStation + "]";
    }


    /**
     * Nombre addCar
     * Descripcion Método que añade un carro en una posicion dada de un tren
     * @param passengerCar
     * @param position
     * @return Train
     */
    @Override
    public void addCar(PassengerCar passengerCar, int position) {
        // Obtén la lista actual de carros
        List<PassengerCar> newCarList = new ArrayList<>(getCarList());

        // Verifica que la posición sea válida
        if (position < 0 || position > newCarList.size()) {
            throw new IndexOutOfBoundsException("La posición está fuera del rango válido.");
        }

        // Verifica si el ID del nuevo carro ya existe en la lista
        for (PassengerCar car : newCarList) {
            if (car.getId() == passengerCar.getId()) {
                throw new IllegalArgumentException("El ID del carro ya existe en la lista.");
            }
        }

        // Añade el nuevo carro en la posición especificada
        newCarList.add(position, passengerCar);

        // Actualiza la lista de carros
        setCarList(new ArrayList<>(newCarList));
    }


    /**
     * Nombre removeCar
     * Descripcion Método que remueva un carro en la posicion dada de un tren
     * @param train
     * @param position
     * @return Train
     */
    @Override
    public void removeCar(Train train, int position) {

        List<PassengerCar> currentCarList = train.getCarList();

        if (position < 0 || position >= currentCarList.size()) {
            throw new IndexOutOfBoundsException("La posición está fuera del rango válido.");
        }

        // Crear una nueva lista de PassengerCars
        List<PassengerCar> newCarList = new ArrayList<>(currentCarList);

        newCarList.remove(position);
        setCarList(newCarList);
    }

    /**
     * Nombre isTrain
     * Descripcion Método que verifica si realmente cumple los requisitos de un tren
     * @param train
     * @return boolean
     */
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

    /**
     * Nombre fetchCapacity
     * Descripcion Método que calcula la capacidad total de un tren
     * @return fetchCapacity
     */
    @Override
    public int fetchCapacity() {
        int fetchCapacity = 0;
        for (PassengerCar passengerCar : getCarList()){
            fetchCapacity += passengerCar.getPassengerCapacity();

        }
        return fetchCapacity;
    }

    /**
     * Nombre trainconsistence
     * Descripcion Método que compprueba la consistencia de un tren
     * @param passengerCarList
     * @return boolean
     */
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

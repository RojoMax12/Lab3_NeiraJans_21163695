package org.example;

import java.util.Date;
import java.util.List;

public interface UseSubway {

    /**
     * Nombre addTrain
     * Descripcion Método que añade trenes a un Subway
     * @param trainList
     */
    public void addTrain(List<Train> trainList);

    /**
     * Nombre addLine
     * Descripcion Método que añade lineas a un Subway
     * @param lineList
     */
    public void addLine(List<Line> lineList);

    /**
     * Nombre addDriver
     * Descripcion Método que añade conductores a un Subway
     * @param driverList
     */
    public void addDriver(List<Driver> driverList);

    /**
     * Nombre toString
     * Descripcion Método que muestra el subway completo
     * @param subway
     * @return String
     */
    public String toString(Subway subway);

    /**
     * Nombre assignTrainToLine
     * Descripcion Método que asigna un tren a una linea
     * @param train
     * @param line
     */
    public void assignTrainToLine(Train train, Line line);

    /**
     * Nombre assignDriverToTrain
     * Descripcion Método que asigna un conductor a un tren, ademas de una un tiempo de salida, una estacion de inicio y una estacion de llegada
     * @param train
     * @param driver
     * @param departureTime
     * @param departureStation
     * @param arrivalStation
     */
    public void assignDriverToTrain(Train train, Driver driver, Date departureTime, Station departureStation, Station arrivalStation);
}

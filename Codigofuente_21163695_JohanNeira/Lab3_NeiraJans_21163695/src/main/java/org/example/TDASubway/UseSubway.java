package org.example.TDASubway;

import org.example.TDADriver.Driver;
import org.example.TDALine.Line;
import org.example.TDAStation.Station;
import org.example.TDATrain.Train;

import java.util.Date;
import java.util.List;

public interface UseSubway {

    public void addTrain(List<Train> trainList);

    public void addLine(List<Line> lineList);

    public void addDriver(List<Driver> driverList);

    public String toString(Subway subway);

    public void assignTrainToLine(Train train, Line line);

    public void assignDriverToTrain(Train train, Driver driver, Date departureTime, Station departureStation, Station arrivalStation);
}

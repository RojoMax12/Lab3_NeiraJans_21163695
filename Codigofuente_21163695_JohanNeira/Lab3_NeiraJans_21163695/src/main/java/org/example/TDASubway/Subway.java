package org.example.TDASubway;

import org.example.TDADriver.Driver;
import org.example.TDALine.Line;
import org.example.TDAStation.Station;
import org.example.TDATrain.Train;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Subway implements UseSubway {
    private int id;
    private String name;
    private List<Line> lines = new ArrayList<>();
    private List<Train> trains = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();

    public Subway(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addTrain(List<Train> trainList) {
        List<Train> NewTrainList = getTrains();
        if (getTrains().isEmpty()) {
            setTrains(trainList);
        } else {
            for (Train newTrain : trainList) {
                boolean idExists = false;
                for (Train existingTrain : getTrains()) {
                    if (existingTrain.getId() == newTrain.getId()) {
                        idExists = true;
                        break;
                    }
                }
                if (!idExists && !getTrains().contains(newTrain)) {
                    NewTrainList.add(newTrain);
                    setTrains(NewTrainList);
                }
            }
        }
    }

    @Override
    public void addLine(List<Line> lineList){
        List<Line> NewLinelist = getLines();
        if (getLines().isEmpty()) {
            setLines(lineList);
        } else {
            for (Line newline : lineList) {
                boolean idExists = false;
                for (Line existingLine : getLines()) {
                    if (existingLine.getId() == newline.getId()) {
                        idExists = true;
                        break;
                    }
                }
                if (!idExists && !getLines().contains(newline)) {
                    NewLinelist.add(newline);
                    setLines(NewLinelist);
                }
            }
        }
    }

    @Override
    public void addDriver(List<Driver> driverList){
        List<Driver> newDriverList = getDrivers();
        if (getTrains().isEmpty()) {
            setDrivers(driverList);
        } else {
            for (Driver newdriver : driverList) {
                boolean idExists = false;
                for (Driver existingDriver : getDrivers()) {
                    if (existingDriver.getId() == newdriver.getId()) {
                        idExists = true;
                        break;
                    }
                }
                if (!idExists && !getDrivers().contains(newdriver)) {
                    newDriverList.add(newdriver);
                    setDrivers(newDriverList);
                }
            }
        }
    }

    @Override
    public String toString(Subway subway) {
        StringBuilder sb = new StringBuilder();
        sb.append("Subway" + getId() + ":" + "\n")
                .append("  ID: ").append(subway.getId()).append("\n")
                .append("  Name: ").append(subway.getName()).append("\n")
                .append("  Lines:\n");

        for (Line line : subway.getLines()) {
            sb.append("    ").append(line).append("\n");
        }

        sb.append("  Trains:\n");
        for (Train train : subway.getTrains()) {
            sb.append("    ").append(train).append("\n");
        }

        sb.append("  Drivers:\n");
        for (Driver driver : subway.getDrivers()) {
            sb.append("    ").append(driver).append("\n");
        }

        return sb.toString();
    }

    @Override
    public void assignTrainToLine(Train train, Line line){
        for (int i = 0; i < getLines().size(); i++) {
            if (getLines().get(i).getId() == line.getId()) {
                List<Train> existingTrains = getLines().get(i).getListTrain();

                boolean trainExists = false;
                for (Train existingTrain : existingTrains) {
                    if (existingTrain.getId() == train.getId()) {
                        trainExists = true;
                        break;
                    }
                }

                if (!trainExists) {
                    existingTrains.add(train);
                }
            }
        }
    }

    @Override
    public void assignDriverToTrain(Train train, Driver driver, Date departureTime, Station departureStation, Station arrivalStation) {
        List<Station> NewDepartureStation = new ArrayList<>();
        List<Station> NewArrivalStation = new ArrayList<>();
        NewArrivalStation.add(arrivalStation);
        NewDepartureStation.add(departureStation);
        for (Train t : getTrains()) {
            if (t.getId() == train.getId() && t.getTrainMaker().equals(driver.getTrainMaker())) {
                t.getDriverList().add(driver);
                t.setDepartureDate(departureTime);
                t.setDepartureStation(NewDepartureStation);
                t.setArrivalStation(NewArrivalStation);
                break;
            }
        }
    }

    public String whereIsTrain(Train train, Date time){
        for(int i = 0; i < getLines().size(); i++){
            if(getLines().get(i).getListTrain().get(i).getId() == train.getId()){
                float Time = 0;
                for(int j = 0; j < getLines().get(i).getSections().size(); j++){


                }

            }
        }
        return "hola";
    }

}

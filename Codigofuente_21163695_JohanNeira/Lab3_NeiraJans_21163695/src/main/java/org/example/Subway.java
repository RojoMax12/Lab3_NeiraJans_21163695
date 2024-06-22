package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class Subway implements UseSubway {
    private int id;
    private String name;
    private List<Line> lines = new ArrayList<>();
    private List<Train> trains = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();

    /**
     * Nombre Subway
     * Descripcion Método que contruye un Subway
     * @param id
     * @param name
     */
    public Subway(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Nombre getName
     * Descripcion Método que obtiene el nombre de un subway
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Nombre getId
     * Descripcion Método que obtiene el id de un subway
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Nombre getLines
     * Descripcion Método que obtiene las lineas de un subway
     * @return lines
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * Nombre getLines
     * Descripcion Método que cambia las lineas de un subway
     */
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    /**
     * Nombre getTrains
     * Descripcion Método que obtiene los trenes de un subway
     * @return lines
     */
    public List<Train> getTrains() {
        return trains;
    }

    /**
     * Nombre setTrains
     * Descripcion Método que cambia los trenes de un subway
     */
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    /**
     * Nombre getDrivers
     * Descripcion Método que obtiene las conductores de un subway
     * @return drivers
     */
    public List<Driver> getDrivers() {
        return drivers;
    }

    /**
     * Nombre setDrivers
     * Descripcion Método que cambia los conductores de un subway
     */
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    /**
     * Nombre setId
     * Descripcion Método que cambia el id de un subway
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Nombre setName
     * Descripcion Método que cambia el nombre de un subway
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Nombre addTrain
     * Descripcion Método que añade trenes a un Subway
     * @param trainList
     */
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

    /**
     * Nombre addLine
     * Descripcion Método que añade lineas a un Subway
     * @param lineList
     */
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

    /**
     * Nombre addDriver
     * Descripcion Método que añade conductores a un Subway
     * @param driverList
     */
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

    /**
     * Nombre toString
     * Descripcion Método que muestra el subway completo
     * @param subway
     * @return String
     */
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

    /**
     * Nombre assignTrainToLine
     * Descripcion Método que asigna un tren a una linea
     * @param train
     * @param line
     */
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

    /**
     * Nombre assignDriverToTrain
     * Descripcion Método que asigna un conductor a un tren, ademas de una un tiempo de salida, una estacion de inicio y una estacion de llegada
     * @param train
     * @param driver
     * @param departureTime
     * @param departureStation
     * @param arrivalStation
     */
    @Override
    public void assignDriverToTrain(Train train, Driver driver, Date departureTime, Station departureStation, Station arrivalStation) {
        List<Station> NewDepartureStation = new ArrayList<>();
        List<Station> NewArrivalStation = new ArrayList<>();
        NewArrivalStation.add(arrivalStation);
        NewDepartureStation.add(departureStation);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departureTime); // Establecer la hora de salida actual
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.JUNE); // Los meses en Calendar son 0-indexados, Junio es 5
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        Date newDepartureTime = calendar.getTime();

        for (Train t : getTrains()) {
            if (t.getId() == train.getId() && t.getTrainMaker().equals(driver.getTrainMaker())) {
                t.getDriverList().add(driver);
                t.setDepartureDate(newDepartureTime);
                t.setDepartureStation(NewDepartureStation);
                t.setArrivalStation(NewArrivalStation);
                break;
            }
        }
    }

    public void whereIsTrain(Train train, Date time) {
        Date timeini = train.getDepartureDate();
        System.out.println("Hora de salida del tren: " + timeini);

        if (getTrains().contains(train)) {

            for (int i = 0; i < getLines().size(); i++) {
                Line line = getLines().get(i);
                if (line.getListTrain().contains(train)) {

                    for (int j = 0; j < line.getSections().size(); j++) {
                        Section section = line.getSections().get(j);

                        if (section.getPoint1().getName().equals(train.getDepartureStation().get(0).getName())) {

                            // Sumar el tiempo de parada en la estación de salida
                            timeini = new Date(timeini.getTime() + section.getPoint1().getStop_time() * 1000);

                            // Sumar el tiempo de parada en la estación de llegada
                            timeini = new Date(timeini.getTime() + section.getPoint2().getStop_time() * 1000);

                            // Sumar el tiempo de viaje de la sección
                            long travelTimeMillis = (long) (section.getDistance() / train.getSpeed() * 3600 * 1000);
                            timeini = new Date(timeini.getTime() + travelTimeMillis);;

                            // Guardar la última estación y la línea por las que el tren ha pasado
                            Station lastStation = section.getPoint2();
                            String lineName = line.getNombre();

                            for (int k = j; k < line.getSections().size(); k++) {
                                if (timeini.compareTo(time) >= 0) {
                                    // Si timeini se ha aproximado a time, mostrar la estación y la línea y salir del bucle
                                    System.out.println("El tren está en la línea: " + lineName + ", cerca de la estación: " + lastStation.getName());
                                    return;
                                }
                                section = line.getSections().get(k);

                                // Guardar la última estación y la línea por las que el tren ha pasado
                                lastStation = section.getPoint2();
                                lineName = line.getNombre();

                                // Sumar el tiempo de parada en la estación de salida
                                timeini = new Date(timeini.getTime() + section.getPoint1().getStop_time() * 1000);

                                // Sumar el tiempo de parada en la estación de llegada
                                timeini = new Date(timeini.getTime() + section.getPoint2().getStop_time() * 1000);

                                // Sumar el tiempo de viaje de la sección
                                travelTimeMillis = (long) (section.getDistance() / train.getSpeed() * 3600 * 1000);
                                timeini = new Date(timeini.getTime() + travelTimeMillis);
                            }
                        }
                    }
                }
            }
            // Si el bucle termina sin encontrar el tren en el tiempo especificado
            System.out.println("El tren ya ha completado su recorrido o no se encuentra en el subway en el momento especificado.");
        } else {
            System.out.println("El tren no está en el subway.");
        }

}

    public List<Station> trainPath(Train train, Date time) {
        Date timeini = train.getDepartureDate();
        List<Station> estacionesFaltantesPorRecorrer = new ArrayList<>();
        System.out.println("Hora de salida del tren: " + timeini);

        if (getTrains().contains(train)) {
            for (int i = 0; i < getLines().size(); i++) {
                Line line = getLines().get(i);
                if (line.getListTrain().contains(train)) {
                    for (int j = 0; j < line.getSections().size(); j++) {
                        Section section = line.getSections().get(j);
                        if (section.getPoint1().getName().equals(train.getDepartureStation().get(0).getName())) {
                            // Sumar el tiempo de parada en la estación de salida
                            timeini = new Date(timeini.getTime() + section.getPoint1().getStop_time() * 1000);

                            // Sumar el tiempo de parada en la estación de llegada
                            timeini = new Date(timeini.getTime() + section.getPoint2().getStop_time() * 1000);

                            // Sumar el tiempo de viaje de la sección
                            long travelTimeMillis = (long) (section.getDistance() / train.getSpeed() * 3600 * 1000);
                            timeini = new Date(timeini.getTime() + travelTimeMillis);

                            // Guardar la última estación y la línea por las que el tren ha pasado
                            Station lastStation = section.getPoint2();
                            String lineName = line.getNombre();

                            for (int k = j; k < line.getSections().size(); k++) {
                                if (timeini.compareTo(time) >= 0) {
                                    // Si timeini se ha aproximado a time, agregar las estaciones restantes y salir del bucle
                                    for (int m = k; m < line.getSections().size(); m++) {
                                        Section remainingSection = line.getSections().get(m);
                                        estacionesFaltantesPorRecorrer.add(remainingSection.getPoint2());
                                    }
                                    System.out.println("El tren está en la línea: " + lineName + ", cerca de la estación: " + lastStation.getName());
                                    return estacionesFaltantesPorRecorrer;
                                }
                                section = line.getSections().get(k);
                                System.out.println("Revisando siguiente sección: " + section);

                                // Guardar la última estación y la línea por las que el tren ha pasado
                                lastStation = section.getPoint2();
                                lineName = line.getNombre();

                                // Sumar el tiempo de parada en la estación de salida
                                timeini = new Date(timeini.getTime() + section.getPoint1().getStop_time() * 1000);
                                System.out.println("Hora después de la parada en la estación de salida: " + timeini);

                                // Sumar el tiempo de parada en la estación de llegada
                                timeini = new Date(timeini.getTime() + section.getPoint2().getStop_time() * 1000);
                                System.out.println("Hora después de la parada en la estación de llegada: " + timeini);

                                // Sumar el tiempo de viaje de la sección
                                travelTimeMillis = (long) (section.getDistance() / train.getSpeed() * 3600 * 1000);
                                timeini = new Date(timeini.getTime() + travelTimeMillis);
                                System.out.println("Hora después del tiempo de viaje: " + timeini);
                            }
                        }
                    }
                }
            }
            // Si el bucle termina sin encontrar el tren en el tiempo especificado
            System.out.println("El tren ya ha completado su recorrido o no se encuentra en el subway en el momento especificado.");
        } else {
            System.out.println("El tren no está en el subway.");
        }
        return estacionesFaltantesPorRecorrer;
    }
}

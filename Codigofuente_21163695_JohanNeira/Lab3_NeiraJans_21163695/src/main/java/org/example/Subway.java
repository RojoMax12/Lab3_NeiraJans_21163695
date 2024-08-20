package org.example;

import java.util.*;

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
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Nombre getId
     * Descripcion Método que obtiene el id de un subway
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Nombre getLines
     * Descripcion Método que obtiene las lineas de un subway
     *
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
     *
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
     *
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
     * Nombre addTrain
     * Descripcion Método que añade trenes a un Subway
     *
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
     *
     * @param lineList
     */
    @Override
    public void addLine(List<Line> lineList) {
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
     *
     * @param driverList
     */
    @Override
    public void addDriver(List<Driver> driverList) {
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
     * Descripcion Método que muestra el subway complet
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subway" + getId() + ":" + "\n")
                .append("  ID: ").append(getId()).append("\n")
                .append("  Name: ").append(getName()).append("\n")
                .append("  Lines:\n");

        for (Line line : getLines()) {
            sb.append("    ").append(line).append("\n");
        }

        sb.append("  Trains:\n");
        for (Train train : getTrains()) {
            sb.append("    ").append(train).append("\n");
        }

        sb.append("  Drivers:\n");
        for (Driver driver : getDrivers()) {
            sb.append("    ").append(driver).append("\n");
        }

        return sb.toString();
    }

    /**
     * Nombre assignTrainToLine
     * Descripcion Método que asigna un tren a una linea
     *
     * @param train
     * @param line
     */
    @Override
    public void assignTrainToLine(Train train, Line line) {
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
     *
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


    /**
     * Nombre whereIsTrain
     * Descripcion Método que permite determinar dónde se encuentra un tren a partir de una hora indicada del día.
     *
     * @param train
     * @param time
     */
    @Override
    public void whereIsTrain(Train train, Date time) {
        Date departureTime = train.getDepartureDate();
        System.out.println("Hora de salida del tren: " + departureTime);

        // Verificar si el tren está en la lista de trenes del subway
        if (!getTrains().contains(train)) {
            System.out.println("El tren no está en el subway.");
            return;
        }

        // Obtener la estación de salida del tren
        Station departureStation = train.getDepartureStation().get(0);
        System.out.println("Estación de salida del tren: " + departureStation.getName());

        Station closestStation = null; // Variable para almacenar la estación más cercana
        Date closestTime = null; // Variable para almacenar el tiempo más cercano encontrado

        for (Line line : getLines()) {
            if (line.getListTrain().contains(train)) {
                System.out.println("El tren está en la línea: " + line.getNombre());

                // Encontrar la sección correspondiente a la estación de salida del tren
                Section startSection = null;
                for (Section section : line.getSections()) {
                    if (section.getPoint1().getName().equals(departureStation.getName())) {
                        startSection = section;
                        break;
                    }
                }

                if (startSection != null) {
                    Date currentTime = new Date(departureTime.getTime());

                    // Sumar el tiempo de parada en la estación de salida
                    currentTime.setTime(currentTime.getTime() + startSection.getPoint1().getStop_time() * 1000);

                    // Sumar el tiempo de parada en la estación de llegada
                    currentTime.setTime(currentTime.getTime() + startSection.getPoint2().getStop_time() * 1000);

                    // Sumar el tiempo de viaje de la sección
                    long travelTimeMillis = (long) (startSection.getDistance() / train.getSpeed() * 3600 * 1000);
                    currentTime.setTime(currentTime.getTime() + travelTimeMillis);

                    // Iterar sobre las secciones restantes de la línea
                    for (int j = line.getSections().indexOf(startSection) + 1; j < line.getSections().size(); j++) {
                        Section section = line.getSections().get(j);

                        // Sumar el tiempo de parada en la estación de salida
                        currentTime.setTime(currentTime.getTime() + section.getPoint1().getStop_time() * 1000);

                        // Sumar el tiempo de parada en la estación de llegada
                        currentTime.setTime(currentTime.getTime() + section.getPoint2().getStop_time() * 1000);

                        // Sumar el tiempo de viaje de la sección
                        travelTimeMillis = (long) (section.getDistance() / train.getSpeed() * 3600 * 1000);
                        currentTime.setTime(currentTime.getTime() + travelTimeMillis);

                        // Verificar si el tiempo calculado supera o iguala el tiempo consultado
                        if (currentTime.compareTo(time) >= 0) {
                            // Si es así, actualizar la estación más cercana
                            closestStation = section.getPoint2();
                            closestTime = currentTime;
                            break; // Salir del bucle, ya que hemos encontrado la estación más cercana
                        }
                    }
                }
            }
        }

        // Mostrar la estación más cercana encontrada
        if (time.before(departureTime)) {
            System.out.println("El tren aún no ha salido. Está programado para salir a las " + departureTime);
        } else if (time.equals(departureTime)) {
            System.out.println("El tren está apunto de salir o está en la estación de salida.");
        } else if (closestStation != null && closestTime != null) {
            System.out.println("El tren está cerca de la estación: " + closestStation.getName());
        } else {
            // Si no se encontró ninguna estación cercana
            System.out.println("El tren ya ha completado su recorrido o no se encuentra en el subway en el momento especificado.");
        }
    }


    /**
     * Nombre trainPath
     * Descripcion Método que permite ir armando el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.
     *
     * @param train
     * @param time
     * @return remainingPath
     */
    @Override
    public List<Station> trainPath(Train train, Date time) {
            List<Station> remainingPath = new ArrayList<>();
            Date departureTime = train.getDepartureDate();
            System.out.println("Hora de salida del tren: " + departureTime);

            // Verificar si el tren está en la lista de trenes del subway
            if (!getTrains().contains(train)) {
                System.out.println("El tren no está en el subway.");
                return remainingPath;
            }

            // Obtener la estación de salida del tren
            Station departureStation = train.getDepartureStation().get(0);
            System.out.println("Estación de salida del tren: " + departureStation.getName());

            Station closestStation = null;
            Date closestTime = null;

            for (Line line : getLines()) {
                if (line.getListTrain().contains(train)) {
                    System.out.println("El tren está en la línea: " + line.getNombre());

                    Section startSection = null;
                    for (Section section : line.getSections()) {
                        if (section.getPoint1().getName().equals(departureStation.getName())) {
                            startSection = section;
                            break;
                        }
                    }

                    if (startSection != null) {
                        Date currentTime = new Date(departureTime.getTime());

                        // Sumar el tiempo de parada en la estación de salida
                        currentTime.setTime(currentTime.getTime() + startSection.getPoint1().getStop_time() * 1000);

                        // Sumar el tiempo de viaje de la sección
                        long travelTimeMillis = (long) (startSection.getDistance() / train.getSpeed() * 3600 * 1000);
                        currentTime.setTime(currentTime.getTime() + travelTimeMillis);

                        // Sumar el tiempo de parada en la estación de llegada
                        currentTime.setTime(currentTime.getTime() + startSection.getPoint2().getStop_time() * 1000);

                        // Iterar sobre las secciones restantes de la línea
                        boolean pastConsultedTime = false;
                        for (int j = line.getSections().indexOf(startSection); j < line.getSections().size(); j++) {
                            Section section = line.getSections().get(j);

                            // Verificar si el tiempo calculado supera o iguala el tiempo consultado
                            if (currentTime.compareTo(time) >= 0) {
                                if (!pastConsultedTime) {
                                    pastConsultedTime = true;
                                    closestStation = section.getPoint1();
                                    closestTime = currentTime;
                                }
                                // Agregar todas las estaciones restantes a remainingPath
                                if (!remainingPath.contains(section.getPoint1())) {
                                    remainingPath.add(section.getPoint1());
                                }
                                remainingPath.add(section.getPoint2());
                            }

                            // Sumar el tiempo de parada en la estación de salida
                            currentTime.setTime(currentTime.getTime() + section.getPoint1().getStop_time() * 1000);

                            // Sumar el tiempo de viaje de la sección
                            travelTimeMillis = (long) (section.getDistance() / train.getSpeed() * 3600 * 1000);
                            currentTime.setTime(currentTime.getTime() + travelTimeMillis);

                            // Sumar el tiempo de parada en la estación de llegada
                            currentTime.setTime(currentTime.getTime() + section.getPoint2().getStop_time() * 1000);
                        }
                    }
                }
            }

            // Mostrar la estación más cercana encontrada
            if (time.before(departureTime)) {
                System.out.println("El tren aún no ha salido. Está programado para salir a las " + departureTime);
            } else if (time.equals(departureTime)) {
                System.out.println("El tren está a punto de salir o está en la estación de salida.");
            } else if (closestStation != null && closestTime != null) {
                System.out.println("El tren está cerca de la estación: " + closestStation.getName());
            } else {
                System.out.println("El tren ya ha completado su recorrido o no se encuentra en el subway en el momento especificado.");
            }

            return remainingPath;
        }

}


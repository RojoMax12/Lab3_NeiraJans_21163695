package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CargaDedatos implements UseCargaDedatos {
    private Subway subway;
    private List<PassengerCar> passengerCarList = new ArrayList<>();

    /**
     * Nombre CargaDedatos
     * Descripcion Metodo que construye una carga de datos
     * @param subway
     */
    public CargaDedatos(Subway subway) {
        this.subway = subway;
    }

    /**
     * Nombre getSubway
     * Descripcion Metodo que obtiene un subway
     * @return Subway
     */
    public Subway getSubway() {
        return subway;
    }

    /**
     * Nombre setSubway
     * Descripcion Metodo que modifica el Subway
     * @param subway
     */
    public void setSubway(Subway subway) {
        this.subway = subway;
    }

    /**
     * Nombre getPassengerCarList
     * Descripcion Metodo que obtiene la lista de PassengerCarList
     * @return passengerCarList
     */
    public List<PassengerCar> getPassengerCarList() {
        return passengerCarList;
    }

    /**
     * @Nombre loadFromFileTrain
     * @Descripcion Metodo que carga las lineas a la Red de metro y el la Red de Metro
     * @param scanner
     * @param subway
     * @return Subway
     */

    public Subway loadFromFileSubway(Scanner scanner, Subway subway) {
        System.out.print("Ingrese el nombre del archivo (incluyendo la extensión .txt): ");
        String fileName = scanner.next();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado: " + fileName);
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            List<Station> stations = new ArrayList<>();
            List<Section> sections = new ArrayList<>();
            List<Line> lineList = new ArrayList<>();
            Map<String, Station> stationMap = new HashMap<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    String identifier = parts[0];

                    switch (identifier) {
                        case "STATION":
                            if (parts.length >= 5) {
                                int id = Integer.parseInt(parts[1]);
                                String name = parts[2];
                                StationType type = StationType.valueOf(parts[3].toUpperCase());
                                int stopTime = Integer.parseInt(parts[4]);

                                Station station = new Station(id, name, type, stopTime);
                                stations.add(station);
                                stationMap.put(name.toLowerCase(), station); // Guardar en minúsculas
                            } else {
                                System.out.println("Formato incorrecto para STATION: " + line);
                            }
                            break;

                        case "SECTION":
                            if (parts.length >= 5) {
                                String station1Name = parts[1];
                                String station2Name = parts[2];
                                float distance = Float.parseFloat(parts[3]);
                                float cost = Float.parseFloat(parts[4]);

                                Station point1 = stationMap.get(station1Name.toLowerCase()); // Buscar en minúsculas
                                Station point2 = stationMap.get(station2Name.toLowerCase()); // Buscar en minúsculas
                                if (point1 != null && point2 != null) {
                                    Section section = new Section(point1, point2, distance, cost);
                                    sections.add(section);
                                } else {
                                    System.out.println("Error al crear la sección: estación no encontrada para " + line);
                                }
                            } else {
                                System.out.println("Formato incorrecto para SECTION: " + line);
                            }
                            break;

                        case "LINE":
                            if (parts.length >= 4) {
                                int lineId = Integer.parseInt(parts[1]);
                                String lineName = parts[2];
                                String railType = parts[3];

                                Line lineObject = new Line(lineId, lineName, railType, new ArrayList<>());
                                for (Section section : sections) {
                                    lineObject = lineObject.line_add_section(section);
                                }
                                lineList.add(lineObject);
                                sections.clear();  // Limpiar secciones después de agregarlas a una línea
                            } else {
                                System.out.println("Formato incorrecto para LINE: " + line);
                            }
                            break;

                        case "SUBWAY":
                            if (parts.length >= 3) {
                                if (subway.getId() == 9999 && subway.getName().equals("Nada")) {
                                    int subwayId = Integer.parseInt(parts[1]);
                                    subway.setId(subwayId);
                                    subway.setName(parts[2]);
                                    subway.addLine(lineList);
                                    System.out.println("Subway creado");
                                } else {
                                    subway.addLine(lineList);
                                    return subway;
                                }
                            } else {
                                System.out.println("Formato incorrecto para SUBWAY: " + line);
                            }
                            break;

                        default:
                            System.out.println("Identificador desconocido: " + identifier);
                    }
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return subway;
    }



    /**
     * @Nombre loadFromFileTrain
     * @Descripcion Metodo que carga los trenes a la Red de metro y a la lineas correspondientes
     * @param scanner
     * @param subway
     * @param cargaDedatos
     * @return Subway
     */
    @Override
    public Subway loadFromFileTrain(Scanner scanner, Subway subway, CargaDedatos cargaDedatos) {
        System.out.print("Ingrese el nombre del archivo (incluyendo la extensión .txt): ");
        String fileName = scanner.next();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado: " + fileName);
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            List<PassengerCar> passengerCarList = new ArrayList<>();
            List<Train> trainList = new ArrayList<>();
            List<Train> trainListSubway = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    String identifier = parts[0];

                    switch (identifier) {
                        case "PASSENGERCAR":
                            if (parts.length >= 6) {
                                int id = Integer.parseInt(parts[1]);
                                int capacity = Integer.parseInt(parts[2]);
                                String model = parts[3];
                                String trainmaker = parts[4];
                                CarType carType = CarType.valueOf(parts[5].toUpperCase());

                                PassengerCar passengerCar = new PassengerCar(id, capacity, model, trainmaker, carType);
                                passengerCarList.add(passengerCar);
                                cargaDedatos.passengerCarList.add(passengerCar);

                            } else {
                                System.out.println("Formato incorrecto para PASSENGERCAR: " + line);
                            }
                            break;

                        case "TRAIN":
                            if (parts.length >= 4) {
                                int id = Integer.parseInt(parts[1]);
                                String trainmaker = parts[2];
                                int speed = Integer.parseInt(parts[3]);
                                Train train = new Train(id, trainmaker, speed, new ArrayList<>(passengerCarList));
                                trainList.add(train);
                                trainListSubway.add(train);
                                passengerCarList.clear();
                            } else {
                                System.out.println("Formato incorrecto para TRAIN: " + line);
                            }
                            break;

                        case "LINE":
                            if (parts.length >= 2) {
                                int lineId = Integer.parseInt(parts[1]);
                                if (lineId >= 0 && lineId < subway.getLines().size()) {
                                    subway.assignTrainToLine(trainList.get(0), subway.getLines().get(lineId));
                                    trainList.clear();
                                } else {
                                    System.out.println("Línea no encontrada: " + lineId);
                                }
                            } else {
                                System.out.println("Formato incorrecto para LINE: " + line);
                            }
                            break;

                        default:
                            System.out.println("Identificador desconocido: " + identifier);
                    }
                }
            }

            if (!trainListSubway.isEmpty()) {
                subway.addTrain(trainListSubway);
                System.out.println("Trenes asignados a la Red de metro y a las Lineas");
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return subway;
    }


    /**
     * @Nombre loadFromFileDriver
     * @Descripcion Metodo que carga los conductores a la Red de metro y los trenes correspondientes
     * @param scanner
     * @param subway
     * @return Subway
     */
    @Override
    public Subway loadFromFileDriver(Scanner scanner, Subway subway) {
        System.out.print("Ingrese el nombre del archivo (incluyendo la extensión .txt): ");
        String fileName = scanner.next();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado: " + fileName);
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            List<Driver> driverList = new ArrayList<>();
            List<Driver> driverListSubway = new ArrayList<>();
            List<Station> stationList = new ArrayList<>();
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    String identifier = parts[0];

                    switch (identifier) {
                        case "DRIVER":
                            if (parts.length >= 4) {
                                int id = Integer.parseInt(parts[1]);
                                String name = parts[2];
                                String trainmaker = parts[3];

                                Driver driver = new Driver(id, name, trainmaker);
                                driverList.add(driver);
                                driverListSubway.add(driver);
                            } else {
                                System.out.println("Formato incorrecto para DRIVER: " + line);
                            }
                            break;

                        case "STATION":
                            if (parts.length >= 5) {
                                int id = Integer.parseInt(parts[1]);
                                String name = parts[2];
                                StationType type = StationType.valueOf(parts[3].toUpperCase());
                                int stoptime = Integer.parseInt(parts[4]);
                                Station station = new Station(id, name, type, stoptime);
                                stationList.add(station);

                            } else {
                                System.out.println("Formato incorrecto para STATION: " + line);
                            }
                            break;

                        case "TRAIN":
                            if (parts.length >= 5) {
                                int id = Integer.parseInt(parts[1]);
                                Date date = timeFormatter.parse(parts[2]);
                                String startStationName = parts[3];
                                String endStationName = parts[4];

                                Station startStation = stationList.stream()
                                        .filter(station -> station.getName().equals(startStationName))
                                        .findFirst()
                                        .orElse(null);

                                Station endStation = stationList.stream()
                                        .filter(station -> station.getName().equals(endStationName))
                                        .findFirst()
                                        .orElse(null);

                                if (startStation != null && endStation != null && !driverList.isEmpty()) {
                                    subway.assignDriverToTrain(
                                            subway.getTrains().get(id),
                                            driverList.get(0),
                                            date,
                                            startStation,
                                            endStation
                                    );
                                    driverList.clear();
                                    stationList.clear();
                                } else {
                                    System.out.println("Error al asignar el tren: estaciones o conductores no encontrados.");
                                }
                            } else {
                                System.out.println("Formato incorrecto para TRAIN: " + line);
                            }
                            break;

                        default:
                            System.out.println("Identificador desconocido: " + identifier);
                    }
                }
            }

            // Después de leer todo el archivo, asegúrate de agregar los conductores restantes al subway
            if (!driverListSubway.isEmpty()) {
                subway.addDriver(driverListSubway);
                System.out.println("Conductores asignados a la Red de metro y a sus respectivos Trenes");
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return subway;
    }


    /**
     * @Nombre loadFromFileCombination
     * @Descripcion Metodo que carga las combinaciones a la Red de metro
     * @param scanner
     * @param subway
     * @return Subway
     */
    @Override
    public Subway loadFromFileCombination(Scanner scanner, Subway subway) {
        System.out.print("Ingrese el nombre del archivo (incluyendo la extensión .txt): ");
        String fileName = scanner.next();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado: " + fileName);
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            List<Station> stations = new ArrayList<>();
            List<Section> sections = new ArrayList<>();
            List<Line> lineList = new ArrayList<>();
            Map<String, Station> stationMap = new HashMap<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    String identifier = parts[0];

                    switch (identifier) {
                        case "STATION":
                            if (parts.length >= 5) {
                                int id = Integer.parseInt(parts[1]);
                                String name = parts[2];
                                StationType type = StationType.valueOf(parts[3].toUpperCase());
                                int stopTime = Integer.parseInt(parts[4]);

                                Station station = new Station(id, name, type, stopTime);
                                stations.add(station);
                                stationMap.put(name, station); // Guardar en minúsculas
                            } else {
                                System.out.println("Formato incorrecto para STATION: " + line);
                            }
                            break;

                        case "SECTION":
                            if (parts.length >= 5) {
                                String station1Name = parts[1];
                                String station2Name = parts[2];
                                float distance = Float.parseFloat(parts[3]);
                                float cost = Float.parseFloat(parts[4]);

                                Station point1 = stationMap.get(station1Name); // Buscar en minúsculas
                                Station point2 = stationMap.get(station2Name); // Buscar en minúsculas
                                if (point1 != null && point2 != null) {
                                    Section section = new Section(point1, point2, distance, cost);
                                    sections.add(section);
                                } else {
                                    System.out.println("Error al crear la sección: estación no encontrada para " + line);
                                }
                            } else {
                                System.out.println("Formato incorrecto para SECTION: " + line);
                            }
                            break;

                        case "LINE":
                            if (parts.length >= 4) {
                                int lineId = Integer.parseInt(parts[1]);
                                String lineName = parts[2];
                                String railType = parts[3];

                                Line lineObject = new Line(lineId, lineName, railType, new ArrayList<>(sections));
                                lineList.add(lineObject);
                                sections.clear();  // Limpiar secciones después de agregarlas a una línea
                            } else {
                                System.out.println("Formato incorrecto para LINE: " + line);
                            }
                            break;

                        default:
                            System.out.println("Identificador desconocido: " + identifier);
                    }
                }
            }
            if (!lineList.isEmpty()) {
                subway.addLine(lineList);
                System.out.println("Combinaciones añadidas a la Red de metro");
                return subway;
            }

        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return subway;
    }


}

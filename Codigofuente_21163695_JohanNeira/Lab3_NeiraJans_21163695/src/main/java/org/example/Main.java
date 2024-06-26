package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        Subway subway = new Subway(1, "Metro De Santiago");
        List<Section> sectionListL1 = new ArrayList<>();
        List<Section> sectionListL2 = new ArrayList<>();
        List<Section> sectionListL3 = new ArrayList<>();
        List<Section> sectionListL4 = new ArrayList<>();
        List<Section> sectionListL5 = new ArrayList<>();
        List<Line> lineList = new ArrayList<>();
        List<PassengerCar> ListGeneralPassengerCar = new ArrayList<>();

        // Crear estaciones de la Línea 1
        Station s1_1 = new Station(1, "SanPablo", StationType.T, 120);
        Station s1_2 = new Station(2, "LosHeroes", StationType.C, 60);
        Station s1_3 = new Station(3, "LaMoneda", StationType.R, 60);
        Station s1_4 = new Station(4, "UniversidadDeChile", StationType.R, 60);
        Station s1_5 = new Station(5, "SantaLucía", StationType.R, 60);
        Station s1_6 = new Station(6, "Baquedano", StationType.R, 60);
        Station s1_7 = new Station(7, "Tobalaba", StationType.T, 120);

        // Crear secciones de la Línea 1
        Section sec1_1 = new Section(s1_1, s1_2, 3.5f, 500);
        Section sec1_2 = new Section(s1_2, s1_3, 1.2f, 200);
        Section sec1_3 = new Section(s1_3, s1_4, 1.0f, 150);
        Section sec1_4 = new Section(s1_4, s1_5, 0.8f, 120);
        Section sec1_5 = new Section(s1_5, s1_6, 1.3f, 180);
        Section sec1_6 = new Section(s1_6, s1_7, 4.0f, 600);

        // Agregar secciones
        sectionListL1.add(sec1_1);
        sectionListL1.add(sec1_2);
        sectionListL1.add(sec1_3);
        sectionListL1.add(sec1_4);
        sectionListL1.add(sec1_5);
        sectionListL1.add(sec1_6);

        // Crear Línea 1
        Line line1 = new Line(1, "Línea 1", "Standard", sectionListL1);

        // Crear estaciones de la Línea 2
        Station s2_1 = new Station(8, "VespucioNorte", StationType.T, 120);
        Station s2_2 = new Station(9, "CerroBlanco", StationType.R, 60);
        Station s2_3 = new Station(10, "LosHeroes", StationType.C, 60);
        Station s2_4 = new Station(11, "SantaAna", StationType.R, 60);
        Station s2_5 = new Station(12, "Patronato", StationType.R, 60);
        Station s2_6 = new Station(13, "VespucioSur", StationType.T, 120);

        // Crear secciones de la Línea 2
        Section sec2_1 = new Section(s2_1, s2_2, 4.0f, 500);
        Section sec2_2 = new Section(s2_2, s2_3, 3.0f, 400);
        Section sec2_3 = new Section(s2_3, s2_4, 1.5f, 200);
        Section sec2_4 = new Section(s2_4, s2_5, 1.2f, 180);
        Section sec2_5 = new Section(s2_5, s2_6, 5.0f, 650);

        // Agregar secciones
        sectionListL2.add(sec2_1);
        sectionListL2.add(sec2_2);
        sectionListL2.add(sec2_3);
        sectionListL2.add(sec2_4);
        sectionListL2.add(sec2_5);

        // Crear Línea 2
        Line line2 = new Line(2, "Línea 2", "Standard", sectionListL2);


        // Crear estaciones de la Línea 3
        Station s3_1 = new Station(14, "LosLibertadores", StationType.T, 120);
        Station s3_2 = new Station(15, "PlazaDeArmas", StationType.R, 60);
        Station s3_3 = new Station(16, "UniversidadDeChile", StationType.C, 60);
        Station s3_4 = new Station(17, "Irarrazaval", StationType.R, 60);
        Station s3_5 = new Station(18, "PlazaEgaña", StationType.R, 60);
        Station s3_6 = new Station(19, "FernandoCastilloVelasco", StationType.T, 120);

        // Crear secciones de la Línea 3
        Section sec3_1 = new Section(s3_1, s3_2, 3.8f, 500);
        Section sec3_2 = new Section(s3_2, s3_3, 1.5f, 200);
        Section sec3_3 = new Section(s3_3, s3_4, 3.0f, 400);
        Section sec3_4 = new Section(s3_4, s3_5, 4.2f, 550);
        Section sec3_5 = new Section(s3_5, s3_6, 2.5f, 300);

        // Agregar secciones

        sectionListL3.add(sec3_1);
        sectionListL3.add(sec3_2);
        sectionListL3.add(sec3_3);
        sectionListL3.add(sec3_4);
        sectionListL3.add(sec3_5);

        // Crear Línea 3
        Line line3 = new Line(3, "Línea 3", "1", sectionListL3);


        // Crear estaciones de la Línea 4
        Station s4_1 = new Station(20, "Tobalaba", StationType.T, 120);
        Station s4_2 = new Station(21, "CristobalColon", StationType.M, 60);
        Station s4_3 = new Station(22, "FranciscoBilbao", StationType.R, 60);
        Station s4_4 = new Station(23, "PrincipeDeGales", StationType.R, 60);
        Station s4_5 = new Station(24, "PlazaEgaña", StationType.M, 60);
        Station s4_6 = new Station(25, "VicuñaMackenna", StationType.T, 120);

        // Crear secciones de la Línea 4
        Section sec4_1 = new Section(s4_1, s4_2, 2.8f, 400);
        Section sec4_2 = new Section(s4_2, s4_3, 1.3f, 180);
        Section sec4_3 = new Section(s4_3, s4_4, 1.7f, 220);
        Section sec4_4 = new Section(s4_4, s4_5, 2.0f, 250);
        Section sec4_5 = new Section(s4_5, s4_6, 3.5f, 450);

        // Agregar secciones

        sectionListL4.add(sec4_1);
        sectionListL4.add(sec4_2);
        sectionListL4.add(sec4_3);
        sectionListL4.add(sec4_4);
        sectionListL4.add(sec4_5);

        // Crear Línea 4
        Line line4 = new Line(4, "Línea 4", "Standard", sectionListL4 );

        // Crear estaciones de la Línea 5
        Station s5_1 = new Station(26, "PlazaMaipu", StationType.T, 120);
        Station s5_2 = new Station(27, "Barrancas", StationType.R, 60);
        Station s5_3 = new Station(28, "LasRejas", StationType.R, 60);
        Station s5_4 = new Station(29, "SantaAna", StationType.R, 60);
        Station s5_5 = new Station(30, "Irarrazaval", StationType.C, 60);
        Station s5_6 = new Station(31, "ParqueBustamante", StationType.T, 120);

        // Crear secciones de la Línea 5
        Section sec5_1 = new Section(s5_1, s5_2, 4.2f, 500);
        Section sec5_2 = new Section(s5_2, s5_3, 3.5f, 450);
        Section sec5_3 = new Section(s5_3, s5_4, 5.0f, 500);
        Section sec5_4 = new Section(s5_4, s5_5, 3.5f, 450);
        Section sec5_5 = new Section(s5_5, s5_6, 2.8f, 350);

        // Agregar secciones

        sectionListL5.add(sec5_1);
        sectionListL5.add(sec5_2);
        sectionListL5.add(sec5_3);
        sectionListL5.add(sec5_4);
        sectionListL5.add(sec5_5);


        // Crear Línea 5
        Line line5 = new Line(5, "Línea 5", "Standard", sectionListL5);

        lineList.add(line1);
        lineList.add(line2);
        lineList.add(line3);
        lineList.add(line4);
        lineList.add(line5);

        // Crear 7 coches de pasajeros, con al menos 2 de tipo TR
        PassengerCar car1 = new PassengerCar(1, 100, "Model A", "Maker A", CarType.CT);
        PassengerCar car2 = new PassengerCar(2, 80, "Model B", "Maker B", CarType.CT);
        PassengerCar car3 = new PassengerCar(3, 50, "Model C", "Maker C", CarType.TR);
        PassengerCar car4 = new PassengerCar(4, 120, "Model D", "Maker A", CarType.CT);
        PassengerCar car5 = new PassengerCar(5, 90, "Model E", "Maker B", CarType.TR);
        PassengerCar car6 = new PassengerCar(6, 70, "Model F", "Maker C", CarType.CT);
        PassengerCar car7 = new PassengerCar(7, 110, "Model G", "Maker A", CarType.CT);

        // Crear listas de coches de pasajeros para cada tren, con TR en los extremos
        List<PassengerCar> carList1 = new ArrayList<>();
        carList1.add(car3);
        carList1.add(car1);
        carList1.add(car2);
        carList1.add(car5);

        List<PassengerCar> carList2 = new ArrayList<>();
        carList2.add(car3);
        carList2.add(car4);
        carList2.add(car6);
        carList2.add(car5);

        List<PassengerCar> carList3 = new ArrayList<>();
        carList3.add(car3);
        carList3.add(car1);
        carList3.add(car2);
        carList3.add(car5);

        List<PassengerCar> carList4 = new ArrayList<>();
        carList4.add(car3);
        carList4.add(car4);
        carList4.add(car6);
        carList4.add(car5);

        List<PassengerCar> carList5 = new ArrayList<>();
        carList5.add(car3);
        carList5.add(car2);
        carList5.add(car7);
        carList5.add(car5);

        // Crear 5 trenes
        Train train1 = new Train(1, "Maker A", 80, carList1);
        Train train2 = new Train(2, "Maker B", 90, carList2);
        Train train3 = new Train(3, "Maker C", 100, carList3);
        Train train4 = new Train(4, "Maker A", 85, carList4);
        Train train5 = new Train(5, "Maker B", 95, carList5);

        // Crear 5 conductores
        Driver driver1 = new Driver(1, "Carlos Perez", "Maker A");
        Driver driver2 = new Driver(2, "Maria Lopez", "Maker B");
        Driver driver3 = new Driver(3, "Juan Gonzalez", "Maker C");
        Driver driver4 = new Driver(4, "Ana Martinez", "Maker A");
        Driver driver5 = new Driver(5, "Luis Ramirez", "Maker B");

        // Mostrar información de los trenes y conductores
        List<Train> trains = new ArrayList<>();
        trains.add(train1);
        trains.add(train2);
        trains.add(train3);
        trains.add(train4);
        trains.add(train5);

        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        drivers.add(driver4);
        drivers.add(driver5);

        subway.addDriver(drivers);
        subway.addLine(lineList);
        subway.addTrain(trains);
        subway.assignTrainToLine(train1, line1);
        subway.assignTrainToLine(train2, line2);
        subway.assignTrainToLine(train3, line3);
        subway.assignTrainToLine(train4, line4);
        subway.assignTrainToLine(train5, line5);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date departureTime = timeFormat.parse("06:00:00");
        subway.assignDriverToTrain(train1, driver1, departureTime, s1_1, s1_7);
        subway.assignDriverToTrain(train2,driver2,departureTime,s2_1,s2_6);
        subway.assignDriverToTrain(train3,driver3,departureTime,s3_1,s3_6);
        subway.assignDriverToTrain(train4,driver4,departureTime,s4_1,s4_6);
        subway.assignDriverToTrain(train5,driver5,departureTime,s5_1,s5_6);


        ListGeneralPassengerCar.add(car1);
        ListGeneralPassengerCar.add(car2);
        ListGeneralPassengerCar.add(car3);
        ListGeneralPassengerCar.add(car4);
        ListGeneralPassengerCar.add(car5);
        ListGeneralPassengerCar.add(car6);

        Menu menu = new Menu();
        menu.showMenu(subway, ListGeneralPassengerCar);

    }

}



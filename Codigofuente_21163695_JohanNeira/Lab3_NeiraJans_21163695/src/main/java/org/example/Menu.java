package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Menu implements UseMenu {
    private Scanner scanner;

    /**
     * Nombre Menu
     * Descripcion  Método que construye un menu
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
    }


    public Date getTimeFromUser() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setLenient(false); // Para asegurarse de que el formato sea estricto
        Date time = null;
        Scanner scanner = new Scanner(System.in);

        while (time == null) {
            System.out.print("Ingrese la hora en formato HH:MM:SS: ");
            String timeString = scanner.next();
            try {
                time = sdf.parse(timeString);
            } catch (ParseException e) {
                System.out.println("Formato de hora incorrecto. Por favor, intente de nuevo.");
            }
        }

        return time;
    }

    /**
     * Nombre getUserChoice
     * Descripcion  Método que obtiene un int por linea de comando
     * @return scanner.nextInt()
     */
    public int getUserChoice() {
        System.out.print("Introduce tu elección: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, introduce un número.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Nombre obtenerStrings
     * Descripcion  Método que obtiene un string por linea de comando separados por ,
     * @return strings
     */
    public String[] obtenerStrings() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa múltiples strings separados por coma (,): ");
        String input = scanner.nextLine();

        // Dividir la entrada por comas para obtener cada string
        String[] strings = input.split(",");

        for (String str : strings) {
            System.out.println(str.trim()); // trim() para eliminar espacios en blanco alrededor
        }

        // Retornar el array de strings obtenidos
        return strings;
    }


    /**
     * Nombre showMenu
     * Descripcion  Método que muestra el Menu pricipal
     * @param subway
     */
    @Override
    public void showMenu(Subway subway) {
        boolean exit = false;
        CargaDedatos cargaDedatos = new CargaDedatos(subway);

        while (!exit) {
            System.out.print("\033c");
            displayOptionsInicio();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    System.out.print("\033c");
                    option1(cargaDedatos); // Actualizar subway con el resultado de option1
                    break;
                case 2:
                    System.out.print("\033c");
                    option2(cargaDedatos.getSubway());
                    break;
                case 3:
                    System.out.print("\033c");
                    option3(cargaDedatos.getSubway(),cargaDedatos);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta nuevamente.");
            }
        }

        scanner.close();
    }


    /**
     * Nombre option1
     * Descripcion  Método que genera un y ademas muestra el menu de la opcion1 del Menu principal
     * @param cargaDedatos
     */
    @Override
    public void option1(CargaDedatos cargaDedatos){
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                displayOptionsOption1();
                int choice = getUserChoice();

                switch (choice) {
                    case 1:
                        cargaDedatos.setSubway(cargaDedatos.loadFromFileSubway(scanner, cargaDedatos.getSubway()));
                        break;
                    case 2:
                        cargaDedatos.setSubway(cargaDedatos.loadFromFileCombination(scanner, cargaDedatos.getSubway()));
                        break;
                    case 3:
                        cargaDedatos.setSubway(cargaDedatos.loadFromFileTrain(scanner, cargaDedatos.getSubway(),cargaDedatos));
                        break;
                    case 4:
                        cargaDedatos.setSubway(cargaDedatos.loadFromFileDriver(scanner,cargaDedatos.getSubway()));
                        break;
                    case 5:
                        System.out.print("\033c");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida, por favor intenta nuevamente.");
                }
            }
    }


    /**
     * Nombre option2
     * Descripcion Método que genera un el menu y ademas muestra de la opcion2 del Menu principal
     * @param subway
     */
    @Override
    public void option2(Subway subway) {
        boolean exit = false;

        while (!exit) {
            displayOptionsOption2();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println(subway.toString(subway));
                    break;
                case 2:
                    System.out.print("\033c");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta nuevamente.");
            }
        }
    }

    /**
     * Nombre option3
     * Descripcion  Método que genera un menu y ademas muestra de la opcion3 del Menu principal
     * @param subway
     * @param cargaDedatos
     */
    @Override
    public void option3(Subway subway, CargaDedatos cargaDedatos) {
        boolean exit = false;

        while (!exit) {
            displayOptionsOption3();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el ID de la línea que desea calcular la distancia total:");
                    int lineId1 = getUserChoice();
                    System.out.println("La distancia total de la línea " + lineId1 + " es de: " + subway.getLines().get(lineId1).line_length());
                    break;

                case 2:
                    System.out.println("Ingrese el ID de la línea que desea calcular la distancia por tramos:");
                    int lineId2 = getUserChoice();
                    String[] strings = obtenerStrings();
                    System.out.println("La distancia total del tramo " + strings[0] + " a " + strings[1] + " en la línea " + lineId2 + " es de: " + subway.getLines().get(lineId2).line_section_length(strings[0], strings[1]));
                    break;

                case 3:
                    System.out.println("Ingrese el ID de la línea que desea calcular el costo total:");
                    int lineId3 = getUserChoice();
                    System.out.println("El costo total de la línea " + lineId3 + " es de: " + subway.getLines().get(lineId3).line_cost());
                    break;

                case 4:
                    System.out.println("Ingrese el ID de la línea que desea calcular el costo por tramos:");
                    int lineId4 = getUserChoice();
                    String[] strings1 = obtenerStrings();
                    System.out.println("El costo total del tramo " + strings1[0] + " a " + strings1[1] + " en la línea " + lineId4 + " es de: " + subway.getLines().get(lineId4).line_section_cost(strings1[0], strings1[1]));
                    break;

                case 5:
                    System.out.println("Ingrese el ID de la línea para determinar si cumple los requisitos:");
                    int lineId5 = getUserChoice();
                    System.out.println("¿La línea " + subway.getLines().get(lineId5).getId() + " cumple los requisitos de ser una línea?: " + subway.getLines().get(lineId5).isline(subway.getLines().get(lineId5)));
                    break;

                case 6:
                    System.out.println("Ingrese el ID de el tren a modificar:");
                    int trainId6 = getUserChoice();
                    System.out.println("\n");
                    System.out.println("Lista de PassagerCar: "+cargaDedatos.getPassengerCarList().toString());
                    int position = getUserChoice();
                    subway.getTrains().get(trainId6).addCar(cargaDedatos.getPassengerCarList().get(trainId6), position);
                    break;

                case 7:
                    System.out.println("Ingrese el ID de el tren a modificar:");
                    int trainId7 = getUserChoice();
                    System.out.println("\n");
                    int positionremove = getUserChoice();
                    subway.getTrains().get(trainId7).removeCar(subway.getTrains().get(trainId7), positionremove);
                    break;

                case 8:
                    System.out.println("Ingrese el ID de el tren a para determinar si cumple los requisitos:");
                    int trainId8 = getUserChoice();
                    System.out.println("El tren"+subway.getTrains().get(trainId8).getId() + "cumple los requisitos?: " + subway.getTrains().get(trainId8).isTrain(subway.getTrains().get(trainId8)));
                    break;
                case 9:
                    System.out.println("Ingrese el ID de el tren que desea saber su capacidad maxima:");
                    int trainId9 = getUserChoice();
                    System.out.println("La capacidad maxima del Tren"+subway.getTrains().get(trainId9).getId() + "es de: " + subway.getTrains().get(trainId9).fetchCapacity());
                    break;
                case 10:
                    System.out.println("Ingrese el ID de el tren que saber donde se encuentra");
                    int trainId10 = getUserChoice();
                    Train train = subway.getTrains().get(trainId10);
                    Date date = getTimeFromUser();
                    subway.whereIsTrain(train, date);
                    break;
                case 11:
                    System.out.println("Ingrese el ID de el tren que saber donde se encuentra");
                    int trainId11 = getUserChoice();
                    Train train1 = subway.getTrains().get(trainId11);
                    Date date1 = getTimeFromUser();
                    System.out.println("El recorrido faltante del tren es: " + subway.trainPath(train1, date1).toString());
                    break;

                case 12:
                    System.out.print("\033c");
                    exit = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intenta nuevamente.");
            }
        }
    }


    /**
     * Nombre displayOptionsInicio
     * Descripcion  Metodo que muestra las opciones del Menu principal
     */
    @Override
    public void displayOptionsInicio() {
        System.out.println("\n### Sistema Metro - Inicio ###");
        System.out.println("Opciones de creación de la red de metro y simulación de ejecución");
        System.out.println("Selecciona una opción:");
        System.out.println("1. Cargar información del sistema de metro");
        System.out.println("2. Visualizar estado actual del sistema de metro");
        System.out.println("3. Interactuar con el sistema de metro");
        System.out.println("4. Salir del programa");
    }


    /**
     * Nombre displayOptionsOption1
     * Descripcion  Metodo que muestra las opciones de la opcion1 del Menu principal
     */
    @Override
    public void displayOptionsOption1() {
        System.out.println("\n### Sistema Metro - Cargar información del sistema de metro ###");
        System.out.println("Definiciones estructurales de su sistema subido desde archivos");
        System.out.println("Selecciona una opción:");
        System.out.println("1. Creación de una línea de metro básica (cargar archivo lineas.txt)");
        System.out.println("2. Combinaciones entre estaciones entre Líneas  (cargar archivo combinaciones.txt)");
        System.out.println("3. Definición de trenes con distintos número de carros (cargar archivo trenes.txt)");
        System.out.println("4. Conductores asignados a una Línea (cargar archivo conductores.txt)");
        System.out.println("5. Retorno al menú de Inicio");
    }


    /**
     * Nombre displayOptionsOption2
     * Descripcion  Metodo que muestra las opciones de la opcion2 del Menu principal
     */
    @Override
    public void displayOptionsOption2() {
        System.out.println("\n### Sistema Metro - Visualización del estado actual del sistema de metros  ###");
        System.out.println("Definiciones estructurales de su sistema subido desde archivos");
        System.out.println("Selecciona una opción:");
        System.out.println("1. Desplegar en pantalla el estado actual de la red de metros.");
        System.out.println("2. Retorno al menú de Inicio");
    }


    /**
     * Nombre displayOptionsOption3
     * Descripcion  Metodo que muestra las opciones de la opcion2 del Menu principal
     */
    @Override
    public void displayOptionsOption3() {
        System.out.println("\n### Sistema Metro - Interactuar con el sistema de metros ###");
        System.out.println("A través de las siguientes opciones usted puede interactuar con la red de metros cargada previamente por archivos de texto");
        System.out.println("Selecciona una opción:");
        System.out.println("1. lineLength: obtener el largo total de una línea.");
        System.out.println("2. lineSectionLength: determinar el tracto entre una estación origen y final.");
        System.out.println("3. lineCost: determinar el costo total de recorrer una línea.");
        System.out.println("4. lineSectionCost: determinar el costo de un trayecto entre estación origen y final.");
        System.out.println("5. isLine: verificar si una línea cumple con las restricciones especificadas.");
        System.out.println("6. Train - addCar: añade un carro de pasajeros a un tren en la posición establecida.");
        System.out.println("7. Train - removeCar: remueve un carro de pasajeros de un tren en la posición establecida");
        System.out.println("8. Train - isTrain: verifica si un tren cumple con las especificaciones de los carros de pasajeros.");
        System.out.println("9. Train - fetchCapacity: entrega la capacidad máxima de pasajeros de un tren.");
        System.out.println("10. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del día.");
        System.out.println("11. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
        System.out.println("12. Retorno al menú de Inicio");
    }


}
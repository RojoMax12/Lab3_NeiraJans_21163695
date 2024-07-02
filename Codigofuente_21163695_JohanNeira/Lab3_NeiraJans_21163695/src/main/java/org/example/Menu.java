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


    /**
     * Nombre getUserChoice1
     * Descripcion  Método que obtiene un int por linea de comando
     * @return scanner.nextInt()
     */
    public int getUserChoice1() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada no válida. Por favor, introduce un número: "); // Mensaje en caso de entrada no válida
            scanner.next(); // Consumir la entrada no válida
        }
        return scanner.nextInt();
    }

    /**
     * Nombre getTimeFromUser
     * Descripcion  Método que obtiene un Date por linea de comando
     * @return time
     */
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
            str.trim();
        }

        // Retornar el array de strings obtenidos
        return strings;
    }


    /**
     * Nombre showMenu
     * Descripcion  Método que muestra el Menu pricipal
     * @param subway
     * @param Passengercarlit
     */
    @Override
    public void showMenu(Subway subway, List<PassengerCar> Passengercarlit) {
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
                    option3(cargaDedatos.getSubway(),cargaDedatos, Passengercarlit);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.print("Opción no válida, por favor intenta nuevamente.");
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
                    case 6:
                        System.out.print("\033c");
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
                    System.out.println(subway.toString());
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
     * @param passengerCarList
     */
    @Override
    public void option3(Subway subway, CargaDedatos cargaDedatos, List<PassengerCar> passengerCarList) {
        boolean exit = false;

        while (!exit) {
            displayOptionsOption3();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID de la línea que desea calcular la distancia total: ");
                    int lineId1 = getUserChoice1() - 1;
                    System.out.println("La distancia total de la línea " + subway.getLines().get(lineId1).getId() + " es de: " + subway.getLines().get(lineId1).line_length());
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la línea que desea calcular la distancia por tramos: ");
                    int lineId2 = getUserChoice1() - 1;
                    String[] strings = obtenerStrings();
                    System.out.println("La distancia total del tramo " + strings[0] + " a " + strings[1] + " en la línea " + subway.getLines().get(lineId2).getId() + " es de: " + subway.getLines().get(lineId2).line_section_length(strings[0], strings[1]));
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la línea que desea calcular el costo total: ");
                    int lineId3 = getUserChoice1() - 1;
                    System.out.println("El costo total de la línea " + subway.getLines().get(lineId3).getId() + " es de: " + subway.getLines().get(lineId3).line_cost());
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la línea que desea calcular el costo por tramos: ");
                    int lineId4 = getUserChoice1() - 1;
                    String[] strings1 = obtenerStrings();
                    System.out.println("El costo total del tramo " + strings1[0] + " a " + strings1[1] + " en la línea " + subway.getLines().get(lineId4).getId() + " es de: " + subway.getLines().get(lineId4).line_section_cost(strings1[0], strings1[1]));
                    break;

                case 5:
                    System.out.print("Ingrese el ID de la línea para determinar si cumple los requisitos: ");
                    int lineId5 = getUserChoice1() - 1;
                    System.out.println("¿La línea " + subway.getLines().get(lineId5).getId() + " cumple los requisitos de ser una línea?: " + subway.getLines().get(lineId5).isline(subway.getLines().get(lineId5)));
                    break;

                case 6:
                    System.out.print("Ingrese el ID del tren a modificar: ");
                    int trainId6 = getUserChoice1() - 1;

                    int IdPassenger;
                    boolean idRepetido;

                    do {
                        System.out.print("Ingrese un ID para crear un vagón: ");
                        IdPassenger = getUserChoice1();

                        // Verificar que el ID del PassengerCar no esté repetido en ningún tren
                        idRepetido = false;
                        for (Train train : subway.getTrains()) {
                            for (PassengerCar car : train.getCarList()) {
                                if (car.getId() == IdPassenger) {
                                    idRepetido = true;
                                    break;
                                }
                            }
                            if (idRepetido) {
                                break;
                            }
                        }

                        if (idRepetido) {
                            System.out.println("El ID del vagón ya está en uso. Por favor, ingrese un ID diferente.");
                        }
                    } while (idRepetido);

                    System.out.print("Ingrese la capacidad del vagón: ");
                    int CapacityPassenger = getUserChoice1();

                    System.out.print("Ingrese el modelo del vagón y el creador: ");
                    String[] ModelandVagon = obtenerStrings();

                    System.out.print("Ingrese el tipo de vagón, considere que solo hay 2 tipos CT y TR: ");
                    String[] type = obtenerStrings();

                    System.out.print("En qué posición de los vagones del tren desea introducir el vagón seleccionado, tenga en cuenta que la posición empieza desde 0: ");
                    int position = getUserChoice1();

                    PassengerCar passengerCar;
                    if (type[0].equals("CT")) {
                        passengerCar = new PassengerCar(IdPassenger, CapacityPassenger, ModelandVagon[0], ModelandVagon[1], CarType.CT);
                    } else if (type[0].equals("TR")) {
                        passengerCar = new PassengerCar(IdPassenger, CapacityPassenger, ModelandVagon[0], ModelandVagon[1], CarType.TR);
                    } else {
                        System.out.println("Tipo de vagón no válido.");
                        return;
                    }

                    subway.getTrains().get(trainId6).addCar(passengerCar, position);
                    System.out.println("Tren modificado");
                    break;

                case 7:
                    System.out.print("Ingrese el ID de el tren a modificar: ");
                    int trainId7 = getUserChoice1() - 1;
                    System.out.print("Ingrese la posicion del vagon que desea remover, tenga encuenta que empieza desde el 0 la posicion: ");
                    int positionremove = getUserChoice1();
                    subway.getTrains().get(trainId7).removeCar(subway.getTrains().get(trainId7), positionremove);
                    System.out.println("Tren modificado");
                    break;

                case 8:
                    System.out.print("Ingrese el ID de el tren a para determinar si cumple los requisitos: ");
                    int trainId8 = getUserChoice1() - 1;
                    System.out.println("El tren"+subway.getTrains().get(trainId8).getId() + "cumple los requisitos?: " + subway.getTrains().get(trainId8).isTrain(subway.getTrains().get(trainId8)));
                    break;
                case 9:
                    System.out.print("Ingrese el ID de el tren que desea saber su capacidad maxima: ");
                    int trainId9 = getUserChoice1() - 1;
                    System.out.println("La capacidad maxima del Tren"+subway.getTrains().get(trainId9).getId() + "es de: " + subway.getTrains().get(trainId9).fetchCapacity());
                    break;
                case 10:
                    System.out.print("Ingrese el ID de el tren que saber donde se encuentra: ");
                    int trainId10 = getUserChoice1() - 1;
                    Train train = subway.getTrains().get(trainId10);
                    Date date = getTimeFromUser();
                    subway.whereIsTrain(train, date);
                    break;
                case 11:
                    System.out.print("Ingrese el ID de el tren que saber donde se encuentra: ");
                    int trainId11 = getUserChoice1() - 1;
                    Train train1 = subway.getTrains().get(trainId11);
                    Date date1 = getTimeFromUser();
                    System.out.println("El recorrido faltante del tren es: " + subway.trainPath(train1, date1).toString());
                    break;
                case 12:
                    System.out.print("\033c");
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                case 13:
                    System.out.print("\033c");
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
        System.out.println("6. Borrar la Pantalla");
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
        System.out.println("13. Borrar la pantalla");
    }


}
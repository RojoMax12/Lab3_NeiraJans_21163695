package org.example;

import java.util.List;

public interface UseMenu {

    /**
     * Nombre showMenu
     * Descripcion  Método que muestra el Menu pricipal
     * @param subway
     * @param Passengercarlit
     */
    public void showMenu(Subway subway, List<PassengerCar> Passengercarlit);

    /**
     * Nombre option1
     * Descripcion  Método que genera un y ademas muestra el menu de la opcion1 del Menu principal
     * @param cargaDedatos
     */
    public void option1(CargaDedatos cargaDedatos);

    /**
     * Nombre option2
     * Descripcion Método que genera un el menu y ademas muestra de la opcion2 del Menu principal
     * @param subway
     */
    public void option2(Subway subway);

    /**
     * Nombre option3
     * Descripcion  Método que genera un menu y ademas muestra de la opcion3 del Menu principal
     * @param subway
     * @param cargaDedatos
     * @param passengerCarlit
     */
    public void option3(Subway subway, CargaDedatos cargaDedatos, List<PassengerCar> passengerCarlit);

    /**
     * Nombre displayOptionsInicio
     * Descripcion  Metodo que muestra las opciones del Menu principal
     */
    public void displayOptionsInicio();

    /**
     * Nombre displayOptionsOption1
     * Descripcion  Metodo que muestra las opciones de la opcion1 del Menu principal
     */
    public void displayOptionsOption1();

    /**
     * Nombre displayOptionsOption2
     * Descripcion  Metodo que muestra las opciones de la opcion2 del Menu principal
     */
    public void displayOptionsOption2();

    /**
     * Nombre displayOptionsOption3
     * Descripcion  Metodo que muestra las opciones de la opcion2 del Menu principal
     */
    public void displayOptionsOption3();


}
